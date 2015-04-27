    'use strict';

angular.module('searchEngineControllers', []);
angular.module('searchEngineServices', ['ngResource']);

/* App Module */
var searchEngineApp = angular.module('searchEngineApp', [
    'ngResource',
    'searchEngineControllers',
    'searchEngineServices'
]);

searchEngineApp.config(
    [
        function() {


//        $locationProvider.hashPrefix('!');


    }]).run(function($rootScope) {

    });
