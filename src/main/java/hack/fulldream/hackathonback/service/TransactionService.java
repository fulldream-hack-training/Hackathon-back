package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.Balance;
import hack.fulldream.hackathonback.models.Savings;
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
    private final BalanceService balanceService;
    private final SavingService savingService;

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

    public void applyTransaction(Transaction transaction){
        Double newBalance = balanceService.getLastBalance(transaction.getKid().getId());

        switch (transaction.getType()){
            case "SAVING" :
                Savings newSaving = savingService.findByIdKid(transaction.getKid().getId());
                newSaving.setValue(newSaving.getValue() + transaction.getAmount());
                savingService.save(newSaving);
            case "DEBIT" :
                newBalance += transaction.getAmount();
                break;
            case "CREDIT" :
                newBalance -= transaction.getAmount();
        }

        Balance newBalanceModel = new Balance();
        newBalanceModel.setAmount(newBalance);
        balanceService.save(newBalanceModel);

    }
}
