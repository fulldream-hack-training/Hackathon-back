package hack.fulldream.hackathonback.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "tutor")
public class Tutor {
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

    @Basic
    @Column(name = "password")
    String password;

}
