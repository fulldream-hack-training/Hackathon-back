package hack.fulldream.hackathonback.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private Double amount;

    @Column
    private String label;

    @Column
    @GeneratedValue
    private Timestamp date;

    @Column
    private String type;

    @ManyToOne
    @JoinColumn(name = "id_kid")
    private Kid kid;
}
