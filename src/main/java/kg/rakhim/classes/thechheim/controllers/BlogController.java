package kg.rakhim.classes.thechheim.controllers;

import kg.rakhim.classes.thechheim.dto.BlogDTO;
import kg.rakhim.classes.thechheim.services.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/blogs")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;


    @GetMapping()
    public String allBlogs(Model model){
        model.addAttribute("blogs", blogService.getAll());
        return "blogs/blogs";
    }

//    @GetMapping("/{id}")
//    @ResponseBody
//    public BlogDTO getBlog(@PathVariable("id")int id){
//        return blogService.getOne(id);
//    }

    @GetMapping("/{id}")
    public String blogPage(@PathVariable("id") int id, Model model){
        model.addAttribute("blog", blogService.getOne(id));
        return "blogs/blog";
    }

}
