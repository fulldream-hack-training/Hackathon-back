package hack.fulldream.hackathonback.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private Double amount;

    @Column
    @GeneratedValue
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "id_kid")
    private Kid kid;
}
