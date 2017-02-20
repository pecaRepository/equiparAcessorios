angular.module('appequipar').controller('ProdutoController', function($scope, $http, $routeParams, $location,
		ObjectFactory) {

	$scope.cabecalho = "Cadastrar Produto";
	$scope.obj = {};
	$scope.mensagem = '';
	$scope.categorias = [];
	
	$http.get($scope.server("/produto/listCategoria"))
		.success(function(data) {
			$scope.categorias = data;
		})
		.error(function(erro) {
			$scope.mensagem = 'Erro ao Listar Categoria';
			console.log(erro);
	});

	$scope.submeter = function() {
		
		if($scope.formulario.$valid){
			if($scope.ob.cdClientej){
				//alterar
			} else{
				//incluir
				ObjectFactory.postTo('/produto/salvar/', $scope.obj)
				.success(function(data) {
					if (data === 'true') {
						$scope.mensagem = 'Produto ' + $scope.obj.modelo + ' cadastrado com sucesso';
						$location.path('/');
					} else {
						$scope.mensagem = 'Produto já cadastrado';
					}
				}).error(function(erro){
					$scope.mensagem = 'Erro ao salvar produto';
					console.log(erro);
				});
			}
		}
	};
	
});