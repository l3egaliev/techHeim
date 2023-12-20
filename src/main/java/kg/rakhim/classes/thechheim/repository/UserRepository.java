package kg.rakhim.classes.thechheim.repository;

import kg.rakhim.classes.thechheim.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String name);
    Optional<User> findByEmail(String email);
}
