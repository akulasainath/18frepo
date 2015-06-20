function monkeyPatchAutocomplete() {
    $.ui.autocomplete.prototype._renderItem = function(ul, item) {
	var re = new RegExp($.ui.autocomplete.escapeRegex(this.term), "i");
	var t = item.label.replace(re, "<span style='font-weight:bold;'>"
		+ "$&" + "</span>");
	return $("<li></li>").data("item.autocomplete", item).append(
		"<a>" + t + "</a>").appendTo(ul);
    };
}

function enableAutoComplete(elemID, uri) {
    // this method will make the matching text appear in bold when typing
    // keyword.
    monkeyPatchAutocomplete();

    var input = $("#" + elemID);
    input.autocomplete({
	source : function(request, response) {
	    var searchTerm = request.term.replace(/\ /g, '+');
	    $.ajax({
		url : "https://api.fda.gov/drug/label.json?limit=15&search=openfda.generic_name:" + searchTerm.toLowerCase() + "+openfda.brand_name:" + searchTerm.toLowerCase(),
		success : function(data) {
		    var arr = [];
		    $(data.results).each(function(idx) {
			var brandname = $(this)[0].openfda.brand_name[0];
			var genericname = $(this)[0].openfda.generic_name[0];
			
			if(brandname.toLowerCase().indexOf(request.term.toLowerCase()) >= 0) {
			    arr.push(brandname.toLowerCase());
			}
			if(genericname.toLowerCase().indexOf(request.term.toLowerCase()) >= 0) {
			    arr.push(genericname.toLowerCase());
			}
		    });
		    response($.unique(arr));
		}
	    });
	},
	minLength : 3,
	select : function(event, ui) {
	    // set the select option as input value
	    input.val(ui.item.label).change();
	    input.blur();
	    input.focus();
	},
	open : function() {
	    $(this).removeClass("ui-corner-all").addClass("ui-corner-top");
	},
	close : function() {
	    $(this).removeClass("ui-corner-top").addClass("ui-corner-all");
	}
    });
}
