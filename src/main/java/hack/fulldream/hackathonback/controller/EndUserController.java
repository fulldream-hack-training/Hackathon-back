package hack.fulldream.hackathonback.controller;

import hack.fulldream.hackathonback.models.EndUser;
import hack.fulldream.hackathonback.repository.EndUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EndUserController {
    private final EndUserRepository endUserRepo;

    @GetMapping("/user")
    public EndUser getSelf(Authentication authentication) {
        return endUserRepo.findByUsername(authentication.getName());
    }
}
