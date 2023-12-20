package kg.rakhim.classes.thechheim.utils;

import kg.rakhim.classes.thechheim.entities.User;
import kg.rakhim.classes.thechheim.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {
    private final UserService service;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(User.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if(service.findByName(user.getUsername()).isPresent()){
            errors.rejectValue("username", "", "Такой пользователь уже зарегистрирован!");
        }
        if(service.findByEmail(user.getEmail()).isPresent()){
            errors.rejectValue("email", "", "Такой email уже зарегистрирован!");
        }
    }


}
