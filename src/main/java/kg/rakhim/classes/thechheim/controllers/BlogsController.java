package kg.rakhim.classes.thechheim.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blogs")
public class BlogsController {
    @GetMapping
    public String blogsMain(){
        return "blogs/blogs";
    }
}
