var drugscontrollers = {};

drugscontrollers.DrugsController = function($scope, $http, $location, $routeParams) {
    $scope.term = '';
    $scope.selecteddrugs = [];
    $scope.move = function() {
	//alert('Hi' + $scope.term);
	$scope.selecteddrugs.push({value: $scope.term, text:$scope.term});
    }
}

demoApp.controller(drugscontrollers);