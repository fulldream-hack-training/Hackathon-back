package hack.fulldream.hackathonback.repository;

import hack.fulldream.hackathonback.models.Tip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TipRepository extends JpaRepository<Tip, UUID> {
    List<Tip> findByTutorId(UUID tutorId);
}