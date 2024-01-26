package hack.fulldream.hackathonback.controller;


import hack.fulldream.hackathonback.models.Tutor;
import hack.fulldream.hackathonback.repository.TutorRepository;
import hack.fulldream.hackathonback.service.PasswordService;
import hack.fulldream.hackathonback.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final TutorRepository userRepo;
    private final PasswordService passwordService;
    private final StorageService storageService;

    @PostMapping("/signup")
    public Tutor signup(@RequestBody Tutor tutor) {
        tutor.setPassword(passwordService.encode(tutor.getPassword()));
        return userRepo.save(tutor);
    }
}
