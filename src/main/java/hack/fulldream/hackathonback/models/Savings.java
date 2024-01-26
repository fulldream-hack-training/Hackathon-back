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
public class Savings {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "id")
    private UUID id;
    @Basic
    @Column(name = "rate")
    private Double rate;
    @Basic
    @Column(name = "value")
    private Double value;
    @Basic
    @Column(name = "start_date")
    private Date startDate;

    @OneToOne
    @JoinColumn(name = "id_kid")
    Kid kid;

    public Savings add(Double newValue) {
        this.setValue(newValue);
        return this;
    }
}
