angular.module('appequipar').controller('ClienteController',function($scope, $http, $routeParams, $location,
		ObjectFactory) {
	
	$scope.obj = {};
	$scope.mensagem = '';
	$scope.tipoSexo = [];
	
	 $http.get(SERVER_URL + '/cliente/tipoSexo').success(function (data) {
         $scope.tipoSexo = data;
     })
     .error(function(erro){
    	 $scope.mensagem = 'Erro ao Listar Tipo Sexo';
     });

	$scope.submeter = function() {
		
		if($scope.formulario.$valid){
			if($scope.ob.cdClientej){
				//alterar
				ObjectFactory.postTo('/cliente/alterar/', obj).success(function(data) {
					if (data === 'true') {
						$scope.mensagem = 'Cliente alterado com sucesso';
						$location.path('/cliente/consultar');
					} else {
						alert('Cliente j� cadastrado');
					}
				});
				
			} else{
				//incluir
				ObjectFactory.postTo('/cliente/salvar/', obj).success(function(data) {
					if (data === 'true') {
						alert('Usuario cadastrado com sucesso');
						$location.path('/');
					} else {
						alert('Cliente ja cadastrado');
					}
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