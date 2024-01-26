package hack.fulldream.hackathonback.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Kid {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "id")
    private UUID id;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "points")
    private Integer points;

    @OneToOne
    @JoinColumn(name = "id_kid")
    Savings savings;

    @OneToMany
    @JoinColumn(name = "id_kid")
    List<Transaction> transactions;

    @OneToMany
    @JoinColumn(name = "id_kid")
    List<Balance> balance;
}
