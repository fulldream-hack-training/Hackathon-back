package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.repository.TutorRepository;
import org.springframework.stereotype.Service;

@Service
public class TutorService {
    private final TutorRepository userRepo;
    private final StorageService storageService;


    public TutorService(TutorRepository userRepo, StorageService storage, StorageService storageService) {
        this.userRepo = userRepo;
        this.storageService = storageService;
        storage.register("profiles");
    }
}
