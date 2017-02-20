SERVER_URL = "http://localhost:8085/equiparAcessorios/service";

angular.module('appequipar', [
	'Object.Factory',
	'Paginationapp',
	'ui.utils',
	
	'ui.date',
	'ui.bootstrap'
	])
.config(function($routeProvider, $httpProvider, $locationProvider) {
	
	
	$routeProvider
	
	/*
	 * Cliente
	 */
	.when('/clientes/novo', {
		templateUrl : 'pages/cliente/cliente.jsp',
		controller : 'ClienteController'
	})
	.when('/clientes', {
		templateUrl : 'pages/cliente/clientes.jsp',
		controller : 'ClientesController'
	})
	.when('/clientes/visualizar/:codigo', {
		templateUrl : 'pages/cliente/cliente.jsp',
		controller : 'ClienteController'
	})
	.when('/clientes/alterar/:codigo', {
		templateUrl : 'pages/cliente/cliente.jsp',
		controller : 'ClienteController'
	})
	.when('/logout', {
		templateUrl : 'index.jsp'
	})
	
	/*
	 * Produto
	 */
	.when('/produtos/novo', {
			templateUrl : 'pages/produto/produto.jsp',
			controller : 'ProdutoController'
		})
	.when('/produtos', {
			templateUrl : 'pages/produto/produtos.jsp',
			controller : 'ProdutosController'
		})
	.when('/produto/visualizar/:codigo', {
			templateUrl : 'pages/produto/cadastrar.jsp',
			controller : 'ProdutoController'
		})
	.when('/produto/alterar/:codigo', {
			templateUrl : 'pages/produto/cadastrar.jsp',
			controller : 'ProdutoController'
		})
		//CATEGORIA PRODUTO
	.when('/produto/categorias', {
			templateUrl : 'pages/produto/categorias.jsp',
			controller : 'consultarCategoriaController'
		})
	.when('/produto/categoria', {
			templateUrl : 'pages/produto/categoria.jsp',
			controller : 'cadastrarCategoriaController'
		})
	.when('/produto/categoria/:codigo', {
			templateUrl : 'pages/produto/categoria.jsp',
			controller : 'visualizarCategoriaController'
		})
	.when('/produto/alterarCategoria/:codigo', {
			templateUrl : 'pages/produto/cadastrarCategoria.jsp',
			controller : 'alterarCategoriaController'
		})
		
	/*
	 * Funcionario
	 */
	.when('/funcionarios/novo', {
			templateUrl : 'pages/funcionario/funcionario.jsp',
			controller : 'FuncionarioController'
		})
	.when('/funcionarios', {
			templateUrl : 'pages/funcionario/funcionarios.jsp',
			controller : 'FuncionariosController'
		})
	.when('/funcionarios/visualizar/:codigo', {
			templateUrl : 'pages/funcionario/funcionario.jsp',
			controller : 'FuncionarioController'
		})
	.when('/funcionarios/alterar/:codigo', {
			templateUrl : 'pages/funcionario/funcionario.jsp',
			controller : 'FuncionarioController'
		})

		/*
	 * Fornecedor
	 */
	.when('/fornecedores/novo', {
			templateUrl : 'pages/fornecedor/fornecedor.jsp',
			controller : 'FornecedorController'
		})
	.when('/fornecedores', {
			templateUrl : 'pages/fornecedor/fornecedores.jsp',
			controller : 'FornecedoresController'
		})
	.when('/fornecedores/visualizar/:codigo', {
			templateUrl : 'pages/fornecedor/fornecedor.jsp',
			controller : 'FornecedorController'
		})
	.when('/fornecedores/alterar/:codigo', {
			templateUrl : 'pages/fornecedor/fornecedor.jsp',
			controller : 'FornecedorController'
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
	
});

angular.module('appequipar').run(function($rootScope) {
	$rootScope.server = function(url) {
//		console.log(SERVER_URL + url);
		return SERVER_URL + url;

	};

});
