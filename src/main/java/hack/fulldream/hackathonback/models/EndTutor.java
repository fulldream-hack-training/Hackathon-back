package hack.fulldream.hackathonback.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "tutor")
@Getter
@Setter
public class EndTutor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    UUID id;
    @Basic
    @Column(name = "first_name")
    String firstName;
    @Basic
    @Column(name = "last_name")
    String lastName;
    @Basic
    @Column(name = "email")
    String email;
}
