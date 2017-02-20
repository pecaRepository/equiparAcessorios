'use strict';

angular.module('Comum.Factory', [])

	.factory('securityInterceptor', ['$log', '$q', function($log, $q) {
		return {
			request: function(config) {
				console.log('1');
				return config || $q.when(config);
			},
			
			requestError: function(rejection) {
				return $q.reject(rejection);
			},
			
			response: function(response) {
				return response || $q.when(response);
			},
			
			responseError: function(rejection) {
				if (rejection.status == 403) {
					window.location = "./";
					return;
				}
				
				return $q.reject(rejection);
			}
		};
	}])

	.factory('MenuFactory', ['$http', function($http) {
		return {
			getMenuAsync: function(callback) {
				//$http.get(appPath + 'menus').success(callback);
			}
		};
	}])
	
	.factory('$fileUpload', ['$http', function($http) {
		return {
			uploadFileToUrl: function(file, tipoCadastro, uploadUrl) {
				var fd = new FormData();
		        fd.append('file', file);
		        fd.append('tipoCadastro', tipoCadastro);
		        
		        return $http.post(uploadUrl, fd, {
		            transformRequest: angular.identity,
		            headers: {
		            	'Content-Type': undefined
		            }
		        });
			}
		};
	}])
	
	.factory('$GenericFileUpload', ['$http', function($http) {
		return {
			uploadFileToUrl: function(uploadUrl, data) {
		        return $http.post(uploadUrl, data, {
		            transformRequest: angular.identity,
		            headers: {
		            	'Content-Type': undefined
		            }
		        });
			}
		};
	}]);