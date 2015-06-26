it('should test routeProvider', function() {
	module('openFDAApp');

	beforeEach(inject(function($route, $location, $rootScope) {

		expect($route.current).toBeUndefined();
		$location.path('/drugs/1');
		$rootScope.$digest();

		expect($location.path()).toBe('/drugs/');
		expect($route.current.templateUrl).toEqual(
				'/web/app/components/drugs/drugs.html');
		expect($route.current.controller).toBe(DrugsController);

	}));
});