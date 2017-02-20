function cadastroController($scope, $http, $routeParams, $location) {

}
function detailsVenda($scope, $http) {
	$scope.funcionario = [];
	var getFuncionario = function() {
		$http.get(SERVER_URL + '/funcionario/listFuncionario').success(
				function(data) {
					$scope.funcionario = data;

					// $.each($scope.funcionario,function(index, fun){
					// $.each(fun,function(index, value){
					// console.log(fun.apelido);
					// $scope.funcionario.push(fun.apelido);
					// });
					// });

				});
	};
	getFuncionario();

}

function consultarOSController($scope, $http, $routeParams, $location, ObjectFactory) {

	$scope.currentPage = 1;
	$scope.pageSize = 5;
	$scope.listaOS = null;
	$scope.editableInput = "m";
	$scope.cpf = $routeParams.cpf;
	$scope.os = null;
	$scope.obj = null;
	$scope.dataInicio = '';
	$scope.registrar = false;
	$scope.clienteSelecionado = false;
	$scope.parametros = {
		nomeCliente : '',
		cpfCliente : '',
		dataVenda: null,
		telefoneCliente : 0,
		numeroOS : '',
		veiculoModelo : '',
		veiculoMarca : '',
		veiculoPlaca : '',
		valorTotal : 0,
		listaItem : null
	};

	if ($scope.cpf != null) {
		$scope.parametros.cpfCliente = $scope.cpf;
		$scope.clienteSelecionado = true;
		$http.post($scope.server("/venda/CarregarListaOS"), $scope.parametros)
				.success(function(data) {
					$scope.parametros.nomeCliente = data[0].nomeCliente;
//					console.log(data[0].nomeCliente);
					$scope.listaOS = data;
				}).error(function(data) {
					alert("Error…");
					console.log(data);
				});
	}
	;

	// $http.get($scope.server("/venda/CarregarListaOS")).success(function(data)
	// {
	// $scope.listaOS = data;
	// }).error(function(data) {
	// alert("Error ao trazer Lista de OS!");
	// console.log(data);
	// });

	$scope.consultarOS = function() {

		$http.post($scope.server("/venda/CarregarListaOS"), $scope.parametros)
				.success(function(data) {
					console.log('trouce?');
					console.log(data);
					$scope.listaOS = data;
				}).error(function(data) {
					alert("Error…");
					console.log(data);
				});
		console.log('fim??');

	};	

	$scope.consultarDetalhesOS = function(os) {

		$scope.obj = os;
		$scope.valorTotalLista = os.valorTotal;
		console.log($scope.obj);
		$scope.itemsVenda = [];
		$scope.itemVenda = {
			modelo : "",
			qtd : "",
			Valor : "",
			garantia : "",
			funcionario : "",
			tipo : ""
		};

		$http.post($scope.server("/venda/CarregarDetalhesOS"), os.codigoVenda)
				.success(function(data) {
					console.log('trouce?');
					console.log(data);
					$scope.itemsVenda = data;
				}).error(function(data) {
					alert("Error…");
					console.log(data);
				});
	};

	
	/*
	 * ---CALENDARIO-------------------------------------------------------------
	 */
	  $scope.open = function($event) {
	    $event.preventDefault();
	    $event.stopPropagation();
	    $scope.opened = true;
	  };
	  $scope.dateOptions = {
	    formatYear: 'yy',
	    startingDay: 1
	  };
	  $scope.format ='dd/MM/yyyy';
	  $scope.minDate = $scope.minDate ? null : new Date();
	/*
	 * -----------------------------------------------------------------
	 */
	
}

// }

function OtherController($scope) {
	$scope.pageChangeHandler = function(num) {
		// console.log('paginas ' + num);
	};
}

function registrarVendaController($scope, $http, $routeParams, $location,
		ObjectFactory) {

	$scope.cabecalho = "Registrar Venda";
	$scope.botao = "Registrar";
	detailsVenda($scope, $http);
	$scope.editableInput = "m";
	$scope.cliente = null;
	$scope.registrar = true;
	$scope.orcamento = false;
	$scope.numeroOSVenda= 0;
	$scope.codigoOrcamento = $routeParams.codigoOrcamento;
	$scope.obj = {
		numeroOS : 0
	};
	$scope.DataMinimaOrcamento = new Date();
	$scope.DataFinalOrcamento = new Date();
	$scope.inflectorType = 'humanize';
	$scope.DataFinal;
	/*
	 * ---CALENDARIO-------------------------------------------------------------
	 */
	  $scope.open = function($event) {
	    $event.preventDefault();
	    $event.stopPropagation();
	    $scope.opened = true;
	  };
	  $scope.dateOptions = {
	    formatYear: 'yy',
	    startingDay: 1
	  };
	  $scope.format ='dd/MM/yyyy';
	  $scope.minDate = new Date();
	/*
	 * -----------------------------------------------------------------
	 */
	  

		$scope.consultaQuantidade = function(obj) {
			$.each($scope.produtos, function(index, produto) {
				if (obj.codigo == produto.codigo) {
//					console.log("quantidade produto: " + produto.quantidade);
					if (obj.quantidadeVenda > produto.quantidade
							|| obj.quantidadeVenda < 0) {
						alert('Quantidade ultrapassou o estoque');
						obj.quantidadeVenda = 0;
					}
				}
			});
			$scope.somarValorTotal();
		}; 
	  
	$scope.itemsVenda = [];
	$scope.itemVenda = {
		modelo : "",
		qtd : "",
		Valor : "",
		garantia : "",
		funcionario : "",
		tipo : ""
	};
	$scope.valorTotalLista = 0;

	$scope.currentPage = 1;
	$scope.pageSize = 3;

	$scope.produtos = null;
	$scope.produto = null;
	$scope.listaProdutosVenda = [];
	$scope.listaMaoObraVenda = [];

	$scope.obj.numeroOS = 0;
	$http.get($scope.server("/venda/CarregarNumeroOS")).success(function(data) {
		$scope.obj.numeroOS = data;
		$scope.numeroOSVenda = data;
	}).error(function(data) {
		alert("Error ao trazer numero OS!");
		console.log(data);
	});

	// carrega lista de todos os produtos disponiveis
	$http.get($scope.server("/produto/listProduto")).success(function(data) {
		$scope.produtos = data;
	}).error(function(data) {
		alert("Error…");
		console.log(data);
	});
	// for (var i = 1; i <= 100; i++) {
	// $scope.produtos;
	// };

	$scope.consultarClientePorCPF = function(obj) {
		var cpf = obj;
		if (cpf != null) {
			var tamanhoCPF = cpf.length;
			if (tamanhoCPF == 11) {
				ObjectFactory.getObject('/cliente/clientCpf/', cpf).success(
						function(data) {
							if (data.cpf != null) {
								$scope.obj.nomeCliente = data.nome;
								$scope.obj.cpfCliente = data.cpf;
								$scope.obj.telefoneCliente = data.telefone;
								$scope.obj.veiculoMarca = data.marca;
								$scope.obj.veiculoModelo = data.modelo;
								$scope.obj.veiculoPlaca = data.placa;
								console.log($scope.obj);
							} else {
								$scope.obj.cpfCliente = cpf;
							}

						}).error(function(data) {
					alert("Error…");
					console.log(data);
				});
			} else {
				$scope.obj = null;
			}
		} else {
			$scope.obj.nomeCliente = null;
			$scope.obj.telefoneCliente = null;
			$scope.obj.veiculoMarca = null;
			$scope.obj.veiculoModelo = null;
			$scope.obj.veiculoPlaca = null;
		}

	};
	
	$scope.somarValorTotal = function() {

		$scope.valorTotalLista = 0;
		$.each($scope.itemsVenda, function(index, item) {
			var valorFinalItem;
			console.log(item);
			item.quantidade = item.quantidade * 1;
			if(item.tipo == 'p'){
				if (item.quantidade > 0 || item.quatidadeVenda != 0) {
					console.log('quantidade: ' + item.quantidade);
					valorFinalItem = item.valor * item.quantidadeVenda;
				} else {
					console.log('nao entrou');
					valorFinalItem = item.valor * 1;
				}
			}else if(item.tipo == 'm'){
				console.log('mao : ' + item.valor);
				valorFinalItem = item.valor * 1;
			}

			$scope.valorTotalLista = $scope.valorTotalLista + valorFinalItem;
		});
	};
	
	if($scope.codigoOrcamento != null){
		$scope.parametros = {
				codigoOrcamento : null,
				nomeCliente : '',
				cpfCliente : '',
				telefoneCliente : 0,
				veiculoModelo : '',
				veiculoMarca : '',
				veiculoPlaca : '',
				valorTotal : 0,
				listaItem : null
			};
		$scope.listaOS = {};
		$scope.parametros.codigoOrcamento = $scope.codigoOrcamento;
		
		$http.post($scope.server("/venda/CarregarListaOrcamento"), $scope.parametros)
		.success(function(data) {
			$scope.listaOS = data;
			$.each($scope.listaOS,function(index, os){ 
				console.log($scope.codigoOrcamento);
				if(os.codigoOrcamento == $scope.codigoOrcamento){
					$scope.obj.nomeCliente = os.nomeCliente;
					$scope.obj.cpfCliente = os.cpfCliente;
					$scope.obj.telefoneCliente = os.telefoneCliente;
					$scope.obj.veiculoMarca = os.veiculoMarca;
					$scope.obj.veiculoModelo = os.veiculoModelo;
					$scope.obj.veiculoPlaca = os.veiculoPlaca;
					$scope.valorTotalLista = 0 + os.valorTotal;
//					console.log('OBJECTO: ');
//					console.log($scope.obj);
				};
			});
			
			
		}).error(function(data) {
			alert("Error…");
			console.log(data);
		});
		
			console.log($scope.valorTotalLista);
			$scope.DataFinalOrcamento = new Date(os.dataValidade);	
			$http.post($scope.server("/venda/CarregarDetalhesOrcamento"), $scope.codigoOrcamento)
					.success(function(data) {
						$scope.itemsVenda = data;
						console.log($scope.itemsVenda);
						$.each($scope.itemsVenda, function(index, itemVenda) {
							console.log('repeticao');
							$scope.consultaQuantidade(itemVenda);
							});
					}).error(function(data) {
						alert("Error…");
						console.log(data);
					});
	}

	$scope.adicionarMaoObra = function() {
		$scope.itemVenda = {
			modelo : "",
			quantidadeVenda : 0,
			valor : 0,
			garantia : 0,
			funcionario : "",
			tipo : "m"
		};
		$scope.itemsVenda.push($scope.itemVenda);
	};

	$scope.gerarOS = function() {
		$scope.botaoFinal = 'Concluir Venda';
		$scope.registrar = true;
		$scope.orcamento = false;
//		console.log($scope.orcamento);
		$scope.adicionarNomeFuncionario();
		
	};
	$scope.gerarOrcamento = function() {
		$scope.botaoFinal = 'Salvar Orçamento';
		$scope.orcamento = true;
		$scope.registrar = true;
		$scope.adicionarNomeFuncionario();
	};

	$scope.adicionarNomeFuncionario = function() {
		$scope.obj.numeroOS = $scope.numeroOSVenda;
		$.each($scope.itemsVenda, function(index, item) {
			$.each($scope.funcionario, function(index, func) {
				if (item.funcionario == func.codigo) {
					item.noFuncionario = func.apelido;
				}
			});
		});
	};

	$scope.adicionarProdutoComissao = function(obj) {
		if (obj.quantidade > 0) {
			var index = $scope.itemsVenda.indexOf(obj);
			if (index == -1) {
				// obj.tipo = "p";
				// $scope.novoItem = obj.valueOf();
				$scope.novoItem = {
					modelo : obj.modelo,
					quantidadeVenda : 1 * 1,
					valor : obj.valor,
					garantia : 0,
					funcionario : "",
					tipo : "p",
					codigo : obj.codigo,
					quantidade : obj.quantidade
				};
				// console.log($scope.novoItem);
				// $scope.novoItem.quantidadeVenda = 1;
				$scope.valorTotalLista += $scope.novoItem.valor;

				$scope.itemsVenda.push($scope.novoItem);
			} else {
				alert('Produto ja existe na lista: ' + obj.modelo);
			}
		} else {
			alert('Produto indisponivel!\n Favor fazer pedido ao fornecedor.');
		}
	};

	$scope.removerItemVenda = function(obj) {
		var index = $scope.itemsVenda.indexOf(obj);
		$scope.itemsVenda.splice(index, 1);
		$scope.somarValorTotal();
	};

	

	$scope.send = function(obj) {
		obj.valorTotal = $scope.valorTotalLista;
		obj.dataVenda = new Date();
		// console.log('começou');
		// console.log(obj);
		$scope.venda = null;

		$.each($scope.itemsVenda, function(index, item) {
			console.log(item);
		});

		$scope.venda = {
			nomeCliente : obj.nomeCliente,
			cpfCliente : obj.cpfCliente,
			telefoneCliente : obj.telefoneCliente,
			numeroOS : $scope.obj.numeroOS,
			dataVenda : obj.dataVenda,
			veiculoModelo : obj.veiculoModelo,
			veiculoMarca : obj.veiculoMarca,
			veiculoPlaca : obj.veiculoPlaca,
			valorTotal : obj.valorTotal,
			listaItem : $scope.itemsVenda
		};
		
		console.log('Data Final: ' + $scope.DataFinal);
		$scope.orcamentoFinal = {
			nomeCliente : obj.nomeCliente,
			cpfCliente : obj.cpfCliente,
			telefoneCliente : obj.telefoneCliente,
			dataValidade : $scope.DataFinalOrcamento,
			veiculoModelo : obj.veiculoModelo,
			veiculoMarca : obj.veiculoMarca,
			veiculoPlaca : obj.veiculoPlaca,
			valorTotal : obj.valorTotal,
			listaItem : $scope.itemsVenda
		};

		console.log("Olha data: " + $scope.orcamentoFinal.dataValidade);
		console.log($scope.orcamentoFinal);
		// $scope.separarItensListaFinal();

		// console.log('Carregando listas -- INICIO');
		// ObjectFactory.postTo('/venda/carregarListaProduto/',
		// $scope.listaProdutosVenda);
		// ObjectFactory.postTo('/venda/carregarListaMaoObra/',
		// $scope.listaMaoObraVenda);
		// console.log('Carregando listas -- FIM');
		console.log('Registrando venda -- INICIO --');
		if ($scope.orcamento == true) {
			console.log('chegou aqui');
			ObjectFactory.postTo('/venda/salvarOrcamento/',
					$scope.orcamentoFinal).success(function(data) {
				if (data === 'true') {
					alert('Orçamento registrado com sucesso');
					location.reload();
				} else {
					alert('Orçamento já Registrado');
				}
			});
		} else if ($scope.orcamento == false) {
			console.log('chegou aqui 2');
			ObjectFactory.postTo('/venda/salvar/', $scope.venda).success(
					function(data) {
						if (data === 'true') {
							alert('Venda registrada com sucesso');
							location.reload();
						} else {
							alert('Venda já Registrada');
						}
					});
//			location.reload();
			console.log('chegou aqui fim');
			console.log('Registrando venda -- FIM');
		}
		;
	};

	$scope.separarItensListaFinal = function() {
		console.log('separando itens da lista -- INICIO');
		$.each($scope.itemsVenda, function(index, item) {
			console.log('tipo---');
			console.log(item.tipo);
			if (item.tipo == "m") {
				$scope.mo = {
					codigoFuncionaio : item.funcionario,
					valorMO : item.valor,
					descMO : item.modelo
				};
				$scope.listaMaoObraVenda.push($scope.mo);
				console.log('MO: ' + $scope.mo);
			} else if (item.tipo == "p") {
				$scope.valorFormatado = item.valor * 1;
				$scope.prod = {
					codigoFuncionaio : item.funcionario,
					vlVenda : $scope.valorFormatado,
					qtdProd : item.quantidadeVenda,
					garantiaProd : item.garantia,
					cdProd : item.codigo
				};
				console.log($scope.prod);
				$scope.listaProdutosVenda.push($scope.prod);
				console.log('prod: ' + $scope.prod);
			}
		});
		console.log('separando itens da lista -- FIM');
	};
	
	$scope.excluirOS = function(obj) {
		$http.post($scope.server("/venda/excluirOS"), obj).success(
				function(data) {
					if (data === 'true') {
						alert('OS Excluida com Sucesso!');
						$location.path('/');
					} else {
						alert('Erro ao excluir');
					}
				});
	};
}

function alterarVendaController($scope, $http, $routeParams, $location,
		ObjectFactory) {

	$scope.cabecalho = "Alterar Venda";
	$scope.botao = "Alterar";
	detailsVenda($scope, $http);

	getObj($scope, $routeParams, ObjectFactory, '/venda/buscar/',
			$routeParams.codigo);

	$scope.send = function(obj) {
		console.log(obj);
		ObjectFactory.postTo('/venda/alterar/', obj).success(function(data) {
			if (data === 'true') {
				alert('Venda ' + obj.modelo + ' alterado com sucesso!');
				$location.path('/venda/consultar');
			} else {
				alert('Venda já cadastrado');
			}
		});
	};
}

function ExcluirVendaController($scope, $http, $routeParams, $location,
		ObjectFactory) {

	$scope.send = function(obj) {
		ObjectFactory.postTo('/venda/excluir/', obj).success(function(data) {
			if (data === 'true') {
				$location.path('/enda/consultar');
			} else {
				alert('Erro ao Excluir Venda');
			}
		});
	};
}

function getObj($scope, $routeParams, ObjectFactory, url, id) {
	$scope.obj = {};
	console.log('3');

	// $scope.showDetails = function() {
	// $rootScope.modal.open('loading.html');

	ObjectFactory.getObject(url, id).success(function(data) {
		$scope.obj = data;
		console.log(data);
		// $rootScope.modal.cancel();
	});
	// };

	// $scope.showDetails();
}

function postTo($http, $location, ObjectFactory, url, obj, callbackUrl) {
	ObjectFactory.postTo(url, obj).success(function(data) {
		$location.path(callbackUrl);
	});
}


/*
 * Orcamento
 */

function consultarOrcamentoController($scope, $http, $routeParams, $location) {
	$scope.currentPage = 1;
	$scope.pageSize = 5;
	$scope.listaOS = null;
	$scope.editableInput = "m";
	$scope.consulta = true;
	$scope.cpf = $routeParams.cpf;
	$scope.os = null;
	$scope.obj = null;
	$scope.dataInicio;
	$scope.registrar = false;
	$scope.orcamento = true;
	$scope.clienteSelecionado = false;
	$scope.parametros = {
		codigoOrcamento: 0,
		nomeCliente : '',
		cpfCliente : '',
		telefoneCliente : 0,
		veiculoModelo : '',
		veiculoMarca : '',
		veiculoPlaca : '',
		valorTotal : 0,
		listaItem : null
	};
	console.log($scope.cpf);

	if ($scope.cpf != null) {
		$scope.parametros.cpfCliente = $scope.cpf;
		$scope.clienteSelecionado = true;
		$http.post($scope.server("/venda/CarregarListaOrcamento"), $scope.parametros)
				.success(function(data) {
					console.log(data);
					$scope.listaOS = data;
				}).error(function(data) {
					alert("Error…");
					console.log(data);
				});
	}	;

	
	$scope.excluirOrcamento = function(obj) {
		$http.post($scope.server("/venda/excluirOrcamento"), obj).success(
				function(data) {
					console.log('retornor ' + data);
					if (data === 'true') {
						console.log('agora vai dar um refresh');
						alert('Orcamento Excluido com Sucesso!');
						$location.path('/');
					} else {
						alert('Erro ao excluir');
					}
				});
	};
	// $http.get($scope.server("/venda/CarregarListaOS")).success(function(data)
	// {
	// $scope.listaOS = data;
	// }).error(function(data) {
	// alert("Error ao trazer Lista de OS!");
	// console.log(data);
	// });

	$scope.consultarOS = function() {
		console.log($scope.parametros);

		$http.post($scope.server("/venda/CarregarListaOrcamento"), $scope.parametros)
				.success(function(data) {
					$scope.listaOS = data;
				}).error(function(data) {
					alert("Error…");
					console.log(data);
				});
	};

	$scope.consultarDetalhesOS = function(os) {
		$scope.obj = os;
		$scope.valorTotalLista = os.valorTotal;
		$scope.DataFinalOrcamento = new Date(os.dataValidade);
		$scope.itemsVenda = [];
		$scope.itemVenda = {
			modelo : "",
			qtd : "",
			Valor : "",
			garantia : "",
			funcionario : "",
			tipo : ""
		};
		$http.post($scope.server("/venda/CarregarDetalhesOrcamento"), os.codigoOrcamento)
				.success(function(data) {
					console.log('trouce?');
					console.log(data);
					$scope.itemsVenda = data;
				}).error(function(data) {
					alert("Error…");
					console.log(data);
				});
	};
	$scope.efetuarOrcamento = function(codigoOrcamento) {
		$location.path('/venda/efetuarOrcamento/' + codigoOrcamento);
	};
	/*
	 * ---CALENDARIO-------------------------------------------------------------
	 */
	  $scope.open = function($event) {
	    $event.preventDefault();
	    $event.stopPropagation();
	    $scope.opened = true;
	  };
	  $scope.dateOptions = {
	    formatYear: 'yy',
	    startingDay: 1
	  };
	  $scope.format ='dd/MM/yyyy';
	/*
	 * -----------------------------------------------------------------
	 */
}