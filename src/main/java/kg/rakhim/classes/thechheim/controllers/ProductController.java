package kg.rakhim.classes.thechheim.controllers;

import kg.rakhim.classes.thechheim.dto.ProductDTO;
import kg.rakhim.classes.thechheim.entities.ProductCategory;
import kg.rakhim.classes.thechheim.entities.ProductEntity;
import kg.rakhim.classes.thechheim.security.UserDetailsImpl;
import kg.rakhim.classes.thechheim.services.ProductCategoryService;
import kg.rakhim.classes.thechheim.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductCategoryService categoryService;

    @GetMapping
    public String getAll(){
        return "products/product";
    }

    @GetMapping("/all")
    @ResponseBody
    public List<ProductDTO> all(){
        return productService.getAll();
    }

    @GetMapping("/{categoryName}")
    @ResponseBody
    public List<ProductDTO> getProduct(@PathVariable("categoryName")String category){
        return productService.getByCategory(category);
    }

}
