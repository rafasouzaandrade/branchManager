package ungp.sampleng.backend.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import ungp.sampleng.backend.dto.ProjetoDTO;
import ungp.sampleng.backend.tfs.TfsConnector;

import com.microsoft.tfs.core.TFSTeamProjectCollection;
import com.microsoft.tfs.core.clients.versioncontrol.VersionControlClient;
import com.microsoft.tfs.core.clients.versioncontrol.soapextensions.BranchObject;
import com.microsoft.tfs.core.clients.versioncontrol.soapextensions.Changeset;
import com.microsoft.tfs.core.clients.versioncontrol.soapextensions.ItemIdentifier;
import com.microsoft.tfs.core.clients.versioncontrol.soapextensions.RecursionType;
import com.microsoft.tfs.core.clients.versioncontrol.specs.version.LatestVersionSpec;
import com.microsoft.tfs.core.clients.versioncontrol.specs.version.VersionSpec;
import com.microsoft.tfs.core.clients.workitem.WorkItemClient;
import com.microsoft.tfs.core.clients.workitem.project.Project;
import com.microsoft.tfs.core.clients.workitem.project.ProjectCollection;

@Component
public class ProjetoBusiness {

	private TFSTeamProjectCollection connection;

	@PostConstruct
	private void postConstruct() {
		connection = TfsConnector.connectToTFS();
	}

	public List<ProjetoDTO> findAll() {
		WorkItemClient workItemClient = connection.getWorkItemClient();
		VersionControlClient versionControlClient = connection.getVersionControlClient();
		ItemIdentifier itemIdentifier = new ItemIdentifier("$/FXDNet/fManutencao");
		BranchObject[] branchObjects = versionControlClient.queryBranchObjects(itemIdentifier, RecursionType.FULL);
		System.out.println(branchObjects);
//		Changeset[] pete = versionControlClient.queryHistory("$/FXDNet/fManutencao", LatestVersionSpec.INSTANCE, 0, RecursionType.FULL, "", VersionSpec.parseSingleVersionFromSpec("95000", null),
//				null, Integer.MAX_VALUE, false, false, false, false);
//		System.out.println(pete);

		ProjectCollection projects = workItemClient.getProjects();
		List<ProjetoDTO> projetos = new ArrayList<ProjetoDTO>();
		for (Project project : projects) {
			ProjetoDTO projetoDTO = new ProjetoDTO();
			projetoDTO.setNome(project.getName());
			projetos.add(projetoDTO);
		}

		Collections.sort(projetos, new Comparator<ProjetoDTO>() {

			@Override
			public int compare(ProjetoDTO o1, ProjetoDTO o2) {
				return o1.getNome().compareTo(o2.getNome());
			}
		});

		return projetos;
	}
}
