package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.Tip;
import hack.fulldream.hackathonback.repository.TipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TipService {
    private final TipRepository tipRepo;

    public Optional<Tip> findById(UUID id) {
        return tipRepo.findById(id);
    }

    public List<Tip> findAll() {
        return tipRepo.findAll();
    }

    public Tip save(Tip toSave) {
        return tipRepo.save(toSave);
    }

    public Optional<Tip> delete(UUID id) {
        Optional<Tip> toDelete = tipRepo.findById(id);
        if (toDelete.isPresent()) {
            tipRepo.deleteById(id);
        }
        return toDelete;
    }
}
