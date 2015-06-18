var drugscontrollers = {};

drugscontrollers.DrugsController = function($scope, $http, $location, $routeParams) {
    
    $scope.drugnames = [];
    $scope.suggestDrugs = function() {
	$scope.term = $routeParams.data;
	$http.get('https://api.fda.gov/drug/label.json?limit=10&search=openfda.brand_name:' + $scope.term + '+openfda.generic_name:' + $scope.term).success(
		function(jsonResp) {
		    $scope.rows = jsonResp;
		});
    }
}

demoApp.controller(drugscontrollers);