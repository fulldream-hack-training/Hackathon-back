package hack.fulldream.hackathonback.controller;

import hack.fulldream.hackathonback.models.Savings;
import hack.fulldream.hackathonback.service.SavingsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/saving")
public class SavingController {
    private final SavingsService savingsService;

    public SavingController(SavingsService savingsService) {
        this.savingsService = savingsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Savings> findById(@PathVariable UUID id){
        return savingsService.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Savings> save(Savings toSave){
        Savings savings = savingsService.save(toSave);
        return ResponseEntity.status(HttpStatus.OK).body(savings);
    }
}
