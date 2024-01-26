package hack.fulldream.hackathonback.repository;

import hack.fulldream.hackathonback.models.EndUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EndUserRepository extends JpaRepository<EndUser, UUID> {
    EndUser findByUsername(String username);
}