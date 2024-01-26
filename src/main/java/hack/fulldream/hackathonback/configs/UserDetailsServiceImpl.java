package hack.fulldream.hackathonback.configs;

import hack.fulldream.hackathonback.models.Tutor;
import hack.fulldream.hackathonback.repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final TutorRepository tutorRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Tutor tutor = tutorRepo.findByEmail(email);
        if (tutor == null) {
            throw new UsernameNotFoundException(email +" not found");
        }
        return new UserDetailsImpl(tutor);
    }
}
