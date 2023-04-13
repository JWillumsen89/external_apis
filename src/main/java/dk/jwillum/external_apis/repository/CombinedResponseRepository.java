package dk.jwillum.external_apis.repository;

import dk.jwillum.external_apis.dto.CombinedResponse;
import dk.jwillum.external_apis.entity.CombinedResponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CombinedResponseRepository  extends JpaRepository<CombinedResponseEntity, Integer> {

  CombinedResponseEntity findByName(String name);
}
