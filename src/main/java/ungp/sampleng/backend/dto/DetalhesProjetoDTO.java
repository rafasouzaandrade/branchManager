package ungp.sampleng.backend.dto;

import java.util.List;

public class DetalhesProjetoDTO extends ProjetoDTO {

    private List<BranchDTO> branches;
    private CommitDTO initialCommit;

    public List<BranchDTO> getBranches() {
        return branches;
    }

    public void setBranches(List<BranchDTO> branches) {
        this.branches = branches;
    }

    public CommitDTO getInitialCommit() {
        return initialCommit;
    }

    public void setInitialCommit(CommitDTO initialCommit) {
        this.initialCommit = initialCommit;
    }

}
