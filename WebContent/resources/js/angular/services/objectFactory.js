angular.module('Object.Factory', [])

	.factory('ObjectFactory', ['$http', function($http) {
		return {
			getObject: function(url, id) {
				return $http.get(SERVER_URL + url + id);
			},
			
			postTo: function(url, obj) {
				return $http.post(SERVER_URL + url, obj);
			}
		};
	}]);