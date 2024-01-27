package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.Savings;
import hack.fulldream.hackathonback.models.Tip;
import hack.fulldream.hackathonback.repository.SavingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SavingService {
    private final SavingRepository savingRepository;

    public SavingService(SavingRepository savingRepository) {
        this.savingRepository = savingRepository;
    }

    public Optional<Savings> findById(UUID id){
        return savingRepository.findById(id);
    }

    public Savings findByIdKid(UUID id_kid){
        List<Savings> result = savingRepository.findAll()
                .stream()
                .filter(e -> e.getKid().getId().equals(id_kid))
                .toList();
        if (result.isEmpty()){
            return null;
        }
        return result.get(0);
    }

    public Savings save(Savings toSave){
        return savingRepository.save(toSave);
    }
}
