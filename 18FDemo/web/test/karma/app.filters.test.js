describe('Filter Test', function() {
	'use strict';
	var $filter;
	beforeEach(function() {
		module('openFDAApp');
		inject(function(_$filter_) {
			$filter = _$filter_;
		});
	});

	it('string', function() {
		var foo = 'Test String', result;
		result = $filter('textOrNumber')(foo, 'string');
		expect(result).toEqual('<b>-</b>');
	});

	it('special char', function() {
		var foo = '#', result;
		result = $filter('textOrNumber')(foo, 'special char');
		expect(result).toEqual('<b>-</b>');
	});

	it('number', function() {
		var foo = 12, result;
		result = $filter('textOrNumber')(foo, Number(foo));
		expect(result).toEqual('12');
	});
});