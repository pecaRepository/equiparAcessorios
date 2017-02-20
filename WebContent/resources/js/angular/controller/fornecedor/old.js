function cadastroController($scope, $http, $routeParams, $location){
	
}
function detailsFornecedor($scope, $http) { 
	$scope.tipoSexo = [];
	    var getTipoSexo = function () {
	        $http.get(SERVER_URL + '/fornecedor/tipoSexo').success(function (data) {
	            $scope.tipoSexo = data;
	        });
	    };
	    getTipoSexo();
	    
}
function consultarFornecedorController($scope, $http, $routeParams, $location) {

	$scope.currentPage = 1;
	$scope.pageSize = 5;

	$scope.fornecedores = null;
	$scope.fornecedor = null;
	
	$scope.visualizar = function(codigo) {
		$location.path('fornecedor/visualizar/' + codigo);
	};
	
	$scope.alterar = function(codigo) {
		$location.path('fornecedor/alterar/' + codigo);
	};
	
	$scope.excluir = function(obj) {
        	 $http.post($scope.server("/fornecedor/excluir"), obj).success(function(data) {
        		 if (data === 'true') {
        			 console.log('agora vai dar um refresh');
        			 alert('Fornecedor Excluido com Sucesso!');
        			 $location.path('/');
        		 }else{
        			 alert('Erro ao excluir');
        		 }
            });
	};


	// @scope.loadAll = function(){
	console.log('Consultando Fornecedor');
	$http.get($scope.server("/fornecedor/listfornecedor")).success(function(data) {
		$scope.fornecedores = data;
		
	}).error(function(data) {
		alert("Error…");
		console.log(data);
	});

}
// }

function OtherController($scope) {
	$scope.pageChangeHandler = function(num) {
		// console.log('paginas ' + num);
	};
}

function cadastrarFornecedorController($scope, $http, $routeParams, $location,
		ObjectFactory) {
	console.log('2');
	$scope.cabecalho = "Cadastrar Fornecedor";
	$scope.botao = "Cadastrar";
	$scope.botao2 = 'Cancelar';
	detailsCliente($scope, $http);
	

		$scope.send = function(obj) {
			ObjectFactory.postTo('/fornecedor/salvar/', obj).success(function(data) {
				if (data === 'true') {
					alert('Fornecedor cadastrado com sucesso');
					$location.path('/');
				} else {
					alert('Fornecedor já cadastrado');
				}
			});
		};
   }

function visualizarFornecedorController($scope, $http, $routeParams, $location,
		ObjectFactory) {
	
	
	$scope.cabecalho = "Visualizar Fornecedor";
	$scope.isVisualizar = "true";
	$scope.botao2 = 'Voltar';
	detailsProduto($scope, $http);
	
	getObj($scope, $routeParams, ObjectFactory, '/fornecedor/buscar/',
			$routeParams.codigo);
}

function alterarFornecedorController($scope, $http, $routeParams, $location,
		ObjectFactory) {
	
	
	$scope.cabecalho = "Alterar Fornecedor";
	$scope.botao = "Alterar";
	$scope.botao2 = 'Cancelar';
	detailsProduto($scope, $http);
	
	getObj($scope, $routeParams, ObjectFactory, '/fornecedor/buscar/',
			$routeParams.codigo);
	
	$scope.send = function(obj) {
		console.log(obj);
		ObjectFactory.postTo('/fornecedor/alterar/', obj).success(function(data) {
			if (data === 'true') {
				alert('Produto alterado com sucesso!');
				$location.path('/fornecedor/consultar');
			} else {
				alert('Fornecedor já cadastrado');
			}
		});
	};
}

function ExcluirFornecedorController($scope, $http, $routeParams, $location,
		ObjectFactory) {
	
	$scope.send = function(obj) {
		ObjectFactory.postTo('/fornecedor/excluir/', obj).success(function(data) {
			if (data === 'true') {
				alert('Fornecedor Excluido com sucesso!');
				$location.path('/fornecedor/consultar');
			} else {
				alert('Erro ao Excluir Fornecedor');
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
