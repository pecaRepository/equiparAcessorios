angular.module('appequipar').controller('FornecedoresController', function($scope, $http, $routeParams, $location) {

	$scope.currentPage = 1;
	$scope.pageSize = 5;
	$scope.mensagem = '';

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
        			 $scope.mensagem = 'Fornecedor Excluido com Sucesso';
        			 $location.path('/');
        		 }else{
        			 $scope.mensagem = 'Erro ao excluir';
        		 }
            });
	};

	console.log('Consultando Fornecedor');
	$http.get($scope.server("/fornecedor/listfornecedor")).success(function(data) {
		$scope.fornecedores = data;
		
	}).error(function(data) {
		$scope.mensagem = 'Erro ao listar Fornecedores';
	});

});

function OtherController($scope) {
	$scope.pageChangeHandler = function(num) {
		// console.log('paginas ' + num);
	};
}

function postTo($http, $location, ObjectFactory, url, obj, callbackUrl) {
	ObjectFactory.postTo(url, obj).success(function(data) {
		$location.path(callbackUrl);
	});
}
