package hack.fulldream.hackathonback.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String title;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "finished_value")
    private Integer finishedValue;

    @Column(name = "unfinished_value")
    private Integer unfinishedValue;

    @ManyToOne
    @JoinColumn(name = "id_tutor")
    private Tutor tutor;
}
