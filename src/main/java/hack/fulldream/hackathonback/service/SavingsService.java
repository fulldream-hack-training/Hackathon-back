package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.Balance;
import hack.fulldream.hackathonback.models.Kid;
import hack.fulldream.hackathonback.models.Savings;
import hack.fulldream.hackathonback.repository.SavingsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SavingsService {
    private final SavingsRepository savingsRepository;

    public SavingsService(SavingsRepository savingsRepository) {
        this.savingsRepository = savingsRepository;
    }

    public List<Savings> findAll(){
        return savingsRepository.findAll();
    }

    public Optional<Savings> findById(UUID id){
        return savingsRepository.findById(id);
    }

    public Savings findByKid(Kid kid) {
        return savingsRepository.findSavingsByKid(kid);
    }

    public Savings save(Savings toSave){
        return savingsRepository.save(toSave);
    }
}
