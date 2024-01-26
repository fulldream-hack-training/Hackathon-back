package hack.fulldream.hackathonback.repository;

import hack.fulldream.hackathonback.models.EndTutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EndTutorRepository extends JpaRepository<EndTutor, UUID> {
    EndTutor findByEmail(String email);
}