package mx.com.gm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    //Autorización
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                // Permitir acceso a login y recursos estáticos
                .requestMatchers("/login", "/resources/**").permitAll()
                //Restricción de acceso por rol
                .requestMatchers("/editar/**", "/agregar/**", "/eliminar/**").hasRole("ADMIN")
                //Acceso a usuarios autenticados
                .requestMatchers("/").hasAnyRole("USER", "ADMIN")
                //Cualquier otra solicitud requiere autenticación
                .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                .loginPage("/login")//Página de login personalizada
                .defaultSuccessUrl("/", true) //Redirigir después del login exitoso
                .permitAll()
                )
                .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                )
                .exceptionHandling(exceptionHandling -> exceptionHandling
                .accessDeniedPage("/errores/403")
                );
        return http.build();
    }
    //Autenticación
    
    
     //   Autenticación
     //   La autenticación lo realizamos mediante la base de datos con el rol
    

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

}
