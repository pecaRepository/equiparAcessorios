function cadastroController($scope, $http, $routeParams, $location){
	
}

function consultarFornecedorController($scope, $http, $routeParams, $location) {

	$scope.currentPage = 1;
	$scope.pageSize = 5;

	$scope.produtos = null;
	$scope.produto = null;

	
	$scope.logar = function(user) {
		console.log('Logar--INICIO');
		
    	 $http.post($scope.server("/usuario/logar"), obj).success(function(data) {
    		 console.log('retornor ' + data);
    		 if (data === 'true') {
    			 console.log('agora vai redirecionar');
//    			 alert('Fornecedor Excluido com Sucesso!');
    			 $location.path('/');
    		 }else{
    			 alert('Login ou senha invalida!');
    		 }
        });
	
	};
	
	$scope.excluir = function(obj) {
        	 $http.post($scope.server("/fornecedor/excluir"), obj).success(function(data) {
        		 console.log('retornor ' + data);
        		 if (data === 'true') {
        			 console.log('agora vai dar um refresh');
        			 alert('Fornecedor Excluido com Sucesso!');
        			 $location.path('/');
        		 }else{
        			 alert('Erro ao excluir');
        		 }
            });
	};
}



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
	detailsCliente($scope, $http);
	

		$scope.send = function(obj) {
			ObjectFactory.postTo('/fornecedor/salvar/', obj).success(function(data) {
				if (data === 'true') {
					alert('Fornecedor ' + obj.Nome + ' cadastrado com sucesso');
					$location.path('/');
				} else {
					alert('Fornecedor já cadastrado');
				}
			});
		};
   }

function alterarFornecedorController($scope, $http, $routeParams, $location,
		ObjectFactory) {
	
	
	$scope.cabecalho = "Alterar Fornecedor";
	$scope.botao = "Alterar";
	detailsProduto($scope, $http);
	
	getObj($scope, $routeParams, ObjectFactory, '/Fornecedor/buscar/',
			$routeParams.codigo);
	
	$scope.send = function(obj) {
		console.log(obj);
		ObjectFactory.postTo('/fornecedor/alterar/', obj).success(function(data) {
			if (data === 'true') {
				alert('Produto ' + obj.modelo + ' alterado com sucesso!');
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
