angular.module('diretivasEquipar',[]).directive('tooltip', function () {
	  return {
	    // atribuimos em forma de classe css nesse caso
	    restrict: 'A',
	    link: function (scope, element, attrs) {
//	    	console.log('teste');
	    	console.log(scope);
//	    	console.log(element);
//	    	console.log(attrs);
	      // atribuimos o plugin jQuery ao par�metro `element`
	      // nesse caso, o element do DOM que foi bindado a diretiva
	      element.tooltipster();
	    }
	  };
	});