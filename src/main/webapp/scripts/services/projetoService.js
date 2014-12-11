'use strict';

angular.module('branchManagerApp').service('projetoService', function($http) {

	this.loadProjetos = function() {
		return $http.get('projetos');
	};

	this.detalhesProjeto = function(id) {
		return $http.get('projetos/' + id);
	};

});
