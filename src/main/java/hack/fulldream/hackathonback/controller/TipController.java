package hack.fulldream.hackathonback.controller;

import hack.fulldream.hackathonback.models.Tip;
import hack.fulldream.hackathonback.service.EndTutorService;
import hack.fulldream.hackathonback.service.TipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class TipController {
    private final TipService tipService;
    private final EndTutorService endTutorService;
    @GetMapping
    public List<Tip> get(Authentication authentication) {
        UUID tutorId = endTutorService.findByEmail(authentication.getName()).getId();
        return tipService.getByTutorId(tutorId);
    }

    @PutMapping
    public Tip put(Tip tip) {
        return tipService.save(tip);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tip> delete(@PathVariable UUID id) {
        return tipService.delete(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
