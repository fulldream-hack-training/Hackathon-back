package hack.fulldream.hackathonback.repository;

import hack.fulldream.hackathonback.models.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChallengeRepository extends JpaRepository<Challenge, UUID> {
}
