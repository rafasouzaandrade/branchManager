package ungp.sampleng.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ungp.sampleng.backend.entity.Infracao;

public interface InfracaoRepository extends JpaRepository<Infracao, Long> {

	List<Infracao> findByCondutorCpf(String cpf);
	
}

