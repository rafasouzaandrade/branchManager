'use strict';

angular.module('branchManagerApp').controller('MainCtrl', function($scope, projetoService) {
	$scope.projetos = [];

	$scope.loadProjetos = function() {
		projetoService.loadProjetos().success(function(projetos) {
			$scope.projetos = projetos;
		});
	};

	$scope.$watch('$viewContentLoaded', function() {
		$scope.loadProjetos();
	});
});
