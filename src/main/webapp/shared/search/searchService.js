var services = angular.module('searchEngineServices');

services.factory('SearchService', function($resource) {
    return $resource('rest/search/:queries', {},
        {
            getQuires:{
                method:'GET',
                params: {'queries':'queries'}
            },
            search: {
                method:'POST'
            }
        }
    );
});