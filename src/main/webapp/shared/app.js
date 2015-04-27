    'use strict';

angular.module('eventPlannerControllers', ['ngTable','ui.calendar',
    'ngColorPicker','ui.bootstrap','ngTagsInput','mgcrea.ngStrap.datepicker','mgcrea.ngStrap.tooltip','mgcrea.ngStrap.popover','colorpicker.module']);
angular.module('eventPlannerServices', ['ngResource']);

/* App Module */
var eventPlannerApp = angular.module('eventPlannerApp', [
    'ui.select',
    'ngRoute',
    'ngResource',
    'ngCookies',
    'eventPlannerControllers',
    'eventPlannerServices',
    'eventPlannerDirectives',
    'ui.bootstrap',
    'ngTable',
    'mgcrea.ngStrap.datepicker',
    'infinite-scroll',
    'colorpicker.module',
    'wysiwyg.module'
]);

eventPlannerApp.config(
    [ '$routeProvider', '$locationProvider', '$httpProvider','$datepickerProvider',
        function($routeProvider, $locationProvider, $httpProvider, $datepickerProvider) {
        $routeProvider.
            when('/main', {
                templateUrl: 'shared/dashboard/welcome.html',
                auth: true,
                role:'USER'
            }).
            when('/place', {
                templateUrl: 'shared/place/list.html',
                auth: true,
                role:'PLACE'
            }).
            when('/place/add', {
                templateUrl: 'shared/place/add.html',
                auth: true,
                role:'PLACE_CREATE'
            }).
            when('/place/edit/:placeId', {
                templateUrl: 'shared/place/add.html',
                auth: true,
                role:'PLACE_UPDATE'
            }).
            when('/partner', {
                templateUrl: 'shared/partner/list.html',
                auth: true,
                role:'PARTNER'
            }).
            when('/partner/add', {
                templateUrl: 'shared/partner/add.html',
                auth: true,
                role:'PARTNER_CREATE'

            }).
            when('/partner/edit/:partnerId', {
                templateUrl: 'shared/partner/add.html',
                auth: true,
                role:'PARTNER_UPDATE'
            }).
            when('/performer/person', {
                templateUrl: 'shared/performer/person/list.html',
                auth: true,
                role:'PERSON'
            }).
            when('/performer/person/add', {
                templateUrl: 'shared/performer/person/add.html',
                auth: true,
                role:'PERSON_CREATE'
            }).
            when('/performer/person/edit/:performerId', {
                templateUrl: 'shared/performer/person/add.html',
                auth: true,
                role:'PERSON_UPDATE'
            }).
            when('/performer/band', {
                templateUrl: 'shared/performer/band/list.html',
                auth: true,
                role:'BAND'
            }).
            when('/performer/band/add', {
                templateUrl: 'shared/performer/band/add.html',
                auth: true,
                role:'BAND_CREATE'
            }).
            when('/performer/band/edit/:bandId', {
                templateUrl: 'shared/performer/band/add.html',
                auth: true,
                role:'BAND_UPDATE'
            }).
            when('/subscription', {
                templateUrl: 'shared/subscription/list.html',
                auth: true,
                role:'SUBSCRIPTION'
            }).
            when('/subscription/add', {
                templateUrl: 'shared/subscription/add.html',
                auth: true,
                role:'SUBSCRIPTION_CREATE'
            }).
            when('/subscription/edit/:subscriptionId', {
                templateUrl: 'shared/subscription/add.html',
                auth: true,
                role:'SUBSCRIPTION_UPDATE'
            }).
            when('/author',{
                templateUrl: 'shared/author/list.html',
                auth: true,
                role:'AUTHOR'
            }).
            when('/author/add',{
                templateUrl: 'shared/author/add.html',
                auth: true,
                role:'AUTHOR_CREATE'
            }).
            when('/author/edit/:authorId',{
                templateUrl: 'shared/author/add.html',
                auth: true,
                role:'AUTHOR_UPDATE'
            }).
            when('/tour',{
                templateUrl: 'shared/tour/list.html',
                auth: true,
                role:'TOUR'
            }).
            when('/tour/add',{
                templateUrl: 'shared/tour/add.html',
                auth: true,
                role:'TOUR_CREATE'
            }).
            when('/tour/edit/:tourId',{
                templateUrl: 'shared/tour/add.html',
                auth: true,
                role:'TOUR_UPDATE'
            }).
            when('/season',{
                templateUrl: 'shared/season/list.html',
                auth: true,
                role:'SEASON'
            }).
            when('/season/add',{
                templateUrl: 'shared/season/add.html',
                auth: true,
                role:'SEASON_CREATE'
            }).
            when('/season/edit/:seasonId',{
                templateUrl: 'shared/season/add.html',
                auth: true,
                role:'SEASON_UPDATE'
            }).
            when('/work',{
                templateUrl: 'shared/work/list.html',
                auth: true,
                role:'WORK'
            }).
            when('/work/add',{
                templateUrl: 'shared/work/add.html',
                auth: true,
                role:'WORK_CREATE'
            }).
            when('/work/edit/:workId',{
                templateUrl: 'shared/work/add.html',
                auth: true,
                role:'WORK_UPDATE'
            }).
            when('/event/calendar',{
                templateUrl: 'shared/event/calendar.html',
                auth: true,
                role:'EVENT'
            }).
            when('/event/calendar/:date',{
                templateUrl: 'shared/event/calendar.html',
                auth: true,
                role:'EVENT'
            }).
			when('/event/list',{
                templateUrl: 'shared/event/list.html',
                auth: true,
                role:'EVENT'
            }).
            when('/event/add',{
                templateUrl: 'shared/event/add.html',
                auth: true,
                role:'EVENT_CREATE'
            }).
            when('/event/add/:startDate',{
                templateUrl: 'shared/event/add.html',
                auth: true,
                role:'EVENT_CREATE'
            }).
            when('/event/edit/:eventId',{
                templateUrl: 'shared/event/add.html',
                auth: true,
                role:'EVENT_UPDATE'
            }).
            when('/rehearsal/add',{
                templateUrl: 'shared/event/addRehearsal.html',
                auth: true,
                role:'EVENT_CREATE'
            }).
            when('/rehearsal/edit/:rehearsalId',{
                templateUrl: 'shared/event/addRehearsal.html',
                auth: true,
                role:'EVENT_UPDATE'
            }).
            when('/tag',{
                templateUrl: 'shared/tag/list.html',
                auth: true,
                role:'TAG'
            }).
            when('/tag/:category',{
                templateUrl: 'shared/tag/detailsList.html',
                auth: true,
                role:'TAG'
            }).
            when('/user',{
                templateUrl: 'shared/user/account.html',
                auth: true,
                role:'USER'
            }).
            when('/settings',{
                templateUrl: 'shared/user/settings.html',
                auth: true,
                role:'ADMIN'
            }).
            when('/admin',{
                templateUrl: 'shared/admin/userList.html',
                auth: true,
                role:'ADMIN'
            }).
            when('/admin/user/add',{
                templateUrl: 'shared/admin/addUser.html',
                auth: true,
                role:'ADMIN'
            }).
            when('/admin/user/edit/:userId',{
                templateUrl: 'shared/admin/editUser.html',
                auth: true,
                role:'ADMIN'
            }).
            when('/reports',{
                templateUrl: 'shared/reports/reportList.html',
                auth: true,
                role:'REPORTS'
            }).
            when('/login', {
                templateUrl: 'shared/login/login.html'
            }).
            when('/logout', {
                templateUrl: 'shared/login/login.html'
            }).
            otherwise({
                redirectTo: '/main'
            });

//        $locationProvider.hashPrefix('!');

        /* Register error provider that shows message on failed requests or redirects to login page on
         * unauthenticated requests */
        $httpProvider.interceptors.push(function ($q, $rootScope, $location) {
                return {
                    'responseError': function(rejection) {
                        var status = rejection.status;
                        var config = rejection.config;
                        var method = config.method;
                        var url = config.url;

                        if (status == 401) {
                            $rootScope.loggedIn = false;
                            $location.path( "/login" );
                        } else {
                            $rootScope.error = method + " on " + url + " failed with status " + status;
                        }

                        return $q.reject(rejection);
                    }
                };
            }
        );

        /* Registers auth token interceptor, auth token is either passed by header or by query parameter
         * as soon as there is an authenticated user */
        $httpProvider.interceptors.push(function ($q, $rootScope, $location) {
                return {
                    'request': function(config) {
                        var isRestCall = config.url.indexOf('rest') == 0;
                        if (isRestCall && angular.isDefined($rootScope.authToken)) {
                            var authToken = $rootScope.authToken;
                            if (eventPlannerAppConfig.useAuthTokenHeader) {
                                config.headers['X-Auth-Token'] = authToken;
                            } else {
                                config.url = config.url + "?token=" + authToken;
                            }
                        }
//                        else if(isRestCall) {
//                            config.url = eventPlannerAppConfig.appUrl +"/"+ config.url;
//                            console.log(config.url);
//                        }
                        return config || $q.when(config);
                    }
                };
            }
        );

        angular.extend($datepickerProvider.defaults, {
            dateFormat: 'dd-MM-yyyy',
            modelDateFormat :'dd-MM-yyyy',
            dateType:'string',
            startWeek: 1,
            autoclose:1
        });

    }]).run(function($rootScope, $route,$location, $cookieStore,UserService) {

        /* Reset error when a new view is loaded */
        $rootScope.$on('$viewContentLoaded', function() {
            delete $rootScope.error;
//            $rootScope.pageHeader ='';
        });

        $rootScope.$on('$locationChangeStart', function(evt, next, current) {
            var nextPath = $location.path(),
                nextRoute = $route.routes[nextPath];
            if (nextRoute && nextRoute.auth && $cookieStore.get('authToken') == undefined) {
                $location.path("/login");
            }

            if(nextRoute && nextRoute.auth && ! $rootScope.hasRole(nextRoute.role)) {
                console.log("prevent")
                evt.preventDefault();
            }
        });

        $rootScope.hasRole = function(role) {

            if ($rootScope.user === undefined) {
                return false;
            }

            if ($rootScope.user.roles[role] === undefined) {
                return false;
            }

            return $rootScope.user.roles[role];
        };

        $rootScope.logout = function() {
            delete $rootScope.user;
            delete $rootScope.authToken;
            $rootScope.loggedIn = false;
            $cookieStore.remove('authToken');
            $location.path("/login");
        };

        /* Try getting valid user from cookie or go to login page */
        var originalPath = $location.path();
        $location.path("/login");
        var authToken = $cookieStore.get('authToken');
        if (authToken !== undefined) {
            $rootScope.authToken = authToken;
            $rootScope.loggedIn = true;
            UserService.get(function(user) {
                $rootScope.user = user;
                $location.path(originalPath);
            });
        }

        $rootScope.initialized = true;


    });
