package ungp.sampleng.backend.dto;

import java.util.Date;

public class CommitDTO {

    private Integer id;
    private Date dataCriacao;
    private String nome;
    private String autor;

    public CommitDTO() {

    }

    public CommitDTO(Integer id, Date dataCriacao, String nome, String autor) {
        super();
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.nome = nome;
        this.autor = autor;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
