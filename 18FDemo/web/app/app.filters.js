'use strict';

angular.module('openFDAApp').filter('textOrNumber', ['$filter', function($filter) {
	return function(input) {
	if (isNaN(input)) {
	    return "<b>-</b>";
	} else {
	    return $filter('number')(input);
	}
    };
}
]);