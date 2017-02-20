function avisosController($scope, $http, $routeParams, $location){
	$scope.alerta = false;
	$scope.produtos;
	$scope.produto;
	$scope.produtosEstoque = [];
	
	$scope.alterar = function(codigo) {
		$location.path('produto/alterar/' + codigo);
	};
	setInterval(function() {
//		console.log("setInterval: Ja passou  segundo!"); 
		carregar();
//		$('#menu').load('principal.jsp');
		
		
	}, 20000);
	
	carregar = function(){
//		console.log('entrou no metodo');
		$http.get($scope.server("/produto/listProduto")).success(function(data) {
			$scope.produtosEstoque = [];
		$scope.produtos = data;
//		console.log('carregou produtos');
		
		 $.each($scope.produtos,function(index, prod){
//			 console.log(prod.quantidade);
			 if(prod.quantidade == 0){
				 console.log("passando pra alerta");
				 $scope.alerta = true;
				 $scope.produtosEstoque.push(prod);
				 $scope.teste = 1;
			 }
		 });
		 if($scope.teste == 0){
			 $scope.alerta = false;
		 }
		 $scope.teste = 0;
		
	}).error(function(data) {
		alert("Error…");
		console.log(data);
	});
		
	};

	carregar();
	
}
