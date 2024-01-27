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

    public Optional<Challenge> findById(UUID id){
        return challengeRepository.findById(id);
    }

    public List<Challenge> findAllByIdTutor(UUID id_tutor){
        return challengeRepository.findAll()
                .stream()
                .filter(e -> e.getTutor().getId().equals(id_tutor))
                .toList();
    }

    public Challenge save(Challenge toSave){
        return challengeRepository.save(toSave);
    }
}
