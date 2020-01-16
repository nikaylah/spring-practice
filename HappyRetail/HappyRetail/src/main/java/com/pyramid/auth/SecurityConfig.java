package com.pyramid.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    EndUserService eus;
    private final PasswordEncoder pwEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Bean
    UserDetailsService authentication() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        for (EndUser u : eus.getUserDetails()){
            manager.createUser(
                    User.builder()
                        .username(u.getUsername())
                        .password(pwEncoder.encode(u.getPassword()))
                        .roles(u.getRole())
                        .build()
            );
        }
        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests().mvcMatchers("/admin/**").hasRole("ADMIN")
            .and()
            .formLogin()
            .and()
            .httpBasic();
    }
}
