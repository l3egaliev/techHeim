package kg.rakhim.classes.thechheim.controllers;

import kg.rakhim.classes.thechheim.dto.BlogDTO;
import kg.rakhim.classes.thechheim.entities.BlogEntity;
import kg.rakhim.classes.thechheim.services.BlogService;
import kg.rakhim.classes.thechheim.utils.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/blogs")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping
    public String blogsMain(){
        return "blogs/blogs";
    }

    @ResponseBody
    @GetMapping("/all")
    public List<BlogDTO> allBlogs(){
        return blogService.getAll();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public BlogDTO getBlog(@PathVariable("id")int id){
        return blogService.getOne(id);
    }

}
