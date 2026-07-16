package com.smartfisherman.smartfishermansystem.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
public class SecurityConfig {


    private final JwtAuthFilter jwtAuthFilter;


    public SecurityConfig(JwtAuthFilter jwtAuthFilter) {

        this.jwtAuthFilter = jwtAuthFilter;

    }



    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }



    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {


        http

            // Disable CSRF kwa REST API
            .csrf(csrf -> csrf.disable())


            // JWT inatumia stateless session
            .sessionManagement(session ->
                session.sessionCreationPolicy(
                    SessionCreationPolicy.STATELESS
                )
            )


            .authorizeHttpRequests(auth -> auth


                // endpoints ambazo hazihitaji token
                .requestMatchers(
                    "/api/users/register",
                    "/api/users/login",

                    "/api/weather/**",

                    "/api/fishing/**",

                    "/api/market/**",

                    "/api/sos/**"

                ).permitAll()


                // endpoints zingine zote zinahitaji JWT token
                .anyRequest().authenticated()


            )


            // JWT Filter
            .addFilterBefore(
                jwtAuthFilter,
                UsernamePasswordAuthenticationFilter.class
            );



        return http.build();

    }

}