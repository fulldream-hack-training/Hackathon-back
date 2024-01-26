package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.Challenge;
import hack.fulldream.hackathonback.repository.ChallengeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChallengeService {
    private final ChallengeRepository challengeRepository;

    public ChallengeService(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

    public List<Challenge> findAll(){
        return challengeRepository.findAll();
    }

    public Challenge save(Challenge toSave){
        return challengeRepository.save(toSave);
    }

    public Optional<Challenge> findById(UUID id){
        return challengeRepository.findById(id);
    }
}
