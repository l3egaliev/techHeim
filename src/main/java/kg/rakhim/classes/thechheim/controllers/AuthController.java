package kg.rakhim.classes.thechheim.controllers;

import jakarta.validation.Valid;
import kg.rakhim.classes.thechheim.dto.UserDTO;
import kg.rakhim.classes.thechheim.dto.UserDTOForRegister;
import kg.rakhim.classes.thechheim.entities.User;
import kg.rakhim.classes.thechheim.exceptions.RegisterException;
import kg.rakhim.classes.thechheim.security.UserDetailsImpl;
import kg.rakhim.classes.thechheim.services.RegisterService;
import kg.rakhim.classes.thechheim.services.UserDetailsServiceImpl;
import kg.rakhim.classes.thechheim.services.UserService;
import kg.rakhim.classes.thechheim.utils.UserValidator;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring6.context.SpringContextUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final RegisterService service;
    private final UserValidator validator;
    private final UserDetailsServiceImpl detailsService;
    private final ModelMapper mapper;
    private final AuthenticationManager authenticationManager;
    private Authentication authentication;

    @GetMapping("/userInfo")
    @ResponseBody
    public User getUserInfo(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User result = new User();
        Object principal = auth.getPrincipal();
        if(principal instanceof UserDetails) {
            UserDetailsImpl userDetails = (UserDetailsImpl) principal;
            result = userDetails.getUser();
        }
        return result;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "public/index";
    }

    @GetMapping("/auth/registration")
    public String registerPage(@ModelAttribute("user")UserDTOForRegister user){
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String register(@ModelAttribute("user") @Valid UserDTOForRegister dto, BindingResult br){
        User user = mapper.map(dto, User.class);
        validator.validate(user, br);
        if(br.hasErrors()){
            return "auth/registration";
        }
        service.register(user);

        return "redirect:/home";

    }


}
