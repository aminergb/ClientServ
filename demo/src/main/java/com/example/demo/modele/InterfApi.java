package com.example.demo.modele;


import com.example.demo.exeptions.InexistantException;

import java.security.Principal;
import java.util.Collection;
import java.util.Date;

public interface InterfApi {
    //ajoutuser
    long addUser(String nom, String prenom, String mdp, String pseudo);

    //getuser
    User getUserById(long iduser) throws InexistantException;
    User getUserByName(String nameuser) ;

    //supprimer user
    void deleteUser(long iduser);

    //ajoutfilm
    long addFilm(String titre, String realisateur, String resume, Collection<String> acteurs, Date dateSortie, long iduserfilm);

    //getfilm
    Film getFilmById(long idfilm) throws InexistantException;

    //setfilm
    Film setFilm(long idfilm);

    //supprimerfilm
    void deleteFilm(long idfilm);

    //ajoutsondage
    //modifiersondage
    //supprimersondage
    public Collection<User> getUsers();
    public Collection<Film> getFilms();
    public Collection<Sondage> getSondages();
    long addSondageByUser(String titreSondage, String contenu, long idSondage, long idUserSondage, long idFilmSondage, boolean isenabled);
    long addVoteByUserAndSondage(boolean isUP, long idSondage, long idUser);
    //get sondage
    Sondage getSondageById(long idsondage) throws InexistantException;

    public Vote getVoteById(long idvote,long idsondage) throws InexistantException;
}
