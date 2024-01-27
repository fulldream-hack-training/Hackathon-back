package hack.fulldream.hackathonback.controller;

import hack.fulldream.hackathonback.service.BalanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/balance")
public class BalanceController {
    public final BalanceService balanceService;

    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping
    public Double getLastAmountOnBalance(UUID id){
        return balanceService.getLastBalance(id);
    }
}
