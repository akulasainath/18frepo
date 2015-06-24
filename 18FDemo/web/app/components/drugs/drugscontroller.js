'use strict';

google.load("visualization", "1", {
    packages : [ "corechart" ]
});

angular.module('openFDAApp').controller('DrugsController', ['$scope', '$http', '$location',
    function($scope, $http, $location) {
    
    	//general scope attributes
        $scope.searchForDrug = '';
        $scope.selecteddrugs = [];
        $scope.top10Reactions = [];
        $scope.drugReactionResults = [];
        $scope.searchterms = [];
        $scope.selectedReaction = '';
        
        //filters
        $scope.countryFilter = '';
        $scope.genderFilter = '';
        $scope.outcomeFilter = '';
        $scope.filter = '';
        
        //we take only top 10 reactions
        var REACTION_LIMIT = 10;
        var BASE_URL = 'https://api.fda.gov/drug/event.json?';
        var GENERIC_NAME = 'patient.drug.openfda.generic_name:';
        var BRAND_NAME = 'patient.drug.openfda.brand_name:';
        var COUNT_PARAM = 'count=patient.reaction.reactionmeddrapt.exact';
        var LIMIT_1000_PARAM = 'limit=1000';
        /**
         * This method is executed when user selects the Drug.
         * This will do an individual drug search and combination drug search as well.
         */
        $scope.move = function () {
            //remove focus from input field
            $('#suggestGeneric').blur();
            //start progress bar.
            $('#progressbar').show();
            //call indi drug search, this will in turn call combination search if success.
            $scope.selecteddrugs.push($scope.searchForDrug);
            var searchTerm = $scope.normalizeTerm($scope.searchForDrug);
            $scope.searchterms.push(searchTerm);
            $scope.indiSearch(searchTerm, true);
        };
        
        $scope.normalizeTerm = function(term) {
            return '"'+term.replace(/\,/g, '').replace(/\ /g, '+')+'"';
        }
        
        /**
         * Method for Individual Drug Search.
         * For Ex: Where drug brand name or generic name is Drug A
         */
        $scope.indiSearch = function(searchTerm, flag) {
            $http.get(BASE_URL+ LIMIT_1000_PARAM + '&'+COUNT_PARAM+'&search=('+GENERIC_NAME+ searchTerm + '+' + BRAND_NAME + searchTerm + ')'+$scope.filter, { cache: true})
            	.success(function(jsonResp) {
            	    $scope.drugReactionResults[searchTerm] = jsonResp.results;
            	    if(flag) {
            		$scope.combinedSearch();
            	    }
            	}).error(function(errorResp, response) {
                    //no search term found, remove the term from the list.
            	    var index = $scope.searchterms.indexOf(searchTerm);
            	    $scope.searchterms.splice(index, 1);
            	    
            	    var index = $scope.selecteddrugs.indexOf(searchTerm);
        	    $scope.selecteddrugs.splice(index, 1);
            	    alert('Error: ' + errorResp.error.message);
            	    $('#progressbar').hide();
                });
        };

        /**
         * Method for Combined Drug Search.
         * For Ex: Where drug brand name or generic name is Drug A + Drug B + Drug C
         */
        $scope.combinedSearch = function() {
            var combinedSearchTerm = $scope.searchterms.join('+');
            $http.get(BASE_URL+ LIMIT_1000_PARAM + '&'+COUNT_PARAM+'&search=('+GENERIC_NAME+ combinedSearchTerm + '+' + BRAND_NAME + combinedSearchTerm + ')'+$scope.filter, { cache: true})
            .success(function(jsonResp) {
        	$scope.finalstorage = [];
                $scope.top10Reactions = [];
                var graphReactionExists = false;
                
                $(jsonResp.results).each(function(index) {
                    if(index < REACTION_LIMIT) {
                        $scope.top10Reactions.push($(this)[0]);
                    }
                });
                
                //loop thru each search term to get 5 counts
                $($scope.searchterms).each(function(index){
                    var currentTerm = $scope.searchterms[index];
                    var finalItems = [];
                    
                    //loop thru header items to get the 5 reaction counts
                    $($scope.top10Reactions).each(function(reactionIdx) {
                       var currentreaction =  $(this)[0].term;
                       finalItems[reactionIdx] = '';
                       //loop thru all reactions for particular drug and bring out required 5 counts.
                       $($scope.drugReactionResults[currentTerm]).each(function(){
                           if($(this)[0].term === currentreaction) {
                               finalItems[reactionIdx] = $(this)[0].count;
                           }
                       });
                       
                       //check if graph reaction selected exists, else we have to close the graph section.
                       if($scope.selectedReaction === currentreaction) {
                	   graphReactionExists = true;
                       }
                       
                    });
                    $scope.finalstorage[index] = finalItems;
                    
                    //generate the chart for the newly selected drug, only if the graph was generated for previous any drugs.
                    if(graphReactionExists) {
                	$scope.drawChart($scope.selecteddrugs.length-1, $scope.selectedReaction);
                    } else if($scope.selectedReaction !== ''){
            	    	$("#chartDiv").html("Chart is no longer valid for your selected Reaction. Please choose a different Reaction. <br/> <br/>");   
            	    } else {
                	$("#chartDiv").hide();             	
                    }
                });
                $scope.searchForDrug = '';
                $('#progressbar').hide();
            }).error(function(errorResp) {
                alert('Error: ' + errorResp.error.message);
                $('#progressbar').hide();
            });
        };
        
        /**
         * Method to be executed when User removes a particular drug from selected list.
         */
        $scope.remove = function(term) {
            $('#progressbar').show();
            var searchTerm = $scope.normalizeTerm(term);
            
            //remove the term from searchterms array
            var index = $scope.searchterms.indexOf(searchTerm);
            $scope.searchterms.splice(index, 1);

            //remove the term from selected drugs list.
            index = $scope.selecteddrugs.indexOf(term);
            $scope.selecteddrugs.splice(index, 1);

            //run the combination search only if there are any drugs left in the selected list.
            if($scope.selecteddrugs.length > 0) {
                //do individual drug search to get count for each drug.
                $scope.combinedSearch();
            } else {
                $('#progressbar').hide();
                //if the drug list is empty clear off the selectedReaction
                $scope.selectedReaction = '';
            }
        };

        /**
         * Method to check if an array/object is empty.
         */
        $scope.isEmpty = function(arr) {
            for ( var i in arr) {
                if (arr.hasOwnProperty(i))
                return false;
            }
            return true;
        };

        /**
         * Method to get the size of an array.
         */
        $scope.getSize = function(obj) {
            var idx = 0;
            for ( var i in obj) {
                if (obj[i] !== '0') {
                    idx++;
                }
            }
            return idx;
        };

        /**
         * Set Filters when user selects.
         */
        $scope.setFilters = function() {
            $scope.filter='';
            if($scope.countryFilter) {
        	$scope.filter += '+AND+occurcountry:'+$scope.countryFilter;
            }
            if($scope.genderFilter) {
        	$scope.filter += '+AND+patient.patientsex:'+$scope.genderFilter;
            }
            if($scope.outcomeFilter) {
        	$scope.filter += '+AND+serious:'+$scope.outcomeFilter;
            }
        };

        /**
         * Method to apply filters on user selection.
         */
        $scope.applyFilter = function() {
            if($scope.selecteddrugs.length > 0) {
        	$('#progressbar').show();
                //set filters
                $scope.setFilters();
                $scope.searchterms = [];
	        //do individual drug search to get count for each drug.
                var flag = false;
	        $($scope.selecteddrugs).each(function(index) {
	            if(index === $scope.selecteddrugs.length-1 ) {
	        	flag = true;
	            }
	            var searchTerm = $scope.normalizeTerm($scope.selecteddrugs[index]);
	            $scope.indiSearch(searchTerm, flag);
	        });
	    }
        };
        
        /**
         * Method to generate chart when user clicks graph icon on a reaction.
         */
        $scope.drawChart = function(idx, term) {
            var searchTerm = $scope.normalizeTerm(term);
            $http.get(BASE_URL+'limit=1&'+COUNT_PARAM+'&search=patient.reaction.reactionmeddrapt.exact:'+searchTerm, { cache: true})
            .success(function(jsonResp) {
        	$scope.selectedReaction = term;
        	var reactionTotalCount = jsonResp.results[0].count;
        	$("#chartDiv").show();
        	$scope.generateChart(idx, reactionTotalCount, $scope.selectedReaction);
            });
        };
        
        /**
         * Method called from inside of drawChart, this works only when there is total count for any particular reaction.
         */
        $scope.generateChart = function(idx, reactionTotalCount, selectedReaction) {
            var chart = new google.visualization.BarChart(document.getElementById('chartDiv'));
            var data3 = new google.visualization.DataTable();
            data3.addColumn('string','Country');
            data3.addColumn('number','Drug Reactions Reported for ' + selectedReaction);
            data3.addColumn('number','Overall Reactions Reported for ' + selectedReaction);
            
            //do individual drug search to get count for each drug.
            $($scope.selecteddrugs).each(function(index) {
                var name = $scope.selecteddrugs[index].charAt(0).toUpperCase() + $scope.selecteddrugs[index].substring(1);
        	data3.addRows([[name, Number($scope.finalstorage[index][idx]), Number(reactionTotalCount)]]);
            });
            
            var formatter = new google.visualization.NumberFormat({fractionDigits: 0});
            formatter.format(data3, 1);
            formatter.format(data3, 2);
            
            chart.draw(data3, {
                height:175,
                isStacked: 'true',
                legend: {position: 'top'},
                vAxis: {title: ""}, 
                hAxis: {title: ""},
                chartArea: {width: '75%'}
            });
        }
}]);