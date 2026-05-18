package com.example.AuthApplicationBackend.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfigure {

    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        httpSecurity
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth->
                                auth
                                        .requestMatchers("").permitAll()
                                        .anyRequest().authenticated())
                .formLogin(form->form.permitAll());

        return httpSecurity.build();
    }

}
