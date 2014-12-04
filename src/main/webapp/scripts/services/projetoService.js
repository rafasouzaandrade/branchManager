'use strict';

angular.module('branchManagerApp').service('projetoService', function($http){

  this.loadProjetos = function() {
    return $http.get('projetos');
  };

});
