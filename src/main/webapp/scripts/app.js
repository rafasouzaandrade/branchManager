'use strict';

/**
 * @ngdoc overview
 * @name branchManagerApp
 * @description
 * # branchManagerApp
 *
 * Main module of the application.
 */
angular
  .module('branchManagerApp', ['ngRoute','angular-growl'])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/dashboard.html',
        controller: 'MainCtrl'
      })
      .when('/veiculos', {
        templateUrl: 'views/veiculos.html',
        controller: 'VeiculoListCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  })
  .config(function(growlProvider) {
    growlProvider.onlyUniqueMessages(false);
    growlProvider.globalTimeToLive(5000);
  });
