'use strict';

var contactsApp = {};

var App = angular.module('contactsApp', ['contactsApp.filters', 'contactsApp.services', 'contactsApp.directives']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/contact', {
        templateUrl: 'app/views/contact',
        controller: ContactController
    });

    $routeProvider.otherwise({redirectTo: '/contact'});
}]);
