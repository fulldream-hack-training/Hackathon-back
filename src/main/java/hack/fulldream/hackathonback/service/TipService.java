package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.Tip;
import hack.fulldream.hackathonback.repository.TipRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TipService {
    private final TipRepository tipRepository;

    public TipService(TipRepository tipRepository) {
        this.tipRepository = tipRepository;
    }

    public Optional<Tip> findById(UUID id){
        return tipRepository.findById(id);
    }

    public Tip findByIdTutor(UUID id_tutor){
        List<Tip> result = tipRepository.findAll()
                .stream()
                .filter(e -> e.getTutor().getId().equals(id_tutor))
                .toList();
        if (result.isEmpty()){
            return null;
        }
        return result.get(0);
    }

    public Tip save(Tip toSave){
        return tipRepository.save(toSave);
    }
}
