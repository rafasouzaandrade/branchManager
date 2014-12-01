'use strict';

/**
 * @ngdoc function
 * @name branchManagerApp.controller:VeiculoCtrl
 * @description
 * # VeiculoCtrl
 * Controller of the branchManagerApp
 */
var veiculoListCtrl = angular.module('branchManagerApp').controller('VeiculoListCtrl', function ($scope,$routeParams, $location, veiculoService, growl) {

  $scope.loadVeiculos = function() {

    veiculoService.loadVeiculos()
      .success(function (veiculos) {
        $scope.veiculos = veiculos;
      });
  };
 
  $scope.deleteVeiculo = function(veiculo) {

    veiculoService.deleteVeiculo(veiculo)
      .success(function () {
        $scope.loadVeiculos();
        growl.success('Veículo removido com sucesso.');
      });

  };

});