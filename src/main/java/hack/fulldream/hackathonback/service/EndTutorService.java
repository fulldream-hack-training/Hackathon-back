package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.EndTutor;
import hack.fulldream.hackathonback.repository.EndTutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EndTutorService {
    private final EndTutorRepository endTutorRepo;

    public Optional<EndTutor> findById(UUID id) {
        return endTutorRepo.findById(id);
    }

    public List<EndTutor> findAll() {
        return endTutorRepo.findAll();
    }

    public EndTutor findByEmail(String email) {
        return endTutorRepo.findByEmail(email);
    }

    public Optional<EndTutor> delete(UUID id) {
        Optional<EndTutor> toDelete = endTutorRepo.findById(id);
        toDelete.ifPresent(endTutor -> endTutorRepo.deleteById(endTutor.getId()));
        return toDelete;
    }
}
