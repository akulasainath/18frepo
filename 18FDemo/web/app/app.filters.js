var filters = {};

filters.textOrNumber = function($filter) {
    return function(input) {
	if (isNaN(input)) {
	    return "<b>-</b>";
	} else {
	    return $filter('number')(input);
	}
    };
}
demoApp.filter(filters);