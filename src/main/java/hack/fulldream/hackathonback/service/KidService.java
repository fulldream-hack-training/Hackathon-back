package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.Kid;
import hack.fulldream.hackathonback.repository.KidRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KidService {
    public final KidRepository kidRepository;

    public KidService(KidRepository kidRepository) {
        this.kidRepository = kidRepository;
    }

    public Optional<Kid> findById(UUID id){
        Optional<Kid> kid = kidRepository.findById(id);
        return kid;
    }


    public Kid save(Kid kid){
        Kid toSave = kidRepository.save(kid);
        return toSave;
    }

    public Optional<Kid> delete(UUID id) {
        Optional<Kid> toFind = kidRepository.findById(id);
        if (toFind.isPresent()) {
            kidRepository.deleteById(id);
        }
        return toFind;
    }
}
