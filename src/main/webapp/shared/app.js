    'use strict';

angular.module('searchEngineControllers', []);
angular.module('searchEngineServices', ['ngResource']);

/* App Module */
var searchEngineApp = angular.module('searchEngineApp', [
    'ngResource',
    'searchEngineControllers',
    'searchEngineServices' ,'ui.bootstrap'
]);

searchEngineApp.config(
    [
        function() {


//        $locationProvider.hashPrefix('!');


    }]).run(function($rootScope) {

    });
