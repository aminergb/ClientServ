package com.example.demo.modele;


import com.example.demo.exeptions.InexistantException;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.Null;
import java.security.Principal;
import java.util.*;
import java.util.function.Predicate;

import static java.lang.System.out;

public class ClassApi implements InterfApi {

    private static Map<Long, User> Users = new HashMap<>();
    private static Map<Long, Sondage> Sondages = new HashMap<>();
    private static Map<Long, Vote> VotesByIdSondage = new HashMap<>();
    private static Map<Long, Vote> VotesByIdUsers = new HashMap<>();
    private static Map<Long, Film> Films = new HashMap<>();



 static{
     User jakir= User.createUser("jakir", "jakir", "jakir", "jakir");
     User admin= User.createUser("admin", "admin", "admin", "admin");
     jakir.setAdmin(false);
     admin.setAdmin(true);
     Users.put(jakir.getIdUser(),jakir);
     Users.put(admin.getIdUser(),admin);
 }

    @Override
    //permet d'ajouter un utilisateur dans le map Users
    public long addUser(String nom, String prenom, String mdp, String pseudo) {
        Predicate<String>  isok = s ->!(s==null) && (s.length()>=3);
        //createUser() doit etre static
        if(!isok.test(pseudo) && !isok.test(mdp)){
            out.println("wooooohhoow");
            ResponseEntity.badRequest().build();
            return -1;
        }
        //verifier l'existance du user avec containskey ?

        User user = User.createUser(nom, prenom, mdp, pseudo);

        Users.put(user.getIdUser(), user);
        return user.getIdUser();
    }

    @Override
    //trouve l'objet enseignant sur le map USERS puis examine si l'objet créé est vide
    public User getUserById(long iduser) throws InexistantException {
        User user = Users.get(iduser);
        if (Objects.isNull(user)) {
            throw new InexistantException();
        }
        return user;
    }

    @Override
    public User getUserByName(String nameuser) {
     for(User entry : Users.values()){
         if(entry.getPseudo().equals(nameuser)){
             return entry;
         }else{
             out.println("il ne l'a pas trouvéééé"+ entry.getPseudo() +" == "+ nameuser);
         }
     }


        return null;
    }

    @Override
    public void deleteUser(long iduser) {

    }

    @Override
    public long addFilm(String titre, String realisateur, String resume, Collection<String> acteurs, Date dateSortie, long iduserfilm) {
        Film film = Film.createFilm(titre, realisateur, resume, acteurs, dateSortie, iduserfilm);
        Films.put(film.getIdFilm(), film);
        return film.getIdFilm();
    }

    @Override
    public Film getFilmById(long idfilm) throws InexistantException {
        Film film = Films.get(idfilm);
        if (Objects.isNull(film)) {
            throw new InexistantException();
        }
        return film;
    }

    @Override
    public Film setFilm(long idfilm) {
        return null;
    }

    @Override
    public Collection<User> getUsers() {

     //make a difference between an admin and a user : if it's an admin , every info will be showen , if it's  a user  , only the names will be shown !
        return Users.values();
    }

    @Override
    public Collection<Film> getFilms() {
        return Films.values();
    }

    @Override
    public Collection<Sondage> getSondages() {
        return Sondages.values();
    }

    @Override
    public long addSondageByUser(String titreSondage, String contenu, long idSondage, long idUserSondage, long idFilmSondage, boolean isenabled) {

        Sondage sondage = Sondage.CreateSondage(titreSondage,contenu,idUserSondage,idFilmSondage,isenabled);
        Sondages.put(sondage.getIdSondage(),sondage);
        //return idUserSondage;
        return sondage.getIdSondage();
    }

    @Override
    public long addVoteByUserAndSondage(boolean isUP, long idSondage, long idUser) {

        Vote vote= Vote.CreateVoteByUserAndSondage(isUP,idSondage,idUser);
        //make a loop to verifiy if the vote already exists !
        // ici j'ajoute le vote a la liste
        Sondages.get(idSondage).getVotes().add(vote);
        /* //erreur ici reference pointer is null : resolved !
        //affaire a suivre
        Map<Long,Vote> votes ;
        Sondage sondage = Sondages.get(idSondage);
        try{ Sondages.get(idSondage);
        } catch (Exception e) {
            e.printStackTrace();

        }
        votes =  sondage.getVotes();
        //sa retourne la valeur vote acienne , qui est null
        try{
           votes.put(vote.getIdUser(),vote);
            votes.put(vote.getIdUser(),vote);
            votes.put(vote.getIdUser(),vote);
            votes.put(vote.getIdUser(),vote);
            if(votes.isEmpty()){
                out.println("vide");
            }else{
                out.println(votes.values().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
*/

        //System.out.println(votes.put(vote.getIdUser(),vote).getIdUser());
        //sondage.setVotes(votes);
        //Sondages.replace(idSondage,sondage);
        //System.out.println(votes.values().toString()); */

        //VotesByIdSondage.put(idSondage,vote);
        //VotesByIdUsers.put(idUser,vote);
        //return vote.getIDVOTE();
        return vote.getIdUser();

    }

    @Override
    public Sondage getSondageById(long idsondage) throws InexistantException {
        Sondage sondage = Sondages.get(idsondage);
        if(Objects.isNull(sondage)){
            throw new InexistantException();
        }
        return sondage;
    }



    @Override
    public Vote getVoteById(long idvote,long idsondage) {
        List<Vote> vote =Sondages.get(idsondage).getVotes();
        for (Vote e : vote){
            if(idvote==e.getIdVote()){
                return e;
            }
        }
        return null;
    }

    @Override
    public void deleteFilm(long idfilm) {

    }
}
