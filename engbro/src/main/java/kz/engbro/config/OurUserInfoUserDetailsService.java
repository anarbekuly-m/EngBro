package kz.engbro.config;

import kz.engbro.entity.model.User;
import kz.engbro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@Configuration
public class OurUserInfoUserDetailsService implements UserDetailsService {
    private  UserRepository userRepository;
    @Autowired
    public OurUserInfoUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public OurUserInfoUserDetailsService() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(OurUserInfoDetails::new).orElseThrow(() -> new UsernameNotFoundException("not found!"));
                                                                                                                                                                                                                                                            }
}
