package ungp.sampleng.backend.dto;

import java.util.Date;
import java.util.List;

public class BranchDTO {

    private Integer id;
    private Date dataCriacao;
    private String nome;
    private List<CommitDTO> commits;
    
    public BranchDTO() {
        
    }

    public BranchDTO(Integer id, Date dataCriacao, String nome) {
        super();
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<CommitDTO> getCommits() {
        return commits;
    }

    public void setCommits(List<CommitDTO> commits) {
        this.commits = commits;
    }
}
