angular.module('appequipar').controller('ProdutosController', function($scope, $http, $routeParams, $location) {

	$scope.currentPage = 1;
	$scope.pageSize = 5;

	$scope.produtos = null;
	$scope.produto = null;
	
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
							$scope.mensagem = 'Produto Excluido com Sucesso!';
							$location.path('/');
						} else {
							$scope.mensagem = 'Erro ao excluir';
						}
					});
		}else{
			$scope.mensagem = 'Não foi possivel excluir um produto em estoque.';
		}

	};

	// @scope.loadAll = function(){

	$http.get($scope.server("/produto/listProduto")).success(function(data) {
		$scope.produtos = data;
	}).error(function(erro) {
		$scope.mensagem = "Erro ao listar produtos";
//		console.log(erro);
	});

	for (var i = 1; i <= 100; i++) {

		$scope.produtos;
	}
});

function OtherController($scope) {
	$scope.pageChangeHandler = function(num) {
		// console.log('paginas ' + num);
	};
}