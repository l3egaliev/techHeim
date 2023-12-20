package kg.rakhim.classes.thechheim.controllers;

import kg.rakhim.classes.thechheim.dto.UserDTO;
import kg.rakhim.classes.thechheim.entities.User;
import kg.rakhim.classes.thechheim.security.UserDetailsImpl;
import kg.rakhim.classes.thechheim.services.UserService;
import kg.rakhim.classes.thechheim.utils.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @GetMapping
    public String userInfo(Model model){
        if (getPrincipalObject() != null){
            System.out.println(getPrincipalObject().getUsername());
            model.addAttribute("user", getPrincipalObject());
        }else{
            System.out.println("Not working");
        }
        return "personal_data/personal-data";
    }

    private UserDTO getPrincipalObject(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User result = new User();
        Object principal = auth.getPrincipal();
        if(principal instanceof UserDetails) {
            UserDetailsImpl userDetails = (UserDetailsImpl) principal;
            result = userDetails.getUser();
            System.out.println(userDetails.getUser().getUsername());
        }
        return (UserDTO) Converter.convert(result, UserDTO.class);
    }


}
