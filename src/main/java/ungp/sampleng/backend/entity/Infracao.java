package ungp.sampleng.backend.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Infracao implements Serializable {

	private static final long serialVersionUID = 6279552463751962664L;

	@Id
	private Long id;
	private Date dtInfracao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "logradouro")
	private Logradouro logradouro;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "condutor")
	private Condutor condutor;

	public Date getDtInfracao() {
		return dtInfracao;
	}

	public void setDtInfracao(Date dtInfracao) {
		this.dtInfracao = dtInfracao;
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public Condutor getCondutor() {
		return condutor;
	}

	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}

	public boolean isCondutorProprietario() {
		return getCondutor().isProprietario();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
