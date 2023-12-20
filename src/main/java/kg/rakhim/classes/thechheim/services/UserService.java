package kg.rakhim.classes.thechheim.services;

import kg.rakhim.classes.thechheim.entities.User;
import kg.rakhim.classes.thechheim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<User> findByName(String username){
        return repository.findByUsername(username);
    }

    public Optional<User> findByEmail(String email) {return repository.findByEmail(email);}
}
