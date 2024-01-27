package hack.fulldream.hackathonback.controller;

import hack.fulldream.hackathonback.models.Tip;
import hack.fulldream.hackathonback.service.TipService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/tip")
public class TipController {
    private final TipService tipService;

    public TipController(TipService tipService) {
        this.tipService = tipService;
    }

    @GetMapping("/{id}")
    public Optional<Tip> findById(@PathVariable UUID id){
        return tipService.findById(id);
    }

    @GetMapping("/tutor/{id_tutor}")
    public Tip findByIdTutor(@PathVariable UUID id_tutor){
        return tipService.findByIdTutor(id_tutor);
    }

    @PostMapping
    public Tip save(Tip toSave){
        return tipService.save(toSave);
    }
}
