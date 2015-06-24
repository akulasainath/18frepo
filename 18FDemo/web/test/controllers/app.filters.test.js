describe('openFDAApp', function() {
  beforeEach(function () {
      module('openFDAApp');
  });

  it('is a number', inject(function($filter) {
      expect($filter('textOrNumber')).not.toBeNull();
      var length = $filter('number');
      expect(length(5, 1));
  }));
});