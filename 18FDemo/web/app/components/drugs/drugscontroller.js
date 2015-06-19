var drugscontrollers = {};

drugscontrollers.DrugsController = function($scope, $http, $location, $routeParams) {
    $scope.termBrand = '';
    $scope.termGeneric = '';
    $scope.selecteddrugs = [];
    $scope.drugreactions = [];
    $scope.serious = [];
    
    $scope.move = function(type) {
	var flag = true;
	$($scope.selecteddrugs).each(function(){
	    if($(this)[0].term == $scope.termGeneric || $(this)[0].term == $scope.termBrand) {
		flag = false;;
	    }
	});
	if(flag) {
	    if(type == 'generic') {
		var searchTerm = $scope.termGeneric.replace(/\,/g, '').replace(/\ /g, '+');
		$scope.goGeneric(searchTerm);
	    } else {
		var searchTerm = $scope.termBrand.replace(/\,/g, '').replace(/\ /g, '+');
		$scope.goBrand(searchTerm);
	    }
	}
    }
    
    $scope.goGeneric = function(searchTerm) {
	var tempItems = [];
	var selectedDrugCount = -1;
	$http.get('https://api.fda.gov/drug/event.json?count=patient.reaction.reactionmeddrapt.exact&search=patient.drug.openfda.generic_name:'+ searchTerm +'+AND+serious:1').success(function(jsonResp) {
	    $(jsonResp.results).each(function(){
		selectedDrugCount += $(this)[0].count;
	    });
	    $($scope.serious).each(function(index){
		tempItems[index] = new Object();
		var current = $(this)[0];
		$(jsonResp.results).each(function(){
		    if($(this)[0].term == current.term) {
			tempItems[index] = $(this)[0];
		    }
		});
	    });
	    $scope.drugreactions.push(tempItems);
	    
	    var selectedDrug = {
		term: $scope.termGeneric,
		count: selectedDrugCount
	    };
	    $scope.selecteddrugs.push(selectedDrug);
	    $scope.termGeneric = '';
	}).error(function(errorResp){
	    alert("Error: " + errorResp.error.message);
	});
    }
    
    $scope.goBrand = function(searchTerm) {
	var tempItems = [];
	var selectedDrugCount = -1;
	$http.get('https://api.fda.gov/drug/event.json?count=patient.reaction.reactionmeddrapt.exact&search=patient.drug.openfda.brand_name:'+ searchTerm + '+AND+serious:1').success(function(jsonResp) {
	    $(jsonResp.results).each(function(){
		selectedDrugCount += $(this)[0].count;
	    });
	    $($scope.serious).each(function(index){
		tempItems[index] = new Object();
		var current = $(this)[0];
		$(jsonResp.results).each(function(){
		    if($(this)[0].term == current.term) {
			tempItems[index] = $(this)[0];
		    }
		});
	    });
	    $scope.drugreactions.push(tempItems);
	    
	    var selectedDrug = {
		term: $scope.termBrand,
		count: selectedDrugCount
	    };
	    $scope.selecteddrugs.push(selectedDrug);
	    $scope.termBrand = '';
	}).error(function(errorResp){
	    alert("Error: " + errorResp.error.message);
	});
    }

    $scope.isEmpty = function(arr) {
	for ( var i in arr) {
	    if (arr.hasOwnProperty(i))
		return false;
	}
	return true;
    }

    $scope.getSize = function(obj) {
	var idx = 0;
	for ( var i in obj) {
	    if (obj[i] != "0") {
		idx++;
	    }
	}
	return idx;
    };

    $scope.remove = function(term) {
	var index = $scope.selecteddrugs.indexOf(term);
	$scope.selecteddrugs.splice(index, 1);
	$scope.drugreactions.splice(index, 1);
    }

    $scope.init = function() {
	var limit = 10;
	$http.get("https://api.fda.gov/drug/event.json?count=patient.reaction.reactionmeddrapt.exact&search=serious:1")
		.success(function(jsonResp) {
		    for (i = 0; i < limit; i++) {
			$scope.serious.push(jsonResp.results[i]);
		    }
		});
    }
}

demoApp.controller(drugscontrollers);