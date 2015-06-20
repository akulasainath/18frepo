var drugscontrollers = {};

drugscontrollers.DrugsController = function($scope, $http, $location,
	$routeParams) {
    $scope.termGeneric = '';
    $scope.country = '';
    $scope.selecteddrugs = [];
    $scope.headerItems = [];
    $scope.storage = [];
    $scope.finalstorage = [];
    $scope.searchterms = [];
    
    $scope.move = function() {
	$("#progressbar").show();
	$scope.selecteddrugs.push($scope.termGeneric);
	$scope.indiSearch($scope.termGeneric);
	$scope.combinedSearch();
    }
    
    /**
     * Method for Individual Drug Search.
     * For Ex: Where drug brand name or generic name is Drug A
     */
    $scope.indiSearch = function(term) {
	var searchTerm = '"'+term.replace(/\,/g, '').replace(/\ /g, '+')+'"';
	$scope.searchterms.push(searchTerm);
	$http.get('https://api.fda.gov/drug/event.json?count=patient.reaction.reactionmeddrapt.exact&search=(patient.drug.openfda.generic_name:' + searchTerm + "+patient.drug.openfda.brand_name:" + searchTerm + ")")
        	.success(function(jsonResp) {
        	    $scope.storage[searchTerm] = jsonResp.results;
        	}).error(function(errorResp) {
        	    $scope.storage[searchTerm] = new Object();
		});
    }

    /**
     * Method for Combined Drug Search.
     * For Ex: Where drug brand name or generic name is Drug A + Drug B + Drug C
     */
    $scope.combinedSearch = function() {
	var combinedSearchTerm = $scope.searchterms.join('+');
	$scope.finalstorage = [];
	$http.get('https://api.fda.gov/drug/event.json?count=patient.reaction.reactionmeddrapt.exact&search=(patient.drug.openfda.generic_name:' + combinedSearchTerm + "+patient.drug.openfda.brand_name:" + combinedSearchTerm + ")")
	.success(function(jsonResp) {
	    $scope.headerItems = [];
	    $(jsonResp.results).each(function(index) {
		if(index < 10) {
		    $scope.headerItems.push($(this)[0]);
		}
	    });
	    //loop thru each search term to get 5 counts
	    $($scope.searchterms).each(function(index){
		var currentTerm = $scope.searchterms[index];
		var finalItems = [];
		//loop thru header items to get the 5 reaction counts
		$($scope.headerItems).each(function(headerIdx){
		   var currentHeader =  $(this)[0].term;
		   finalItems[headerIdx] = "";
		   //loop thru all reactions for particular drug and bring out required 5 counts.
		   $($scope.storage[currentTerm]).each(function(){
		       if($(this)[0].term == currentHeader) {
			    finalItems[headerIdx] = $(this)[0].count;
		       }
		   });
		});
		$scope.finalstorage[index] = finalItems;
	    });
	    $scope.termGeneric = '';
	    $("#progressbar").hide();
	}).error(function(errorResp) {
	    alert("Error: " + errorResp.error.message);
	    $("#progressbar").hide();
	});
    }
    
    $scope.remove = function(term) {
	$("#progressbar").show();
	var searchTerm = term.replace(/\,/g, '');
	searchTerm = '"'+term+'"';
	var index = $scope.searchterms.indexOf(searchTerm);
	$scope.searchterms.splice(index, 1);
	
	index = $scope.selecteddrugs.indexOf(term);
	$scope.selecteddrugs.splice(index, 1);

	if($scope.selecteddrugs.length > 0) {
	    $scope.combinedSearch();
	} else {
	    $("#progressbar").hide();
	}
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
}

demoApp.controller(drugscontrollers);