package hack.fulldream.hackathonback.repository;

import hack.fulldream.hackathonback.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    List<Transaction> findByKidId(UUID id);
}
