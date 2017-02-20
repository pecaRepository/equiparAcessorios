function cadastroController($scope, $http, $routeParams, $location) {

}
function detailsProduto($scope, $http) {
	$scope.tipoSexo = [];
	var getTipoSexo = function() {
		$http.get(SERVER_URL + '/cliente/tipoSexo').success(function(data) {
			$scope.tipoSexo = data;
		});
	};
	getTipoSexo();

}

function visualizarProdutoController($scope, $http, $routeParams, $location,
		ObjectFactory) {

	$scope.cabecalho = "Visualizar Produto";
	$scope.isVisualizar = "true";
	$scope.botao2 = 'Voltar';

	getObj($scope, $routeParams, ObjectFactory, '/produto/buscar/',
			$routeParams.codigo);
}

function consultarProdutoController($scope, $http, $routeParams, $location) {

	$scope.currentPage = 1;
	$scope.pageSize = 5;

	$scope.produtos = null;
	$scope.produto = null;
	
	$http.get($scope.server("/produto/listCategoria")).success(function(data) {
		$scope.categorias = data;
	}).error(function(data) {
		alert("Error…");
		console.log(data);
	});
	
	$scope.teste = function(categoria) {
		$.each($scope.categorias,function(index, cat){
			if(categoria == cat.codigo){
				console.log('entrou');
				console.log(cat.nome);
				$scope.categ = cat.nome;
				
			}
		});
		return $scope.categ;
		
	};

	$scope.visualizar = function(codigo) {
		$location.path('produto/visualizar/' + codigo);
	};

	$scope.alterar = function(codigo) {
		$location.path('produto/alterar/' + codigo);
	};

	$scope.excluir = function(obj) {
		if(obj.quantidade == 0) {
			$http.post($scope.server("/produto/excluir"), obj).success(
					function(data) {
						console.log('retornor ' + data);
						if (data === 'true') {
							console.log('agora vai dar um refresh');
							alert('Produto Excluido com Sucesso!');
							$location.path('/');
						} else {
							alert('Erro ao excluir');
						}
					});
		}else{
			alert('Não é possivel excluir um produto em estoque.');
		}

	};

	// @scope.loadAll = function(){

	$http.get($scope.server("/produto/listProduto")).success(function(data) {
		$scope.produtos = data;
	}).error(function(data) {
		alert("Error…");
		console.log(data);
	});

	for (var i = 1; i <= 100; i++) {

		$scope.produtos;
	}
}
// }

function OtherController($scope) {
	$scope.pageChangeHandler = function(num) {
		// console.log('paginas ' + num);
	};
}

function cadastrarProdutoController($scope, $http, $routeParams, $location,
		ObjectFactory) {

	$scope.cabecalho = "Cadastrar Produto";
	$scope.botao = "Cadastrar";
	$scope.botao2 = 'Cancelar';
	$scope.categorias = null;
	detailsCliente($scope, $http);
	
	$http.get($scope.server("/produto/listCategoria")).success(function(data) {
		$scope.categorias = data;
	}).error(function(data) {
		alert("Error…");
		console.log(data);
	});

	$scope.send = function(obj) {
		ObjectFactory.postTo('/produto/salvar/', obj).success(function(data) {
			if (data === 'true') {
				alert('Produto ' + obj.modelo + ' cadastrado com sucesso');
				$location.path('/');
			} else {
				alert('Produto já cadastrado');
			}
		});
	};
}

function alterarProdutoController($scope, $http, $routeParams, $location,
		ObjectFactory) {
	console.log('2');

	$scope.cabecalho = "Alterar Produto";
	$scope.botao = "Alterar";
	$scope.botao2 = 'Voltar';
	detailsProduto($scope, $http);
	
	$http.get($scope.server("/produto/listCategoria")).success(function(data) {
		$scope.categorias = data;
	}).error(function(data) {
		alert("Error…");
		console.log(data);
	});

	getObj($scope, $routeParams, ObjectFactory, '/produto/buscar/',
			$routeParams.codigo);

	$scope.send = function(obj) {
		console.log(obj);
		ObjectFactory.postTo('/produto/alterar/', obj).success(function(data) {
			if (data === 'true') {
				alert('Produto ' + obj.modelo + ' alterado com sucesso!');
				$location.path('/produto/consultar');
			} else {
				alert('Produto já cadastrado');
			}
		});
	};
}

function ExcluirProdutoController($scope, $http, $routeParams, $location,
		ObjectFactory) {

	$scope.send = function(obj) {
		ObjectFactory.postTo('/produto/excluir/', obj).success(function(data) {
			if (data === 'true') {
				$location.path('/produto/consultar');
			} else {
				alert('Erro ao Excluir Produto');
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
 * CATEGORIA PRODUTO
*/
function consultarCategoriaController($scope, $http, $routeParams, $location) {

	$scope.currentPage = 1;
	$scope.pageSize = 5;
	$scope.categorias = null;
	$scope.categoria = null;
	

	$http.get($scope.server("/produto/listCategoria")).success(function(data) {
		$scope.categorias = data;
	}).error(function(data) {
		alert("Error…");
		console.log(data);
	});
	
	$scope.adicionar = function() {
		$location.path('produto/cadastrarCategoria');
	};
	
	$scope.visualizar = function(codigo) {
		$location.path('produto/visualizarCategoria/' + codigo);
	};

	$scope.alterar = function(codigo) {
		$location.path('produto/alterarCategoria/' + codigo);
	};

	$scope.excluir = function(obj) {
		$http.post($scope.server("/produto/excluirCategoria"), obj).success(
				function(data) {
					console.log('retornor ' + data);
					if (data === 'true') {
						console.log('agora vai dar um refresh');
						alert('Categoria Excluido com Sucesso!');
						$location.path('/');
					} else {
						alert('Erro ao excluir\n Verifique se não existe um produto com esta categoria');
					}
				});
	};
}


function alterarCategoriaController($scope, $http, $routeParams, $location,
		ObjectFactory) {

	$scope.cabecalho = "Alterar Categoria";
	$scope.botao = "Alterar";
	$scope.botao2 = 'Voltar';
	detailsProduto($scope, $http);

	getObj($scope, $routeParams, ObjectFactory, '/produto/buscarCategoria/',
			$routeParams.codigo);

	$scope.send = function(obj) {
		console.log(obj);
		ObjectFactory.postTo('/produto/alterarCategoria/', obj).success(function(data) {
			if (data === 'true') {
				alert('Categoria alterada com sucesso!');
				$location.path('/produto/consultarCategoria');
			} else {
				alert('Categoria já cadastrada');
			}
		});
	};
}

function visualizarCategoriaController($scope, $http, $routeParams, $location,
		ObjectFactory) {

	$scope.cabecalho = "Visualizar Categoria";
	$scope.isVisualizar = "true";
	$scope.botao2 = 'Voltar';

	getObj($scope, $routeParams, ObjectFactory, '/produto/buscarCategoria/',
			$routeParams.codigo);
}

function cadastrarCategoriaController($scope, $http, $routeParams, $location,
		ObjectFactory) {

	$scope.cabecalho = "Cadastrar Categoria";
	$scope.botao = "Cadastrar";
	$scope.botao2 = 'Cancelar';
	$scope.categorias = null;
	detailsCliente($scope, $http);

	$scope.send = function(obj) {
		ObjectFactory.postTo('/produto/salvarCategoria/', obj).success(function(data) {
			if (data === 'true') {
				alert('Categoria cadastrada com sucesso');
				$location.path('/');
			} else {
				alert('Categoria já cadastrado');
			}
		});
	};
}