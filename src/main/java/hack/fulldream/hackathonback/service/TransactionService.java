package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.Balance;
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
    private final BalanceService balanceService;
    private final SavingsService savingsService;

    public List<Transaction> findAll() {
        return transactionRepo.findAll();
    }

    public Optional<Transaction> findById(UUID id) {
        return transactionRepo.findById(id);
    }

    public Transaction save(Transaction save) {
        Balance balance = balanceService.getLastBalance();
        Double amount = 0d;
        if (balance != null) {
            amount = balance.getAmount();
        }
        switch (save.getType()) {
            case DEBIT -> {
                if (amount - save.getAmount() >= 0) {
                    balanceService.save(new Balance(amount - save.getAmount()));
                } else {
                    return null;
                }
            }
            case CREDIT -> {
                balanceService.save(new Balance(amount + save.getAmount()));
            }
            case SAVING -> {
                if (amount - save.getAmount() >= 0) {
                    balanceService.save(new Balance(amount - save.getAmount()));
                    Double oldSaving = savingsService.findAll().get(0).getValue();
                    savingsService.save(
                            savingsService
                                    .findByKid(save.getKid())
                                    .add(oldSaving + save.getAmount())
                    );
                }
            }
        }
        return transactionRepo.save(save);
    }

    public Optional<Transaction> delete(UUID id) {
        Optional<Transaction> toDelete = transactionRepo.findById(id);
        reverseTransaction(toDelete.get());
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
        for (Transaction element: toDelete){
            reverseTransaction(element);
        }
        return toDelete;
    }

    public Balance reverseTransaction(Transaction element){
        Double newBalance = balanceService.getLastBalance().getAmount();
        switch (element.getType()){
            case DEBIT -> {
                newBalance += element.getAmount();
            }
            case CREDIT -> {
                newBalance -= element.getAmount();
            }
            case SAVING -> {
                Double oldSaving = savingsService.findAll().get(0).getValue();
                newBalance += element.getAmount();
                savingsService.save(savingsService.findByKid(element.getKid())
                        .add(oldSaving - element.getAmount())
                );
            }
        }
        return balanceService.save(new Balance(newBalance));
    }
}
