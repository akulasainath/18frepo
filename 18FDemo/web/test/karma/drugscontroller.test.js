describe(
		'openFDAApp',
		function() {

			beforeEach(module('openFDAApp'));

			describe(
					"DrugsController",
					function() {
						var scope, controller, httpBackend;

						beforeEach(inject(function($controller, $rootScope,
								$httpBackend) {
							scope = $rootScope.$new();
							httpBackend = $httpBackend;
							controller = $controller;
							httpBackend
									.when(
											"GET",
											'https://api.fda.gov/drug/event.json?limit=1000&count=patient.reaction.reactionmeddrapt.exact&search=(patient.drug.openfda.generic_name:"aspirin"+patient.drug.openfda.brand_name:"aspirin")')
									.respond([ {
										result : 'success'
									} ]);
							httpBackend
							.when(
									"GET",
									'https://api.fda.gov/drug/event.json?limit=1000&count=patient.reaction.reactionmeddrapt.exact&search=(patient.drug.openfda.generic_name:+patient.drug.openfda.brand_name:)')
							.respond([ {
								result : 'success'
							} ]);
						}));

						it(
								'checks for result undefined when no JSON object is found',
								function() {

									httpBackend
											.expectGET('https://api.fda.gov/drug/event.json?limit=1000&count=patient.reaction.reactionmeddrapt.exact&search=(patient.drug.openfda.generic_name:"aspirin"+patient.drug.openfda.brand_name:"aspirin")');
									controller('DrugsController', {
										$scope : scope
									});
									var results = scope.indiSearch('"aspirin"',
											false);

									httpBackend.flush();
									expect(scope.indiDrugReactionResults["aspirin"]).not
											.toBeDefined();

								});
						
						it(
								'checks for search term from the controller',
								function() {

									httpBackend
											.expectGET('https://api.fda.gov/drug/event.json?limit=1000&count=patient.reaction.reactionmeddrapt.exact&search=(patient.drug.openfda.generic_name:"aspirin"+patient.drug.openfda.brand_name:"aspirin")');
									controller('DrugsController', {
										$scope : scope
									});
									var results = scope.indiSearch('"aspirin"',
											false);

									httpBackend.flush();
									expect(scope.searchterms.indexOf('aspirin'))
											.toEqual(-1);

								});

						it(
								'checks for search result in combined search',
								function() {

									httpBackend
											.expectGET('https://api.fda.gov/drug/event.json?limit=1000&count=patient.reaction.reactionmeddrapt.exact&search=(patient.drug.openfda.generic_name:+patient.drug.openfda.brand_name:)');
									controller('DrugsController', {
										$scope : scope
									});
									var results = scope.combinedSearch();

									httpBackend.flush();
									expect(scope.searchterms.indexOf('aspirin'))
											.toEqual(-1);

								});
					});
		});
