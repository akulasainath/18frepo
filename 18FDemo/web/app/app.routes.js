'use strict';

openFDAApp.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : '/web/home.html'
	}).when('/drugs/', {
		templateUrl : '/web/app/components/drugs/drugs.html',
		controller : 'DrugsController'
	});
});


