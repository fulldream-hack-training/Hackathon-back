package hack.fulldream.hackathonback.controller;

import hack.fulldream.hackathonback.models.Tip;
import hack.fulldream.hackathonback.service.TipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tip")
public class TipController {
    private final TipService tipService;

    @GetMapping("/{id}")
    public ResponseEntity<Tip> getById(@PathVariable UUID id) {
        return tipService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Tip> findAll() {
        return tipService.findAll();
    }

    @PutMapping
    public Tip save(@RequestBody Tip tip) {
        return tipService.save(tip);
    }
}
