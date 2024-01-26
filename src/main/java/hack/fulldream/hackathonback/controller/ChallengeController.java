package hack.fulldream.hackathonback.controller;

import hack.fulldream.hackathonback.models.Challenge;
import hack.fulldream.hackathonback.models.Savings;
import hack.fulldream.hackathonback.service.ChallengeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/")
    public ResponseEntity<List<Challenge>> findAll(){
        List<Challenge> challenges = challengeService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(challenges);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Challenge> findById(@PathVariable UUID id){
        return challengeService.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Challenge> save(@RequestBody Challenge toSave){
        Challenge challenges = challengeService.save(toSave);
        return ResponseEntity.status(HttpStatus.OK).body(challenges);
    }
}
