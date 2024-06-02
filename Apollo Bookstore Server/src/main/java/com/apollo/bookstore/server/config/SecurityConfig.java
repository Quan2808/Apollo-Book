package com.apollo.bookstore.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.apollo.bookstore.server.initializer.UserDetailsServiceInitializer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceInitializer();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    SecurityFilterChain configureAdminSecurity(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll())
//                        .requestMatchers("/user/**")
//                        .hasAnyAuthority("administrator"))

                .formLogin(login -> login
                        .loginPage("/user/login")
                        .defaultSuccessUrl("/user", true)
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .permitAll())
                .exceptionHandling(eh -> eh.accessDeniedPage("/403"));

        return http.build();
    }

//    @Bean
//    SecurityFilterChain configureCustomerSecurity(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth -> auth
////                        .requestMatchers("/**").hasAnyAuthority("customer")
//                        .anyRequest().permitAll())
//                .formLogin(login -> login
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/user", true)
//                        .permitAll())
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/")
//                        .permitAll())
//                .exceptionHandling(eh -> eh.accessDeniedPage("/403"));
//
//        return http.build();
//    }
//
//    @Bean
//    SecurityFilterChain configureDeliverySecurity(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/delivery/**")
//                        .hasAnyAuthority("delivery"))
//                .formLogin(login -> login
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/user", true)
//                        .permitAll())
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/")
//                        .permitAll())
//                .exceptionHandling(eh -> eh.accessDeniedPage("/403"));
//
//        return http.build();
//    }
}
