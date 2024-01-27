package hack.fulldream.hackathonback.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Entity
@Setter
@Getter
public class Savings {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private Double rate;

    @Column
    private Double value;

    @Column(updatable = false, name = "start_date")
    @GeneratedValue
    private Date startDate;

    @OneToOne
    @JoinColumn(name = "id_kid")
    private Kid kid;
}
