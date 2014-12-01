'use strict';

/**
 * @ngdoc function
 * @name branchManagerApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the branchManagerApp
 */

angular.module('branchManagerApp')
  .controller('MainCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
