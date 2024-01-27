package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.Balance;
import hack.fulldream.hackathonback.models.Kid;
import hack.fulldream.hackathonback.repository.BalanceRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BalanceService {
    public BalanceService(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    public final BalanceRepository balanceRepository;

    public Optional<Balance> findByid(UUID id){
        Optional<Balance> toFind = balanceRepository.findById(id);
        return toFind;
    }

    public Balance save(Balance balance){
        Balance toSave = balanceRepository.save(balance);
        return toSave;
    }

    public Optional<Balance> delete(UUID id){
        Optional<Balance> toFind = balanceRepository.findById(id);
        if (toFind.isPresent()){
            balanceRepository.deleteById(id);
        }
        return toFind;
    }

    public Double getLastBalance(UUID id){
        List<Balance> balance = balanceRepository.findAll(Sort.sort(Date.class).descending());

        if (!balance.isEmpty()){
            return balance.get(0).getAmount();
        }

        return 0D;
    }
}
