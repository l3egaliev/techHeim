package kg.rakhim.classes.thechheim.controllers;

import jakarta.validation.Valid;
import kg.rakhim.classes.thechheim.dto.UserDTO;
import kg.rakhim.classes.thechheim.dto.UserDtoEmail;
import kg.rakhim.classes.thechheim.dto.UserDtoForPassword;
import kg.rakhim.classes.thechheim.dto.UserDtoUsername;
import kg.rakhim.classes.thechheim.entities.User;
import kg.rakhim.classes.thechheim.security.UserDetailsImpl;
import kg.rakhim.classes.thechheim.services.RegisterService;
import kg.rakhim.classes.thechheim.services.UserService;
import kg.rakhim.classes.thechheim.utils.Converter;
import kg.rakhim.classes.thechheim.utils.UserValidator;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserValidator validator;
    private final UserService service;
    private final RegisterService registerService;
    private Authentication auth;


    @GetMapping
    public String userInfo(Model model){
        if (getPrincipalObject() != null){
            model.addAttribute("user", getPrincipalObject());
        }else{
            System.out.println("Not working");
        }
        model.addAttribute("edit", new UserDtoUsername());
        model.addAttribute("email", new UserDtoEmail());
        model.addAttribute("password", new UserDtoForPassword());
        return "personal_data/personal-data";
    }





    @PostMapping("/edit/username")
    public String editUsername(@ModelAttribute("edit")@Valid UserDtoUsername user, BindingResult br){
        validator.validate(Converter.convert(user, User.class), br);
        if(br.hasErrors()){
            System.out.println("Error: "+br.getFieldError().getDefaultMessage());
            return "redirect:/user";
        }
        System.out.println("Saved");
        String oldUsername = getPrincipalObject().getUsername();
        String newUsername = user.getUsername();
        service.updateUsername(oldUsername, newUsername);
        setAuhUsername(newUsername);
        return "redirect:/user";
    }

    @PostMapping("/edit/email")
    public String editEmail(@ModelAttribute("email")@Valid UserDtoEmail email, BindingResult br){
        User user = (User) Converter.convert(email, User.class);
        validator.validate(user, br);
        if(br.hasErrors()){
            System.out.println("Error: "+br.getFieldError().getDefaultMessage());
            return "redirect:/user";
        }
        System.out.println("Saved");
        String oldEmail = getPrincipalObject().getEmail();
        String newEmail = user.getEmail();
        service.updateEmail(oldEmail, newEmail);
        setAuthEmail(newEmail);
        return "redirect:/user";
    }

    @PostMapping("/edit/password")
    public String changePassword(@ModelAttribute("password")@Valid UserDtoForPassword user, BindingResult bd){
        if(bd.hasErrors()){
            return "redirect:/user";
        }
        System.out.println("Saved");
        System.out.println(registerService.changePassword(getPrincipalObject(), user.getOldPassword(),
                user.getNewPassword()));
        setAuthPassword(user.getNewPassword());
        return "redirect:/user";
    }


    @DeleteMapping("/delete")
    public String deleteAccount(){
        registerService.delete(getPrincipalObject());
        SecurityContextHolder.clearContext();

        this.auth.setAuthenticated(false);
        return "redirect:/login";
    }

    private void setAuhUsername(String username){
        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
        userDetails.getUser().setUsername(username);
    }

    private void setAuthEmail(String email){
        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
        userDetails.getUser().setEmail(email);
    }

    private void setAuthPassword(String password){
        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
        userDetails.getUser().setPassword(password);
    }

    private User getPrincipalObject(){
        auth = SecurityContextHolder.getContext().getAuthentication();
        User result = new User();
        Object principal = auth.getPrincipal();
        if(principal instanceof UserDetails) {
            UserDetailsImpl userDetails = (UserDetailsImpl) principal;
            result = userDetails.getUser();
        }
        return result;
    }

    private void setAuth(Authentication auth){
        this.auth = auth;
    }

}
