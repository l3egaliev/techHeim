package kg.rakhim.classes.thechheim.controllers;

import jakarta.servlet.http.HttpSession;
import kg.rakhim.classes.thechheim.dto.BlogDTO;
import kg.rakhim.classes.thechheim.entities.User;
import kg.rakhim.classes.thechheim.security.UserDetailsImpl;
import kg.rakhim.classes.thechheim.services.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/blogs")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;
    private final HttpSession session;


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



    @PostMapping("/{blog_id}/like")
    public String like(@PathVariable("blog_id") int id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = new User();
        Object principal = auth.getPrincipal();
        if(principal instanceof UserDetails) {
            UserDetailsImpl userDetails = (UserDetailsImpl) principal;
            user = userDetails.getUser();
        }
        if(user.getId() != null){
            Integer updatedLikes = blogService.like(id, user.getId());
            session.setAttribute("likes", updatedLikes);
            System.out.println(updatedLikes);
        }
        return "redirect:/blogs/"+id;
    }

    @GetMapping("/{id}")
    public String blogPage(@PathVariable("id") int id, Model model){
        model.addAttribute("blog", blogService.getOne(id));
        int count_comment = 0;
        BlogDTO dto = blogService.getOne(id);
        for (int i = 0;i<dto.getComments().size(); i++){
            count_comment ++;
        }
        Integer count_like = dto.getLikes();
        if (count_like == null){
            count_like = 0;
        }
        model.addAttribute("comment_count", count_comment);
        model.addAttribute("like_count", count_like);
        model.addAttribute("likes", session.getAttribute("likes"));
        return "blogs/blog";
    }
}
