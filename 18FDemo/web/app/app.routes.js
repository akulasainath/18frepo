demoApp.config(function($routeProvider) {
	$routeProvider.when('/home/', {
		templateUrl : '/demo/app/components/search/search.html',
		controller : 'SearchController'
	}).when('/results/:data', {
		templateUrl : '/demo/app/components/search/results.html',
		controller : 'SearchController'
	}).when('/drugs/', {
		templateUrl : '/demo/app/components/drugs/drugs.html',
		controller : 'DrugsController'
	});
});