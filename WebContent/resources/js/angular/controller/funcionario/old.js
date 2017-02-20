function cadastroController($scope, $http, $routeParams, $location){
	
}
function detailsFuncionario($scope, $http) { 
	$scope.tipoSexo = [];
	    var getTipoSexo = function () {
	        $http.get(SERVER_URL + '/funcionario/tipoSexo').success(function (data) {
	            $scope.tipoSexo = data;
	        });
	    };
	    getTipoSexo();
	    
}
function consultarFuncionarioController($scope, $http, $routeParams, $location) {
	
	$scope.currentPage = 1;
	$scope.pageSize = 3;

	$scope.funcionarios = null;
	$scope.funcionario = null;

	// @scope.loadAll = function(){
	$http.get($scope.server("/funcionario/listFuncionario")).success(function(data) {
		$scope.funcionarios = data;
		console.log($scope.funcionarios);
	}).error(function(data) {
		alert("Error…");
		console.log(data);
	});

//	for (var i = 1; i <= 100; i++) {
//
//		$scope.funcionarios;
//	}
	
	$scope.visualizar = function(codigo) {
		$location.path('funcionario/visualizar/' + codigo);
	};
	
	$scope.alterar = function(codigo) {
		$location.path('funcionario/alterar/' + codigo);
	};
	
	$scope.excluir = function(obj) {
        	 $http.post($scope.server("/funcionario/excluir"), obj.codigo).success(function(data) {
        		 if (data === 'true') {
        			 alert('Funcionario Excluido com Sucesso!');
        			 $location.path('/funcionario/consultar');
        		 }else{
        			 alert('Erro ao excluir');
        		 }
            });
	};
	
	$scope.comissao = function(codigo) {
		console.log(codigo);
		$location.path('funcionario/comissao/' + codigo);
	};
	
}
// }



function OtherController($scope) {
	$scope.pageChangeHandler = function(num) {
		// console.log('paginas ' + num);
	};
}

function comissaoFuncionarioController($scope, $http, $routeParams, $location, ObjectFactory){
	$scope.botao = "Salvar";
	
	$scope.produtosComissao = [];
	$scope.produtoComissao;
	
	$scope.currentPage = 1;
	$scope.pageSize = 3;
	
	$scope.produtos = null;
	$scope.produto = null;
	
	$scope.cdFuncionario = $routeParams.codigo;
	console.log($scope.cdFuncionario);
	
	//carrega lista de todos os produtos vinculado ao funcionario
	$http.get($scope.server('/funcionario/listProdutoComissao/' + $scope.cdFuncionario)).success(function(data) {
		$scope.produtosComissao = data;
	}).error(function(data) {
		alert("Error…");
		console.log(data);
	});
	
	//carrega lista de todos os produtos disponiveis
	$http.get($scope.server("/funcionario/listProduto")).success(function(data) {
		$scope.produtos = data;
	}).error(function(data) {
		alert("Error…");
		console.log(data);
	});
	
	$scope.adicionarProdutoComissao = function(obj){
			var validaProdLista = 0;
			//percorre lista de produtosComissao e valida se o produto que esta sendo adicionado ja se encontra na lista
			$.each($scope.produtosComissao,function(index, prod){ 
				$.each(prod,function(index, value){ 				
					if(obj.cdProduto == prod.cdProduto){
						validaProdLista = 1;
					}
				});
			});
			if(validaProdLista == 0){
				$scope.produtosComissao.push(obj);
			}else{
				alert('Produto ja existe na lista: ' + obj.modelo);
			}
	};
	$scope.removerProdutoComissao = function(obj){
		var index = $scope.produtosComissao.indexOf(obj);
		$scope.produtosComissao.splice(index,1);
	};
	$scope.atualizarItemComissao = function(obj){
		
	};
	$scope.salvar = function(produtosComissao) {
		console.log(produtosComissao);
		console.log('aiai');
		ObjectFactory.postTo('/funcionario/salvarComissao/', $scope.produtosComissao).success(function(data) {
			if (data === 'true') {
				alert('Alteração feita com sucesso');
				
			} else {
				alert('Erro ao gravar alteração');
			}
		});
	};		
}



function cadastrarFuncionarioController($scope, $http, $routeParams, $location,
		ObjectFactory) {
	
	$scope.cabecalho = "Cadastrar Funcionario";
	$scope.botao = "Cadastrar";
	$scope.botao2 = 'Cancelar';
	detailsCliente($scope, $http);
	

		$scope.send = function(obj) {
			ObjectFactory.postTo('/funcionario/salvar/', obj).success(function(data) {
				if (data === 'true') {
					alert('Funcionario ' + obj.modelo + ' cadastrado com sucesso');
					$location.path('/');
				} else {
					alert('Funcionario já cadastrado');
				}
			});
		};
   }

function visualizarFuncionarioController($scope, $http, $routeParams, $location,
		ObjectFactory) {
	
	$scope.cabecalho = "Visualizar Funcionario";
	$scope.botao2 = 'Voltar';
	$scope.isVisualizar = "true";
	detailsFuncionario($scope, $http);
	
	getObj($scope, $routeParams, ObjectFactory, '/funcionario/buscar/',
			$routeParams.codigo);
}

function alterarFuncionarioController($scope, $http, $routeParams, $location,
		ObjectFactory) {
	
	$scope.cabecalho = "Alterar Funcionario";
	$scope.botao = "Alterar";
	$scope.botao2 = 'Cancelar';
	detailsFuncionario($scope, $http);
	
	getObj($scope, $routeParams, ObjectFactory, '/funcionario/buscar/',
			$routeParams.codigo);
	
	$scope.send = function(obj) {
		console.log(obj);
		ObjectFactory.postTo('/funcionario/alterar/', obj).success(function(data) {
			if (data === 'true') {
				alert('Funcionario ' + obj.nome + ' alterado com sucesso!');
				$location.path('/funcionario/consultar');
			} else {
				alert('Funcionario já cadastrado');
			}
		});
	};
}

function ExcluirFuncionarioController($scope, $http, $routeParams, $location,
		ObjectFactory) {
	
	$scope.send = function(obj) {
		ObjectFactory.postTo('/funcionario/excluir/', obj).success(function(data) {
			if (data === 'true') {
				$location.path('/funcionario/consultar');
			} else {
				alert('Erro ao Excluir Funcionario');
			}
		});
	};
}


function getObj($scope, $routeParams, ObjectFactory, url, id) {
	$scope.obj = {};
	console.log('3');

//	$scope.showDetails = function() {
//		$rootScope.modal.open('loading.html');

		ObjectFactory.getObject(url, id).success(function(data) {
			$scope.obj = data;
			console.log(data);
//			$rootScope.modal.cancel();
		});
//	};

//	$scope.showDetails();
}

function postTo($http, $location, ObjectFactory, url, obj, callbackUrl) {
	ObjectFactory.postTo(url, obj).success(function(data) {
		$location.path(callbackUrl);
	});
}
