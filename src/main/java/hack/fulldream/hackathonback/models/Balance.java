package hack.fulldream.hackathonback.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Balance {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "id")
    private UUID id;
    @Basic
    @Column(name = "amount")
    private Double amount;
    @Basic
    @Column(name = "date")
    @GeneratedValue
    private Date date;

    public Balance(Double amount) {
        this.amount = amount;
    }

    public Balance() {
    }
}
