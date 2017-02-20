angular.module('Cliente.Route', 
		[ 
		 'clienteController', 
		 ])

.config([ '$routeProvider', function($routeProvider) {

	$routeProvider

	.when('/cliente/cadastrar', {
		templateUrl : 'pages/cliente/cadastrar.jsp',
		controller : 'cadastrarClienteController'
	})
	.when('/cliente/consultar', {
		templateUrl : 'pages/cliente/consultar.jsp',
		controller : 'consultarClienteController'
	})
	.when('/cliente/alterar/:cpf', {
		templateUrl : 'pages/cliente/cadastrar.jsp',
		controller : 'AlterarClienteController'
	})
	.when('/cliente/excluir/', {
		controller : 'excluirClienteController'
	})
	.when('/logout', {
		templateUrl : 'index.jsp'
	})
	.otherwise({
		redirectTo : '/'
	});
} ]);
