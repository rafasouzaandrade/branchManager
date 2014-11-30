package ungp.sampleng.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ungp.sampleng.backend.entity.Condutor;

public interface CondutorRepository extends JpaRepository<Condutor, Long> {

}
