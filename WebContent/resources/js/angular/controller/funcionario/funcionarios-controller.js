angular.module('appequipar').controller('FuncionariosController', function($scope, $http, $routeParams, $location) {

	$scope.currentPage = 1;
	$scope.pageSize = 3;

	$scope.funcionarios = null;
	$scope.funcionario = null;
	$scope.mensagem = '';

	$http.get($scope.server("/funcionario/listFuncionario"))
	.success(function(data) {
		$scope.funcionarios = data;
	}).error(function(data) {
		$scope.mensagem = 'Erro ao listar funcionarios';
	});

	$scope.visualizar = function(codigo) {
		$location.path('funcionario/visualizar/' + codigo);
	};

	$scope.alterar = function(codigo) {
		$location.path('funcionario/alterar/' + codigo);
	};

	$scope.excluir = function(obj) {
		$http.post($scope.server("/funcionario/excluir"), obj.codigo)
		.success(function(data) {
					if (data === 'true') {
						$scope.mensagem = 'Funcionario Excluido com Sucesso';
						$location.path('/funcionario/consultar');
					} else {
						$scope.mensagem = 'Erro ao excluir funcionar';
					}
		}).error(function(erro){
			$scope.mensagem = 'Erro ao excluir funcionar';
		});
	};
});

function OtherController($scope) {
	$scope.pageChangeHandler = function(num) {
		// console.log('paginas ' + num);
	};
}