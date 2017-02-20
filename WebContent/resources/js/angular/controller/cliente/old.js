function cadastroController($scope, $http, $routeParams, $location){
	
}
function detailsCliente($scope, $http) { 
	$scope.tipoSexo = [];
	    var getTipoSexo = function () {
	        $http.get(SERVER_URL + '/cliente/tipoSexo').success(function (data) {
	            $scope.tipoSexo = data;
	        });
	    };
	    getTipoSexo();
	    
}

function consultarLigacaoController($scope, $http, $routeParams, $location,ObjectFactory) {
	
	$scope.currentPage = 1;
	$scope.pageSize = 5;

	$scope.ligacoes = null;
	$scope.ligacao = null;
	$scope.descricao = null;
	$scope.parametros = {codigo: $routeParams.codigo};
	/*
	 * ---CALENDARIO-------------------------------------------------------------
	 */
	  $scope.open = function($event) {
	    $event.preventDefault();
	    $event.stopPropagation();
	    $scope.opened = true;
	  };
	  $scope.dateOptions = {
	    formatYear: 'yy',
	    startingDay: 1
	  };
	  $scope.format ='dd/MM/yyyy';
	/*
	 * -----------------------------------------------------------------
	 */
	$scope.ligar = function(codigo) {
		$location.path('cliente/ligar/' + codigo);
	};
	
	$scope.carregarDescricao = function(ligacao) {
		$scope.descricao = ligacao.descricao;
	};
	
	$scope.consultarLigacoes = function(parametros){
		console.log($scope.parametros);
	};
	
	$scope.obj = {};
	ObjectFactory.getObject('/cliente/consultarClientePorCodigo/', $routeParams.codigo).success(function(data) {
		$scope.obj = data;
		
		//carrega lista de ligacoes
		$http.get($scope.server("/cliente/listLigacoes/" + $scope.obj.cdCliente )).success(function(data) {
			$scope.ligacoes = data;
		}).error(function(data) {
			alert("Error…");
			console.log(data);
		});	
		
	});
}

function consultarClienteController($scope, $http, $routeParams, $location) {

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
        	 $http.post($scope.server("/cliente/excluir"), obj).success(function(data) {
        		 console.log('retornor ' + data);
        		 if (data === 'true') {
        			 alert('Cliente Excluido com Sucesso!');
        			 $location.path('/cliente/consultar');
        		 }else{
        			 alert('Erro ao excluir');
        		 }
            });
	};


	// @scope.loadAll = function(){
	console.log('Consultando clientes em clienteController');
	$http.get($scope.server("/cliente/client")).success(function(data) {
		$scope.clientes = data;
	}).error(function(data) {
		alert("Error…");
		console.log(data);
	});
}


function cadastrarClienteController($scope, $http, $routeParams, $location,
		ObjectFactory) {
	
	$scope.cabecalho = "Cadastrar Cliente";
	$scope.cabecalhoCarro = "Cadastrar Carro";
	$scope.botao = "Cadastrar";
	$scope.botao2 = 'Cancelar';
	detailsCliente($scope, $http);

	$scope.send = function(obj) {
		ObjectFactory.postTo('/cliente/salvar/', obj).success(function(data) {
			if (data === 'true') {
				alert('Usuario cadastrado com sucesso');
				$location.path('/');
			} else {
				alert('Cliente já cadastrado');
			}
		});
	};
}

function AlterarClienteController($scope, $http, $routeParams, $location,
		ObjectFactory) {
	
	$scope.cabecalho = "Alterar Cliente";
	$scope.cabecalhoCarro = "Alterar Carro";
	$scope.botao = "Alterar";
	$scope.botao2 = 'Cancelar';
	detailsCliente($scope, $http);
	$scope.codigo = $routeParams.codigo;
	console.log($routeParams.cpf);
	
	getObj($scope, $routeParams, ObjectFactory, '/cliente/consultarClientePorCodigo/',
			$routeParams.codigo);
	
	$scope.send = function(obj) {
		ObjectFactory.postTo('/cliente/alterar/', obj).success(function(data) {
			if (data === 'true') {
				alert('Cliente alterado com sucesso');
				$location.path('/cliente/consultar');
			} else {
				alert('Cliente já cadastrado');
			}
		});
	};
}

function visualizarClienteController($scope, $http, $routeParams, $location,
		ObjectFactory) {
	
	$scope.cabecalho = "Visualizar Cliente";
	$scope.cabecalhoCarro = "Visualizar Carro";
	$scope.botao2 = 'Voltar';
	$scope.isVisualizar = "true";
	detailsCliente($scope, $http);
	$scope.codigo = $routeParams.codigo;
	console.log($routeParams.cpf);
	
	getObj($scope, $routeParams, ObjectFactory, '/cliente/consultarClientePorCodigo/',
			$routeParams.codigo);
	
}

function ligarClienteController($scope, $http, $routeParams, $location,
		ObjectFactory) {
	
	$scope.cabecalho = "Dados Cliente";
	$scope.cabecalhoCarro = "Dados Carro";
	$scope.isVisualizar = true;
	$scope.isLigar = true;
	detailsCliente($scope, $http);
	$scope.dataAtual = new Date().toLocaleString();
	$scope.dataLigacao = new Date();
	$scope.botao = "Registrar";
	$scope.botao2 = 'Cancelar';
	$scope.obj2 = {};
	
	$scope.consultarOS = function(codigo) {
		$location.path('/venda/consultarOSCliente/' + codigo);
	};
	
	getObj($scope, $routeParams, ObjectFactory, '/cliente/consultarClientePorCodigo/',
			$routeParams.codigo);
	
	console.log($scope.obj.cdCliente);
	
	$scope.send = function(obj2) {
		obj2.dtLigacao = $scope.dataLigacao;
		obj2.cdCliente = $scope.obj.cdCliente;
		ObjectFactory.postTo('/cliente/registrarLigacao/', obj2).success(function(data) {
			if (data === 'true') {
				alert('Ligação registrada');
				$location.path('/cliente/consultarLigacao');
			} else {
				alert('Erro ao Ligar para Cliente');
			}
		});
	};	
}

function ExcluirClienteController($scope, $http, $routeParams, $location,
		ObjectFactory) {
	
	$scope.send = function(obj) {
		ObjectFactory.postTo('/cliente/excluir/', obj).success(function(data) {
			if (data === 'true') {
				alert('Cliente Excluido com sucesso');
				$location.path('/cliente/consultar');
			} else {
				alert('Erro ao Excluir Cliente');
			}
		});
	};
}


function getObj($scope, $routeParams, ObjectFactory, url, id) {
	$scope.obj = {};
		ObjectFactory.getObject(url, id).success(function(data) {
			$scope.obj = data;
			console.log(data);
		});
}

function postTo($http, $location, ObjectFactory, url, obj, callbackUrl) {
	ObjectFactory.postTo(url, obj).success(function(data) {
		$location.path(callbackUrl);
	});
}
