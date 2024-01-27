package hack.fulldream.hackathonback.controller;

import hack.fulldream.hackathonback.models.Tutor;
import hack.fulldream.hackathonback.service.TutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tutor")
@RequiredArgsConstructor
public class TutorController {
    private final TutorService tutorService;

    @PostMapping("/signup")
    public Tutor signup(@RequestBody Tutor tutor) {
        return tutorService.save(tutor);
    }
}
