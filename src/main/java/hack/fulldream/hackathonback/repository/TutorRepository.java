package hack.fulldream.hackathonback.repository;

import hack.fulldream.hackathonback.models.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, UUID> {
    public Tutor findByEmail(String email);
}
