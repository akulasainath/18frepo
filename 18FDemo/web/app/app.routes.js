'use strict';

openFDAApp.config(function($routeProvider) {
	$routeProvider.when('/drugs/', {
		templateUrl : '/demo/app/components/drugs/drugs.html',
		controller : 'DrugsController'
	});
});