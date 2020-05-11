package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
//interpretation des preauthorized
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //il existe deux methode de config  de l'authentification de l'user : avec configure et userdetailservice :
    //1ere solution en utilisant le userdetailsservice
  /*  @Override
    //comment mes utilisateurs sont authentifiés  et comment verifier leurs login et mdp
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //  in memory authentication permet de stocker la config des users sur la mémoire du serveur
        //pour un user ou utilisateur il faut :
        // Definir le nom ,password et role du user .
        // on peu encoder le password sur inMemoryAuthentication() en mettant le type d'encodage entre {} : exemple {noop} : sans encodage
        auth.inMemoryAuthentication().withUser("jakir").password("{noop}12345").roles("USER");
    }
*/
    //2eme solution : configuration de user detail service (pas de and() ici , on decoupe les configs par utilisateurs by creating a UserDetail per user , then give them name,pass,roles for each)
@Bean
    @Override
    protected UserDetailsService userDetailsService() {
     /*UserDetails jakir = User.builder().username("jakir").password("{noop}12345").roles("USER","ADMIN").build();
        UserDetails voldemort = User.builder().username("voldemort").password("{noop}12345").roles("USER").build();
        //ajouter les configs a la memoire
        return new InMemoryUserDetailsManager(jakir,voldemort);
*/
    return new CustomUserDetailService();}
// configuration de parti url avec http
    //présiscer sur http comment on veut configurer notre systeme

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //les conditions d'acces pour chaque url
        //antmatchers permettent le filtrage des url
        //antmatcher permet d'autoriser l'acces a la méthode GET sur l'url
        //permitall().anyrequest().authenticated() : permetde restraire l'access aux autres méthodes qui consernent l'url .
        //csrf().disable() : permet de desactiver la securité csrf : ne pas faire ça en réalité
        http.csrf().disable().authorizeRequests().
                antMatchers(HttpMethod.POST,"/Root/Users").
                hasRole("ADMIN").anyRequest().hasRole("USER").and().
                httpBasic().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
    //NE JAMAIS OUBLIER LES @BEANS !!!
@Bean
     BCryptPasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
     }
}
