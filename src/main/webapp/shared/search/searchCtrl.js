var searchEngineControllers = angular.module('searchEngineControllers');

searchEngineControllers.controller('searchCtrl', ['$scope','$filter','$rootScope','SearchService',
    function ($scope,$filter,$rootScope,SearchService) {
        $scope.searchQuery ={};
        $scope.historicalQueries = [];

        $scope.msg = "asd";

        $scope.results = [];


        $scope.getHistoricalQueries  = function() {
            SearchService.getQuires({}, function(successResponse) {
                        $scope.historicalQueries  = successResponse.data;
                }, function(errorResponse) { handleError(errorResponse.errorMessage); }
            )
        }


        $scope.getHistoricalQueries();

        $scope.search = function() {
            var service = new SearchService($scope.searchQuery);
            service.$search({},function(successResponse) {
                    console.log(successResponse);
                    $scope.results = successResponse.data;
                    $scope.getHistoricalQueries();
                },
            function(error) {
                console.log(error);

            })


        }

        var handleError = function(response) {
            $rootScope.error = response.errors[0];
        }


    }]);
