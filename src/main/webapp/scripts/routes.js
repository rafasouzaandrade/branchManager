'use strict';

/**
 * @ngdoc overview
 * @name branchManagerApp
 * @description # branchManagerApp
 * 
 * Main module of the application.
 */
angular.module('branchManagerApp').config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'partials/dashboard.html',
		controller : 'MainCtrl'
	}).when('/projetos/:idProjeto', {
		templateUrl : 'partials/detalhesProjeto.html',
		controller : 'DetalhesProjetoCtrl'
	}).otherwise({
		redirectTo : '/'
	});
});
