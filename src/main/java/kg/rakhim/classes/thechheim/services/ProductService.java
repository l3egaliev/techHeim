package kg.rakhim.classes.thechheim.services;

import kg.rakhim.classes.thechheim.dto.ProductDTO;
import kg.rakhim.classes.thechheim.entities.ProductEntity;
import kg.rakhim.classes.thechheim.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductCategoryService categoryService;
    private final ModelMapper mapper;

    public List<ProductDTO> getAll(){
        List<ProductEntity> productEntities = productRepository.findAll();
        List<ProductDTO> response = new ArrayList<>();
        productEntities.forEach(entity -> {
            ProductDTO dto = convertToDto(entity);
            dto.setCategory(entity.getCategory().getName());
            response.add(dto);
        });
        return response;
    }

    public List<ProductDTO> getByCategory(String category){
        if(categoryService.getByName(category).isPresent()){
            List<ProductEntity> entities = productRepository.findByCategoryName(category);
            for(ProductEntity entity: entities){
                return new ArrayList<>(Collections.singletonList(convertToDto(entity)));
            }
        }
        return Collections.emptyList();
    }

    private ProductDTO convertToDto(ProductEntity entity){
        return mapper.map(entity, ProductDTO.class);
    }
}
