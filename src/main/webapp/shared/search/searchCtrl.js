var searchEngineControllers = angular.module('searchEngineControllers');

searchEngineControllers.controller('searchCtrl', ['$scope','$filter','$rootScope','$modal','SearchService',
    function ($scope,$filter,$rootScope,$modal,SearchService) {
        $scope.searchQuery ={};
        $scope.historicalQueries = [];
        $scope.results = [];

        $scope.getHistoricalQueries  = function() {
            SearchService.getQuires({}, function(successResponse) {
                if(successResponse.error) {
                    handleError(successResponse);
                }else {
                    $scope.historicalQueries  = successResponse.data;
                }
                }, function(errorResponse) { handleError(errorResponse); }
            )
        }


        $scope.getHistoricalQueries();

        $scope.search = function() {
            delete $scope.errorMsg;
            if($scope.searchForm.$valid) {

                var service = new SearchService($scope.searchQuery);
                service.$search({},function(successResponse) {

                        if(successResponse.error) {
                            handleError(successResponse);
                        }else {
                            $scope.results = successResponse.data;
                            $scope.getHistoricalQueries();
                        }
                    },
                function(error) {
                    handleError(error);
                })

               } else {
                console.log("form is not valid")
               }

        }

        $scope.applySearch = function(query) {
            $scope.searchQuery = {params:query.params,filter:query.filter};
            $scope.search()
        }

        var handleError = function(response) {
            if(response.data) {
                $scope.errorMsg = response.data.errorMsg;
            }else {
                $scope.errorMsg = response.errorMsg;
            }
        }


        $scope.openModal = function (result) {

            var modalInstance = $modal.open({
                templateUrl: 'responseDetailsModal.html',
                controller: 'responseDetailsModalCtrl',
//                size: 'sm',
                resolve: {
                    result: function () {
                        return result;
                    }

                }
            });
        };
}]);

searchEngineControllers.controller('responseDetailsModalCtrl', function ($scope, $modalInstance, result) {

    $scope.result = result;

    $scope.close = function () {
        $modalInstance.dismiss('cancel');
    };
});


