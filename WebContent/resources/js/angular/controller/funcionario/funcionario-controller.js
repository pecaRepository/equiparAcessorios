angular.module('appequipar').controller('FuncionarioController', function ($scope, $http, $routeParams, $location,
		ObjectFactory) {

	$scope.obj = {};
	$scope.mensagem = '';
	$scope.tipoSexo = [];
	
	$scope.submeter = function() {
		
		if($scope.formulario.$valid){
			if($scope.ob.cdClientej){
				//alterar
				ObjectFactory.postTo('/funcionario/alterar/', obj).success(function(data) {
					if (data === 'true') {
						$scope.mensagem = 'Funcionario ' + obj.nome + ' alterado com sucesso';
						$location.path('/funcionario/consultar');
					} else {
						alert('Funcionario j� cadastrado');
					}
				});
				
			} else{
				//incluir
				ObjectFactory.postTo('/funcionario/salvar/', obj)
				.success(function(data) {
					if (data === 'true') {
						$scope.mensagem = 'Funcionario ' + obj.modelo + ' cadastrado com sucesso';
						$location.path('/');
					} else {
						alert('Funcionario j� cadastrado');
					}
				}).error(function(erro){
					
				});
			}
		}
	};
 });

function postTo($http, $location, ObjectFactory, url, obj, callbackUrl) {
	ObjectFactory.postTo(url, obj).success(function(data) {
		$location.path(callbackUrl);
	});
}
