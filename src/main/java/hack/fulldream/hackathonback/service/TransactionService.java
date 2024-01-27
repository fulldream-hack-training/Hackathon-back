package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.Tip;
import hack.fulldream.hackathonback.models.Transaction;
import hack.fulldream.hackathonback.repository.TransactionRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepo;

    public Optional<Transaction> delete(UUID id) {
        Optional<Transaction> toDelete = transactionRepo.findById(id);
        if (toDelete.isPresent()) {
            transactionRepo.deleteById(id);
        }
        return toDelete;
    }

    public List<Transaction> findByKidId(UUID id) {
        return transactionRepo.findByKidId(id);
    }

    public Optional<Transaction> findById(UUID id) {
        return transactionRepo.findById(id);
    }

    public Transaction save(Transaction transaction) {
        return transactionRepo.save(transaction);
    }
}
