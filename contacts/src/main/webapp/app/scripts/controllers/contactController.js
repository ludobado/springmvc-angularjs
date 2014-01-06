'use strict';

/**
 * contactController
 * @constructor
 */
var ContactController = function($scope, $http) {
	
	$scope.contact = {};
	
    $scope.fetchContactList = function() {
        $http.get('service/contact/list').success(function(contactList){
            $scope.contacts = contactList;
        });
    }

    $scope.addContact = function(contact) {
    	$scope.resetError();
    	
        $http.post('service/contact/add', contact).success(function() {
            $scope.fetchContactList();
            $scope.contact.firstname = '';
            $scope.contact.lastname = '';
            $scope.contact.age = '';
        }).error(function() {
            $scope.setError('Could not add a new contact');
        });
    }

    $scope.removeContact = function(contact) {
        $http.post('service/contact/remove', contact).success(function() {
            $scope.fetchContactList();
        }).error(function() {
            $scope.setError('Could not remove contact: ' + contact.firstname);
        });
    }

    $scope.resetContactForm = function() {
        $scope.resetError();
        $scope.contact = {};
    }

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    }

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    }


    $scope.fetchContactList();
    
}