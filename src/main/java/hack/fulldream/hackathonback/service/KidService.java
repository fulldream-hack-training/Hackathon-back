package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.Kid;
import hack.fulldream.hackathonback.repository.KidRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KidService {
    public KidRepository kidRepository;

    public KidService(KidRepository kidRepository) {
        this.kidRepository = kidRepository;
    }

    public Optional<Kid> findById(UUID id){
        Optional<Kid> kid = kidRepository.findById(id);
        return Optional.ofNullable(kid.orElse(null));
    }

    public List<Kid> findByKidName(String firstName){
        List<Kid> listKid= kidRepository.findByFirstName(firstName);
        return listKid;
    }

    public Kid save(Kid kid){
        Kid kidToSave = kidRepository.save(kid);
        return kidToSave;
    }



    public void deleteKid(UUID id){
        kidRepository.findById(id);
        kidRepository.deleteKidById(id);
    }
}
