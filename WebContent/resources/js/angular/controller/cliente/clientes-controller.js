angular.module('appequipar').controller('ClientesController', function($scope, $http, $routeParams, $location){

	$scope.currentPage = 1;
	$scope.pageSize = 5;

	$scope.clientes = null;
	$scope.cliente = null;

	$scope.visualizar = function(codigo) {
		$location.path('cliente/visualizar/' + codigo);
	};
	
	$scope.alterar = function(codigo) {
		$location.path('cliente/alterar/' + codigo);
	};
	
	$scope.consultarLigacao = function(codigo) {
		$location.path('cliente/consultarLigacao/' + codigo);
	};
	
	$scope.consultarOS = function(cliente) {
		$location.path('/venda/consultarOSCliente/' + cliente.cpf);
	};
	
	$scope.excluir = function(obj) {
        	 $http.post($scope.server("/cliente/excluir"), obj)
        	 .success(function(data) {
        		 console.log('retorno ' + data);
        		 if (data === 'true') {
        			 $scope.mensagem = 'Cliente Excluido com Sucesso!';
        			 $location.path('/cliente/consultar');
        		 }else{
        			 $scope.mensagem = 'Erro ao excluir';
        		 }
            })
            .error(function(erro){
            	$scope.mensagem = 'Erro ao excluir cliente';
            });
	};

	$http.get($scope.server('/cliente/client')).success(function(data) {
		$scope.clientes = data;
	}).error(function(data) {
		$scope.mensagem = 'Erro ao listar Clientes';
		console.log(data);
	});
});

function detailsCliente($scope, $http) { 
	$scope.tipoSexo = [];
	    var getTipoSexo = function () {
	        $http.get(SERVER_URL + '/cliente/tipoSexo').success(function (data) {
	            $scope.tipoSexo = data;
	        });
	    };
	    getTipoSexo();
};