package kg.rakhim.classes.thechheim.services;

import kg.rakhim.classes.thechheim.entities.User;
import kg.rakhim.classes.thechheim.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegisterService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;


    @Transactional
    public void register(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
    }
}
