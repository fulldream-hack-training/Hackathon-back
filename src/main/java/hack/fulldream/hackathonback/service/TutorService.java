package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.Tutor;
import hack.fulldream.hackathonback.repository.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TutorService {
    private final TutorRepository tutorRepo;
    private final StorageService storageService;
    private final PasswordService passwordService;

    public TutorService(TutorRepository userRepo, StorageService storage, StorageService storageService, PasswordService passwordService) {
        this.tutorRepo = userRepo;
        this.storageService = storageService;
        this.passwordService = passwordService;
        storage.register("profiles");
    }

    public Tutor save(Tutor toSave) {
        toSave.setPassword(passwordService.encode(toSave.getPassword()));
        return tutorRepo.save(toSave);
    }

    public Optional<Tutor> delete(UUID toDelete) {
        Optional<Tutor> toDeleteTutor = tutorRepo.findById(toDelete);
        if (toDeleteTutor.isPresent()) {
            tutorRepo.deleteById(toDelete);
        }
        return toDeleteTutor;
    }

    public List<Tutor> findAll() {
        return tutorRepo.findAll();
    }

    public Optional<Tutor> findById(UUID id) {
        return tutorRepo.findById(id);
    }

}
