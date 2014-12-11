'use strict';

angular.module('branchManagerApp').controller('DetalhesProjetoCtrl', function($scope, $routeParams, projetoService) {
	$scope.idProjeto = $routeParams.idProjeto;
	$scope.detalhesProjeto = null;
	$scope.gitGraph = null;

	$scope.verDetalhesProjeto = function() {
		projetoService.detalhesProjeto($scope.idProjeto).success(function(detalhesProjeto) {
			$scope.detalhesProjeto = detalhesProjeto;
			var branchs = [];

			var gitGraph = new GitGraph({
				template : "metro",
				orientation : "vertical"
			});

			var master = gitGraph.branch(detalhesProjeto.nome + " - Master");
			var initialCommit = detalhesProjeto.initialCommit;
			master.commit({
				message : initialCommit.nome,
				author : initialCommit.autor,
				sha1 : "",
				date : initialCommit.dataCriacao
			});
			var branches = detalhesProjeto.branches;
			for (var i = 0; i < branches.length; i++) {
				var branch = branches[i];
				master.checkout();
				var dev = gitGraph.branch(branch.nome);
				dev.commit({
					message : branch.nome,
					author : "Rafael De Souza Andrade",
					sha1 : "",
					date : branch.dataCriacao
				});

				var commits = branch.commits;
				for (var j = 0; j < commits.length; j++) {
					master.merge(dev);
				}

				branchs.push(dev);
			}

			for (var i = 0; i < branchs.length; i++) {
				branchs[i].merge(master);
			}

		});
	};

	$scope.verDetalhesProjeto();
});
