package kg.rakhim.classes.thechheim.repository;

import kg.rakhim.classes.thechheim.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    Optional<ProductCategory> findByName(String name);
}
