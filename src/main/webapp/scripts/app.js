'use strict';

/**
 * @ngdoc overview
 * @name branchManagerApp
 * @description # branchManagerApp
 * 
 * Main module of the application.
 */
angular.module('branchManagerApp', [ 'ngRoute', 'angular-growl' ]).config(function(growlProvider) {
	growlProvider.onlyUniqueMessages(false);
	growlProvider.globalTimeToLive(5000);
});
