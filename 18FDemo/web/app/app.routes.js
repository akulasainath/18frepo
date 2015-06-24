'use strict';

openFDAApp.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : '/demo/home.html'
	}).when('/drugs/', {
		templateUrl : '/demo/app/components/drugs/drugs.html',
		controller : 'DrugsController'
	});
});


