package kg.rakhim.classes.thechheim.services;

import kg.rakhim.classes.thechheim.entities.ProductCategory;
import kg.rakhim.classes.thechheim.repository.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductCategoryService {
    private final ProductCategoryRepository repository;

    public List<ProductCategory> getAll(){
        return repository.findAll();
    }

    public Optional<ProductCategory> getByName(String category){
        return repository.findByName(category);
    }
}
