package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.Transaction;
import hack.fulldream.hackathonback.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepo;

    public List<Transaction> findAll() {
        return transactionRepo.findAll();
    }

    public Optional<Transaction> findById(UUID id) {
        return transactionRepo.findById(id);
    }

    public Transaction save(Transaction save) {
        return transactionRepo.save(save);
    }

    public Optional<Transaction> delete(UUID id) {
        Optional<Transaction> toDelete = transactionRepo.findById(id);
        if (toDelete.isPresent()) {
            transactionRepo.deleteById(id);
        }
        return toDelete;
    }

    @Transactional
    public List<Transaction> delete(List<UUID> ids) {
        List<Transaction> toDelete = transactionRepo.findAllById(ids);
        if (ids.size() == toDelete.size()) {
            transactionRepo.deleteAllById(ids);
        }
        return toDelete;
    }

}
