package pe.edu.pucp.msuser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.pucp.msuser.entity.Credential;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, Integer> {
}
