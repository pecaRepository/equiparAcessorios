SERVER_URL = "http://localhost:8085/Equipar/service";

var appequipar = angular.module('equiparAcessorios', [
	'Object.Factory',
	'Paginationapp',
	'ui.utils',
	
	'ui.date',
	'ui.bootstrap'
	]);

appequipar.directive('tooltip', function () {
	  return {
	    // atribuímos em forma de classe css nesse caso
	    restrict: 'A',
	    link: function (scope, element, attrs) {
//	    	console.log('teste');
	    	console.log(scope);
//	    	console.log(element);
//	    	console.log(attrs);
	      // atribuímos o plugin jQuery ao parâmetro `element`
	      // nesse caso, o element do DOM que foi bindado a diretiva
	      element.tooltipster();
	    }
	  };
	});

appequipar.config(function($routeProvider, $httpProvider, $locationProvider) {
	
	$routeProvider
	
//	.when('/venda/ordemServico', {
//		templateUrl : 'pages/venda/ordemServico.html',
//		
//	})
	/*
	 * Cliente
	 */
	.when('/cliente/cadastrar', {
		templateUrl : 'pages/cliente/cadastrar.jsp',
		controller : 'cadastrarClienteController'
	})
	.when('/cliente/consultar', {
		templateUrl : 'pages/cliente/consultar.jsp',
		controller : 'consultarClienteController'
	})
	.when('/cliente/visualizar/:codigo', {
		templateUrl : 'pages/cliente/cadastrar.jsp',
		controller : 'visualizarClienteController'
	})
	.when('/cliente/alterar/:codigo', {
		templateUrl : 'pages/cliente/cadastrar.jsp',
		controller : 'AlterarClienteController'
	})
	.when('/cliente/consultarLigacao/:codigo', {
		templateUrl : 'pages/cliente/consultarLigacao.jsp',
		controller : 'consultarLigacaoController'
	})
	.when('/cliente/ligar/:codigo', {
		templateUrl : 'pages/cliente/ligar.jsp',
		controller : 'ligarClienteController'
	})
	.when('/cliente/excluir/', {
		controller : 'excluirClienteController'
	})
	.when('/logout', {
		templateUrl : 'index.jsp'
	})
	
	/*
	 * Produto
	 */
	.when('/produto/cadastrar', {
			templateUrl : 'pages/produto/cadastrar.jsp',
			controller : 'cadastrarProdutoController'
		})
	.when('/produto/consultar', {
			templateUrl : 'pages/produto/consultar.jsp',
			controller : 'consultarProdutoController'
		})
	.when('/produto/visualizar/:codigo', {
			templateUrl : 'pages/produto/cadastrar.jsp',
			controller : 'visualizarProdutoController'
		})
	.when('/produto/alterar/:codigo', {
			templateUrl : 'pages/produto/cadastrar.jsp',
			controller : 'alterarProdutoController'
		})
		//CATEGORIA PRODUTO
	.when('/produto/consultarCategoria', {
			templateUrl : 'pages/produto/consultarCategoria.jsp',
			controller : 'consultarCategoriaController'
		})
	.when('/produto/cadastrarCategoria', {
			templateUrl : 'pages/produto/cadastrarCategoria.jsp',
			controller : 'cadastrarCategoriaController'
		})
	.when('/produto/visualizarCategoria/:codigo', {
			templateUrl : 'pages/produto/cadastrarCategoria.jsp',
			controller : 'visualizarCategoriaController'
		})
	.when('/produto/alterarCategoria/:codigo', {
			templateUrl : 'pages/produto/cadastrarCategoria.jsp',
			controller : 'alterarCategoriaController'
		})
		
	/*
	 * Funcionario
	 */
	.when('/funcionario/cadastrar', {
			templateUrl : 'pages/funcionario/cadastrar.jsp',
			controller : 'cadastrarFuncionarioController'
		})
	.when('/funcionario/consultar', {
			templateUrl : 'pages/funcionario/consultar.jsp',
			controller : 'consultarFuncionarioController'
		})
	.when('/funcionario/visualizar/:codigo', {
			templateUrl : 'pages/funcionario/cadastrar.jsp',
			controller : 'visualizarFuncionarioController'
		})
	.when('/funcionario/alterar/:codigo', {
			templateUrl : 'pages/funcionario/cadastrar.jsp',
			controller : 'alterarFuncionarioController'
		})
	.when('/funcionario/comissao/:codigo', {
			templateUrl : 'pages/funcionario/comissao.jsp',
			controller : 'comissaoFuncionarioController'
		})
		
		/*
	 * Fornecedor
	 */
	.when('/fornecedor/cadastrar', {
			templateUrl : 'pages/fornecedor/cadastrar.jsp',
			controller : 'cadastrarFornecedorController'
		})
	.when('/fornecedor/consultar', {
			templateUrl : 'pages/fornecedor/consultar.jsp',
			controller : 'consultarFornecedorController'
		})
	.when('/fornecedor/visualizar/:codigo', {
			templateUrl : 'pages/fornecedor/cadastrar.jsp',
			controller : 'visualizarFornecedorController'
		})
	.when('/fornecedor/alterar/:codigo', {
			templateUrl : 'pages/fornecedor/cadastrar.jsp',
			controller : 'alterarFornecedorController'
		})
	.when('/fornecedor/comissao/:obj', {
			templateUrl : 'pages/fornecedor/comissao.jsp',
			controller : 'comissaoFornecedorController'
		})
		
	/*
	 * VENDA
	 */
	.when('/venda/registrar', {
			templateUrl : 'pages/venda/registrar.jsp',
			controller : 'registrarVendaController'
		})
	.when('/venda/efetuarOrcamento/:codigoOrcamento', {
			templateUrl : 'pages/venda/registrar.jsp',
			controller : 'registrarVendaController'
		})
	.when('/venda/consultar', {
			templateUrl : 'pages/venda/consultarOS.jsp',
			controller : 'consultarOSController'
		})
	.when('/venda/consultarOrcamento', {
			templateUrl : 'pages/venda/consultarOrcamento.jsp',
			controller : 'consultarOrcamentoController'
		})
		.when('/venda/consultarOSCliente/:cpf', {
			templateUrl : 'pages/venda/consultarOS.jsp',
			controller : 'consultarOSController'
		})
	.when('/funcionario/relatorio', {
			templateUrl : '',
			controller : ''
		})	
	.otherwise({
		redirectTo : '/',
	});
	
	function avisosController($scope, $http, $routeParams, $location){
		console.log('teste');
	}

	$httpProvider.responseInterceptors.push(function($q, $rootScope) {

		return function(promise) {
			return promise.then(function(response) {
				return (response);
			}, function(response) {
				$data = response.data;
				$error = $data.error;

				// coloquei os alerts para me certificar que a função foi
				// chamada

				if ($error && $error.text)
					alert('ERROR:' + $error.text);
				else {
					if (response.status = 404)
						alert('Page not found');
				}
				return $q.reject(response);
			});

		};

	});

});


appequipar.run(function($rootScope) {
	$rootScope.server = function(url) {
//		console.log(SERVER_URL + url);
		return SERVER_URL + url;

	};

}



);