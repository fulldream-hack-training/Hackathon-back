package hack.fulldream.hackathonback.controller;

import hack.fulldream.hackathonback.models.Savings;
import hack.fulldream.hackathonback.service.SavingService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/saving")
public class SavingController {
    private final SavingService savingService;

    public SavingController(SavingService savingService) {
        this.savingService = savingService;
    }

    @GetMapping("/{id}")
    public Optional<Savings> findById(@PathVariable UUID id){
        return savingService.findById(id);
    }

    @GetMapping("/kid/{id_kid}")
    public Savings findByIdKid(@PathVariable UUID id_kid){
        return savingService.findByIdKid(id_kid);
    }

    @PostMapping
    public Savings save(Savings toSave){
        return savingService.save(toSave);
    }
}
