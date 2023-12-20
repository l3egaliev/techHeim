package kg.rakhim.classes.thechheim.controllers;

import kg.rakhim.classes.thechheim.security.UserDetailsImpl;
import kg.rakhim.classes.thechheim.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {


    @GetMapping
    public String homePage(Model model){

        return "public/index";
    }

    @GetMapping("/private")
    public String test(){
        return "private/private";
    }



}
