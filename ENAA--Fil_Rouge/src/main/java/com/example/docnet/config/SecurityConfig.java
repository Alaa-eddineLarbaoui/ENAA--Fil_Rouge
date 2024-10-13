package com.example.docnet.config;

import com.example.docnet.enums.Erole;
import com.example.docnet.repositories.PersoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {


    @Autowired
    private PersoneRepository personeRepository;


    @Bean
    UserDetailsService userDetailsService() {
        return personeRepository::findByUsername;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println("filtercjain///////////");

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(expressionInterceptUrlRegistry ->
                                expressionInterceptUrlRegistry
                                        .requestMatchers("/api/auth/signup").permitAll()
                                        .requestMatchers("/api/auth/login").permitAll()
                                        .requestMatchers("/swagger-ui/**").permitAll()
                                        .requestMatchers("v3/api-docs/**").permitAll()
                                        .requestMatchers("/api/availabilities/**").permitAll()
                                        .requestMatchers("/api/availabilities/available-times").permitAll()
                                        .requestMatchers("/api/health-professionals/**").permitAll()


                                        .anyRequest().authenticated()
                                //  .anyRequest().permitAll()


                );

        http.cors(Customizer.withDefaults());
        http.addFilterBefore(new JwtAuthorizationFilter(userDetailsService()), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        System.out.println("///////////athhmanager");
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }
}