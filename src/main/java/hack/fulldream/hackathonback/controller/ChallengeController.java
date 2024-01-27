package hack.fulldream.hackathonback.controller;

import hack.fulldream.hackathonback.models.Challenge;
import hack.fulldream.hackathonback.service.ChallengeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/challenge")
public class ChallengeController {
    private final ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping("/{id}")
    public Optional<Challenge> findById(@PathVariable UUID id){
        return challengeService.findById(id);
    }

    @GetMapping("/tutor/{id_tutor}")
    public List<Challenge> findAllByIdTutor(@PathVariable UUID id_tutor){
        return challengeService.findAllByIdTutor(id_tutor);
    }

    @PostMapping
    public Challenge save(Challenge toSave){
        return challengeService.save(toSave);
    }
}
