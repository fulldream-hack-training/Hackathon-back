package hack.fulldream.hackathonback.controller;

import hack.fulldream.hackathonback.models.Balance;
import hack.fulldream.hackathonback.service.BalanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/balance")
public class BalanceController {
    public final BalanceService balanceService;

    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping("/lastBalance")
    public ResponseEntity<List<Balance>> getLastBalance() {
        List<Balance> balances = balanceService.getLastBalance();
        return ResponseEntity.ok(balances);
    }
}
