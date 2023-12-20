package kg.rakhim.classes.thechheim.services;

import kg.rakhim.classes.thechheim.entities.User;
import kg.rakhim.classes.thechheim.repository.UserRepository;
import kg.rakhim.classes.thechheim.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository repository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUsername(username);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }
        return new UserDetailsImpl(user.get());
    }
}
