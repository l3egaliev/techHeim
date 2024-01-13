package kg.rakhim.classes.thechheim.repository;

import kg.rakhim.classes.thechheim.entities.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Integer> {
}
