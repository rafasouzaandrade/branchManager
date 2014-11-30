package ungp.sampleng.backend.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Logradouro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private String cep;

	private String logradouro;
	private String cidade;
	private String bairro;

	private Float score;

	private String tp_logradouro;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getTp_logradouro() {
		return tp_logradouro;
	}

	public void setTp_logradouro(String tp_logradouro) {
		this.tp_logradouro = tp_logradouro;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
