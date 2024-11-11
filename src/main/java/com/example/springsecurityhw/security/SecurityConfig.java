package com.example.springsecurityhw.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(source ->
                {
                    Map<String, Object> claims = source.getClaim("realm_access");
                    List<String> roles = (List<String>) claims.get("roles");

                    return roles.stream()
                            .map(SimpleGrantedAuthority::new)
                            .collect(Collectors.toList());

                }
        );

        return http
                .authorizeHttpRequests(rights -> rights
                        .requestMatchers("/api/user/**").hasAnyAuthority("user", "admin")
                        .requestMatchers("/api/admin/**").hasAuthority("admin")
                        .anyRequest().permitAll()
                )
                .formLogin(Customizer.withDefaults())
                .oauth2ResourceServer(config -> config
                        .jwt(configurer -> configurer
                                .jwtAuthenticationConverter(converter))
                )
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}