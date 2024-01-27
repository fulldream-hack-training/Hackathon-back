package hack.fulldream.hackathonback.controller;

import hack.fulldream.hackathonback.models.EndTutor;
import hack.fulldream.hackathonback.models.Tutor;
import hack.fulldream.hackathonback.service.EndTutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tutor")
public class EndTutorController {
    private final EndTutorService endTutorService;

    @GetMapping("/self")
    public EndTutor getSelf(Authentication authentication) {
        return endTutorService.findByEmail(authentication.getName());
    }

    @GetMapping("/available")
    public EndTutor getAvailability(@RequestParam String email) {
        return endTutorService.findByEmail(email);
    }

    @DeleteMapping
    public ResponseEntity<EndTutor> delete(Authentication authentication) {
        return endTutorService
                .delete(
                        endTutorService.findByEmail(
                                authentication.getName()
                        ).getId()
                )
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
