package hack.fulldream.hackathonback.controller;

import hack.fulldream.hackathonback.models.EndTutor;
import hack.fulldream.hackathonback.service.EndTutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tutor")
public class EndTutorController {
    EndTutorService endTutorService;

    @GetMapping("/self")
    public EndTutor getSelf(Authentication authentication) {
        return endTutorService.findByEmail(authentication.getName());
    }

    @GetMapping("/tutors")
    public List<EndTutor> getAll() {
        return endTutorService.findAll();
    }
}
