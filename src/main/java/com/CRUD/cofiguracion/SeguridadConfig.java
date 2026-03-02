package com.CRUD.cofiguracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.CRUD.servicio.UsuarioServicio;

@Configuration
@EnableMethodSecurity
public class SeguridadConfig {

    /*private final UsuarioServicio usuarioServicio;

    public SeguridadConfig(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }*/

    // Bean para codificar contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Bean para manejar autenticación
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    // Configuración de seguridad HTTP
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(auth -> auth
                // Rutas públicas
                .requestMatchers("/", "/login", "/css/**", "/js/**").permitAll()
                .requestMatchers("/clases/**").hasRole("ADMIN") // Clases, solo para que entre Admin.
                .anyRequest().authenticated()// El resto: autenticado
            )
            .formLogin(form -> form
                .loginPage("/login")     
                .defaultSuccessUrl("/clases", true)
                .permitAll()
            )
            .logout(logout -> logout.permitAll());

        return http.build();
    }
}
