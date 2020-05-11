package com.example.demo.config;

import com.example.demo.exeptions.InexistantException;
import com.example.demo.modele.ClassApi;
import com.example.demo.modele.InterfApi;
import com.example.demo.modele.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CustomUserDetailService implements UserDetailsService {

    //Autowired permet de chercher un bean partout sur le projet
    @Autowired
            //celui ci permet d'encoder le mdp;
            //on peut trouver une methode qui gére cela dans la class securityconfig avec @bean passwordEncoder
    BCryptPasswordEncoder passwordEncoder;
    private static  InterfApi SondageAPI = new ClassApi();

    private static final String[] ROLE_TYPE_USER = {"USER"};
    private static final String[] ROLE_TYPE_ADMIN = {"USER","ADMIN"};
    @Override
    //s: prend le login de l'utilisateur
    //chercher le login en bdd , si trouvé alors creer le userdetail correspondant afin de lui autoriser certains accées !
    //renvoyer le userdetail de l'utilisateur
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

            User user = SondageAPI.getUserByName(s);
         if(user==null) {

            throw new UsernameNotFoundException("User "+s+" NOT FOUND");
        }
        String[] roles = user.isAdmin() ? ROLE_TYPE_ADMIN : ROLE_TYPE_USER;

       UserDetails userdetail = org.springframework.security.core.userdetails.User.builder().username(user.getPseudo()).password(passwordEncoder.encode(user.getMdp())).roles(roles).build();
   return userdetail; }
}
