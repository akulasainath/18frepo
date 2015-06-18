var searchcontrollers = {};

searchcontrollers.SearchController = function($scope, $http, $location, $routeParams) {
    $scope.term = '';
    $scope.rows = '';
    $scope.search = function() {
	$location.path('/results/'+$scope.term);
    }
    
    $scope.init = function() {
	$scope.term = $routeParams.data;
	$http.get('https://api.fda.gov/drug/label.json?limit=10&search=openfda.manufacturer_name:' + $scope.term + '+openfda.brand_name:' + $scope.term + '+openfda.generic_name:' + $scope.term).success(
		function(jsonResp) {
		    $scope.rows = jsonResp;
		});
    }
    
    
    
}

demoApp.controller(searchcontrollers);