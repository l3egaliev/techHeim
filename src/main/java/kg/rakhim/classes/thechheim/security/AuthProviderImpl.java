package kg.rakhim.classes.thechheim.security;

import kg.rakhim.classes.thechheim.entities.User;
import kg.rakhim.classes.thechheim.services.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class AuthProviderImpl implements AuthenticationProvider {
    private final UserDetailsServiceImpl service;



    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String username = auth.getName();
        UserDetails userDetails = service.loadUserByUsername(username);
        String password = auth.getCredentials().toString();
        if(!userDetails.getPassword().equals(password)){
            throw new BadCredentialsException("Username or password incorrect");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(User.class);
    }
}
