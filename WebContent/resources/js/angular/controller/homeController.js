angular.module('homeController', [])

	.controller('HomeListController', ['$scope', '$http', '$resource', function($scope, $http, $resource) {}])
	
	.controller('IndexController', ['$scope', '$window', '$location', function($scope, $window, $location) {
	    function VisitedPage() {
	        var pageMap = new SimpleMap();
	        var isHistoryBack = false;
	
	        this.setLastVisitedPage = function(productName, page) {
	            pageMap.put(productName, page);
	        };
	
	        this.getLastVisitedPage = function(productName) {
	            //console.info('History Back Clicked -> ', isHistoryBack);
	            var lastPage = 0;
	            if (isHistoryBack && pageMap.containsKey(productName)) {
	                lastPage = pageMap.get(productName);
	                isHistoryBack = false;
	            }
	
	            return lastPage;
	        };
	
	        this.enableLastVisitedPage = function() {
	            isHistoryBack = true;
	        };
	    };
	
	    // ic == IndexController
	    if (!$scope.ic) {
	        $scope.ic = new VisitedPage();
	    }
	
		$scope.back = function() {
			$window.history.back();
		};
	
	    var queue = new Array();
	    $scope.$on('$locationChangeSuccess', function() {
	        queue.unshift($location.path());
	        if (queue[0] === queue[2]) {
	            $scope.ic.enableLastVisitedPage();
	        }
	        // o 4º item é sempre deletado, mantendo o tamanho da lista sempre com 3 itens.
	        delete queue[3];
	    });
	}])
	
	.controller('MenuController', ['$scope', '$http', '$filter', 'MenuFactory', function($scope, $http, $filter, MenuFactory) {
		
		$scope.myTree = [];
		
		MenuFactory.getMenuAsync(function(data) {
			var subArray = [];
			
			angular.forEach(data, function(parent) {
				
				if (parent.menus.length > 0) {
					var subs = [];
					
					angular.forEach(parent.menus, function(sub) {
						var c = new Choice(sub.nome, sub.path);
						subs.push(c);
						subArray.push(c);
					});
					
					var p = new Choice(parent.nome, parent.path, subs);
					$scope.myTree.push(p);
					
				} else {
					var p = new Choice(parent.nome, parent.path);
					var found = $filter('filter')(subArray, {name: p.name}, true);
					
					if (found[0] == null) $scope.myTree.push(p);
				}
			});
		});
	}])
	
	.controller('ModalDemoCtrl', ['$scope', '$modal', '$log', '$rootScope', function($scope, $modal, $log, $rootScope) {
	    function Modal() {
	        this.instance;
	        this.open = function(template, closedByEsc, isLarge) {
	            this.instance = $modal.open({
	                templateUrl : template,
	                backdrop: 'static',
	                windowClass: isLarge == true ? 'modal-large' : '',
	                keyboard : closedByEsc == undefined ? false : true
	            });
	        };
	
	        this.cancel = function() {
	            this.instance.dismiss('cancel');
	        };
	    };
	
	    $rootScope.modal = new Modal();
	}]);