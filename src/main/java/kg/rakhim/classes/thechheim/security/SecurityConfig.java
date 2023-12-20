package kg.rakhim.classes.thechheim.security;

import kg.rakhim.classes.thechheim.services.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final AuthProviderImpl authProvider;
    private final UserDetailsServiceImpl userDetailsService;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/error").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/auth/registration").permitAll()
                        .requestMatchers("/registration").permitAll()
                        .requestMatchers("/products/**").permitAll()
                        .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/js/**").permitAll()
                        .requestMatchers("/images/**").permitAll()
                        .requestMatchers("/webjars/**").permitAll()
                        .anyRequest().authenticated())
                .formLogin(form -> form.loginPage("/login")
                        .loginProcessingUrl("/process_url")
                        .defaultSuccessUrl("/home", true)
                        .failureUrl("/login?error"))
                .logout(logoutConfig -> logoutConfig
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login"))
                .authenticationManager(authenticationManagerBean(http))
                .build();
    }


    @Bean
    public AuthenticationManager authenticationManagerBean(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder
                .authenticationProvider(authProvider)
                .userDetailsService(userDetailsService);
        return authenticationManagerBuilder.build();
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
