'use strict';

angular.module('branchManagerApp').service('veiculoService', function($http){

  this.loadVeiculos = function() {
    return $http.get('veiculo');
  };

  this.insertVeiculo = function(veiculo) {
    return $http.post('veiculo', veiculo);
  };

  this.updateVeiculo = function(veiculo) {
    return $http.put('veiculo', veiculo);
  };

  this.deleteVeiculo = function(veiculo) {
    return $http.post('veiculo/'+ veiculo.placa);
  };

  this.loadVeiculo = function(placa) {
    return $http.get('veiculo/' + placa);
  };

});
