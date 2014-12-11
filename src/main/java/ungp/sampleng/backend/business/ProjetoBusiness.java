package ungp.sampleng.backend.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import ungp.sampleng.backend.dto.BranchDTO;
import ungp.sampleng.backend.dto.CommitDTO;
import ungp.sampleng.backend.dto.DetalhesProjetoDTO;
import ungp.sampleng.backend.dto.ProjetoDTO;
import ungp.sampleng.backend.tfs.TfsConnector;

import com.microsoft.tfs.core.TFSTeamProjectCollection;
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
        // VersionControlClient versionControlClient = connection.getVersionControlClient();
        // ItemIdentifier itemIdentifier = new ItemIdentifier("$/FXDNet/fManutencao");
        // BranchObject[] branchObjects = versionControlClient.queryBranchObjects(itemIdentifier,
        // RecursionType.FULL);
        // System.out.println(branchObjects);
        // Changeset[] pete = versionControlClient.queryHistory("$/FXDNet/fManutencao",
        // LatestVersionSpec.INSTANCE, 0, RecursionType.FULL, "",
        // VersionSpec.parseSingleVersionFromSpec("95000", null),
        // null, Integer.MAX_VALUE, false, false, false, false);
        // System.out.println(pete);

        ProjectCollection projects = workItemClient.getProjects();
        List<ProjetoDTO> projetos = new ArrayList<ProjetoDTO>();
        for (Project project : projects) {
            ProjetoDTO projetoDTO = createDTO(project);
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

    private ProjetoDTO createDTO(Project project) {
        ProjetoDTO projetoDTO = new ProjetoDTO();
        projetoDTO.setNome(project.getName());
        projetoDTO.setId(project.getID());
        return projetoDTO;
    }

    private Project getProject(Integer idProjeto) {
        WorkItemClient workItemClient = connection.getWorkItemClient();
        ProjectCollection projects = workItemClient.getProjects();
        for (Project project : projects) {
            if (idProjeto.equals(project.getID())) {
                return project;
            }
        }
        return null;
    }

    public DetalhesProjetoDTO detalhesProjeto(Integer idProjeto) {
        Project project = getProject(idProjeto);
        DetalhesProjetoDTO detalhes = null;
        if (project != null) {
            detalhes = new DetalhesProjetoDTO();
            detalhes.setNome(project.getName());
            detalhes.setId(project.getID());
            detalhes.setBranches(getBranches(detalhes));
            detalhes.setInitialCommit(getInitialCommit(project));
        }
        return detalhes;
    }

    // FIXME: MOCK
    private CommitDTO getInitialCommit(Project project) {
        Calendar calData = Calendar.getInstance();
        calData.add(Calendar.YEAR, -1);
        return new CommitDTO(1, calData.getTime(), "Initial Commit", "Rafael de Souza Andrade");
    }

    // FIXME: MOCK
    private List<BranchDTO> getBranches(DetalhesProjetoDTO detalhesProjetoDTO) {
        List<BranchDTO> branches = new ArrayList<BranchDTO>();
        Calendar calData = Calendar.getInstance();
        branches.add(criarBranch(1, "deres-salt-78890", calData));
        calData.add(Calendar.MONTH, 1);
        branches.add(criarBranch(2, "derpr-salt-78990", calData));
        return branches;
    }

    // FIXME: MOCK
    private BranchDTO criarBranch(Integer id, String nome, Calendar calDataParam) {
        Calendar calData = (Calendar) calDataParam.clone();
        BranchDTO branchDTO = new BranchDTO(id, calData.getTime(), nome);
        List<CommitDTO> merges = new ArrayList<CommitDTO>();

        calData.add(Calendar.WEEK_OF_YEAR, 1);
        merges.add(new CommitDTO(id, calData.getTime(), "Reverse Merge 1", "Rafael de Souza Andrade"));
        calData.add(Calendar.WEEK_OF_YEAR, 1);
        merges.add(new CommitDTO(id, calData.getTime(), "Reverse Merge 2", "Rafael de Souza Andrade"));

        branchDTO.setCommits(merges);
        return branchDTO;
    }

}
