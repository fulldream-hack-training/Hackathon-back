package hack.fulldream.hackathonback.repository;

import hack.fulldream.hackathonback.models.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BalanceRepository extends JpaRepository<Balance, UUID> {

}
