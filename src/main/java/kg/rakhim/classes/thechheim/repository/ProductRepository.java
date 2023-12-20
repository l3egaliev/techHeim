package kg.rakhim.classes.thechheim.repository;

import kg.rakhim.classes.thechheim.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findByCategoryName(String category);
}
