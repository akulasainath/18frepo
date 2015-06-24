
describe('DrugsController', function() {
	// Load the module with MainController
	beforeEach(module('openFDAApp'));

	var ctrl, scope, http, location;
	// inject the $controller and $rootScope services
	// in the beforeEach block
	beforeEach(inject(function($controller, $rootScope, $http) {
		
		http = $http;
		scope = $rootScope.$new();

		
		ctrl = function() {
            return $controller('DrugsController', {
                '$scope': scope,
    			'$http' : http,
    			'$location' : location
            });
        };
	}));

	
	describe('$scope.indiSearch', function() {
	    it('sets the strength to "strong" if the password length is >8 chars', function() {
	      var $scope = {};
	      var promise = '';
	      var controller = ctrl();
	      scope.indiSearch("Aspirin");
	     
	    }, 2000);
	  });
})