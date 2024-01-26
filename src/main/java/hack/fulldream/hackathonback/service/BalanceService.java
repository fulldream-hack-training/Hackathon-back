package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.Balance;
import hack.fulldream.hackathonback.repository.BalanceRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BalanceService {
    public BalanceRepository balanceRepository;

    public BalanceService(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }
    public Optional<Balance> findById(UUID id){
        Optional<Balance> balance = balanceRepository.findById(id);
        return balance;
    }

    public List<Balance> findAll(UUID id){
        List<Balance> balance = balanceRepository.findAll();
        return balance;
    }

    public Balance save(Balance balance){
        Balance toSave = balanceRepository.save(balance);
        return toSave;
    }

    public void delete(UUID id){
        balanceRepository.deleteById(id);
    }

    public List<Balance> getLastBalance(){
        List<Balance> balanceList = balanceRepository.findAll(Sort.sort(Timestamp.class).descending());
        return balanceList;
    }

}
