package hack.fulldream.hackathonback.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode
@Setter
@Getter
@Entity
public class Transaction {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "id")
    private UUID id;
    @Basic
    @Column(name = "amount")
    private Double amount;
    @Basic
    @Column(name = "label")
    private String label;
    @Basic
    @Column(name = "date")
    private Timestamp date;
    @Basic
    @Column(name = "type")
    private String type;
}
