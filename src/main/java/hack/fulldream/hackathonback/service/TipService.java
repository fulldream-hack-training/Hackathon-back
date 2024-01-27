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
    private final TipRepository tipRepository;

    public List<Tip> getByTutorId(UUID idTutor) {
        return tipRepository.findByTutorId(idTutor);
    }

    public Tip save(Tip tip) {
        return tipRepository.save(tip);
    }

    public Optional<Tip> delete(UUID id) {
        Optional<Tip> toDelete = tipRepository.findById(id);
        toDelete.ifPresent(value -> tipRepository.deleteById(value.getId()));
        return toDelete;
    }
}
