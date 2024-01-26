package hack.fulldream.hackathonback.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.lang.annotation.Target;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tutor")
@Getter
@Setter
public class EndUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private String username;
    @Column
    private String email;
}
