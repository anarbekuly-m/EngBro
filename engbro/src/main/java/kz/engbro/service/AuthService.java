package kz.engbro.service;

import kz.engbro.entity.enumuration.Language;
import kz.engbro.entity.enumuration.Level;
import kz.engbro.entity.model.User;
import kz.engbro.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User save(String username, String password) {

        User user = User.builder()
                .username(username)
                .password(new BCryptPasswordEncoder().encode(password))
                .level(Level.BEGINNER)
                .count(0L)
                .language(Language.ENGLISH)
                .build();
        return userRepository.save(user);
    }

    public User findById(String username) {
        return userRepository.findByUsername(username).get();
    }
}
