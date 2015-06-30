'use strict';

google.load("visualization", "1", {
    packages : [ "corechart" ]
});

angular.module('openFDAApp').controller('DrugsController', ['$scope', '$http', '$location', '$q',
    function($scope, $http, $location, $q) {
    
    	//general scope attributes
        $scope.searchForDrug = '';
        $scope.selecteddrugs = [];
        $scope.top10Reactions = [];
        $scope.indiDrugReactionResults = [];
        $scope.searchterms = [];
        $scope.selectedReaction = '';
        $scope.chartColors = ['#D2FF54', '#FFD154', '#FF54D2', '#D154FF', '#54D2FF'];
        
        //filters
        $scope.genderFilter = '';
        $scope.outcomeFilter = '';
        $scope.filter = '';
        
        //we take 100 reactions but display only top 10
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
            
            //set default filters, if any
            $scope.setFilters();
            
            //call indi drug search, this will in turn call combination search if success.
            var searchTerm = $scope.normalizeTerm($scope.searchForDrug);
            $scope.indiSearch(searchTerm, true);
            $scope.selecteddrugs.push($scope.searchForDrug);
        };
        
        $scope.normalizeTerm = function(term) {
            return '"'+term.replace(/\,/g, '').replace(/\ /g, '+')+'"';
        }
        
        /**
         * Method for Individual Drug Search.
         * For Ex: Where drug brand name or generic name is Drug A
         */
        $scope.indiSearch = function(searchTerm, flag) {
            $scope.searchterms.push(searchTerm);
            $http.get(BASE_URL+ LIMIT_1000_PARAM + '&'+COUNT_PARAM+'&search=('+GENERIC_NAME+ searchTerm + '+' + BRAND_NAME + searchTerm + ')'+$scope.filter, { cache: true})
            	.success(function(jsonResp) {
            	    $scope.indiDrugReactionResults[searchTerm] = jsonResp.results;
            	    if(flag) {
            		$scope.combinedSearch();
            	    }
            	}).error(function(errorResp, response) {
                    //no search term found, remove the term from the list.
            	    var index = $scope.selecteddrugs.indexOf(searchTerm);
        	    $scope.selecteddrugs.splice(index, 1);
        	    var index = $scope.searchterms.indexOf(searchTerm);
            	    $scope.searchterms.splice(index, 1);
            	    
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
                var reactionIdxMain = -1;
                
                $(jsonResp.results).each(function(index) {
                    if(index < REACTION_LIMIT) {
                        $scope.top10Reactions.push($(this)[0]);
                    }
                });
                
                //loop thru each search term to get drug counts
                $($scope.searchterms).each(function(index){
                    var currentTerm = $scope.searchterms[index];
                    var finalItems = [];
                    
                    //loop thru reaction items to get the reaction counts
                    $($scope.top10Reactions).each(function(reactionIdx) {
                       var currentreaction =  $(this)[0].term;
                       finalItems[reactionIdx] = '';
                       //loop thru all reactions for individual drug and bring out required counts.
                       $($scope.indiDrugReactionResults[currentTerm]).each(function(){
                           if($(this)[0].term === currentreaction) {
                               finalItems[reactionIdx] = $(this)[0].count;
                               //return false;
                           }
                       });
                       
                       //check if graph reaction selected exists, else we have to close the graph section.
                       if($scope.selectedReaction === currentreaction) {
                	   graphReactionExists = true;
                	   reactionIdxMain = reactionIdx;
                       }
                    });
                    $scope.finalstorage[index] = finalItems;
                });
                
                //generate the chart for the newly selected drug, only if the graph was generated for previous any drugs.
                if(graphReactionExists) {
                    $scope.drawChart(reactionIdxMain, $scope.selectedReaction);
                } else if($scope.selectedReaction !== ''){
                    $("#chartDiv").html("Chart is no longer valid for your selected Reaction. Please choose a different Reaction. <br/> <br/>");
                } else {
                    $("#chartDiv").hide();
                }
                
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
                //if the drug list is empty, clear off the values
                $scope.searchForDrug = '';
                $scope.selecteddrugs = [];
                $scope.top10Reactions = [];
                $scope.indiDrugReactionResults = [];
                $scope.searchterms = [];
                $scope.selectedReaction = '';
                $scope.genderFilter = '';
                $scope.outcomeFilter = '';
                $scope.filter = '';
                $scope.chart.clearChart();
                $scope.chart='';
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
            $('#progressbar').show();
            if($scope.chart) {
    	    	$scope.chart.clearChart();
            }
            $scope.drugCounts = [];
            $scope.idx = idx;
            $("#chartDiv").show();
            var promises = [];
            var defer = $q.defer();
            $($scope.selecteddrugs).each(function(index){
        	var searchTerm = $scope.normalizeTerm($scope.selecteddrugs[index]);
        	promises.push($http.get('https://api.fda.gov/drug/event.json?search=(patient.drug.openfda.generic_name:'+searchTerm+'+patient.drug.openfda.brand_name:'+searchTerm+')'+$scope.filter));
            });
            $q.all(promises).then(function(jsonResp){
        	$scope.selectedReaction = term
        	$($scope.selecteddrugs).each(function(index){
        	    $scope.drugCounts[index] = jsonResp[index].data.meta.results.total;
        	});
        	defer.resolve();
        	$scope.generateChart(idx, term);
            });
        };
        
        /**
         * Method called from inside of drawChart, this works only when there is total count for any particular reaction.
         */
        $scope.generateChart = function(idx, selectedReaction) {
            var data3 = new google.visualization.DataTable();
            data3.addColumn('string','Drugs');
            data3.addColumn('number', selectedReaction + ' Reports');
            data3.addColumn({type:'string', role:'style'});
            data3.addColumn('number','All Adverse Events');
            data3.addColumn({type:'string', role:'style'});
            //do individual drug search to get count for each drug.
            $($scope.selecteddrugs).each(function(index) {
                var name = $scope.capitalize($scope.selecteddrugs[index]);
        	data3.addRow([name, Number($scope.finalstorage[index][idx]), 'color:' + $scope.chartColors[index] + ';stroke-color: #01519a; stroke-width: 2; stroke-opacity: 1;', Number($scope.drugCounts[index]), 'color:#01519A']);
            });
            
            var formatter = new google.visualization.NumberFormat({fractionDigits: 0});
            formatter.format(data3, 1);
            formatter.format(data3, 3);
            
            $scope.chart = new google.visualization.BarChart(document.getElementById('chartDiv'));
            
            
            $scope.chart.draw(data3, {
        	title: 'Reaction: ' + selectedReaction,
                isStacked: 'percent',
                legend: {position: 'none'},
                tooltip: {
                    trigger: 'both'
                },
                hAxis: {
                    title: 'Adverse Events',
                    titleTextStyle: {bold: true, fontSize: 16}
                },
                backgroundColor: { fill:'transparent' }
            });
            
            
            $('#progressbar').hide();
        }
        
        $scope.capitalize = function(term) {
            return term.charAt(0).toUpperCase() + term.substring(1);
        }
        
        //when the window resizes, redraw the chart to make it responsive.
        var width = $(window).width();
        $(window).resize(function (event) {
            if($scope.selectedReaction && ($(window).width() != width)) { 
        	$scope.drawChart($scope.idx,  $scope.selectedReaction);
            }
        });
}]);