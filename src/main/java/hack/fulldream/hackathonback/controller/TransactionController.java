package hack.fulldream.hackathonback.controller;

import hack.fulldream.hackathonback.models.Transaction;
import hack.fulldream.hackathonback.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Transaction> getByID(@PathVariable UUID id) {
        return transactionService.delete(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{kidId}")
    public List<Transaction> getTransaction(@PathVariable UUID kidId) {
        return transactionService.findByKidId(kidId);
    }

    @PutMapping
    public Transaction addTransaction(Transaction transaction) {
        return transactionService.save(transaction);
    }

}
