package com.apollo.bookstore.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.apollo.bookstore.services.impls.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public UserDetailsService userDetailsService() {
    return new UserDetailsServiceImpl();
  }

  @Bean
  public static PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    AuthenticationManagerBuilder authenticationManagerBuilder = http
        .getSharedObject(AuthenticationManagerBuilder.class);

    authenticationManagerBuilder
        .userDetailsService(userDetailsService())
        .passwordEncoder(passwordEncoder());

    AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

    http
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(author -> author
            .requestMatchers("/dashboard/**").hasAuthority("administrator")
            .anyRequest().permitAll())
        .formLogin(login -> login.loginPage("/login.html")
            .loginProcessingUrl("/do-login")
            .defaultSuccessUrl("/index", true)
            .permitAll())
        .authenticationManager(authenticationManager);

    return http.build();

    // .authorizeHttpRequests(auth -> auth
    // .requestMatchers("/dashboard/**").hasAuthority("administrator")
    // .anyRequest().permitAll());
    // .userDetailsService(userDetailsService)
    // .csrf(csrf -> csrf.disable());
    // .httpBasic();

  }

}
