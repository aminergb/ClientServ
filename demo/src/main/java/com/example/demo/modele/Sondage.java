package com.example.demo.modele;

import com.example.demo.DTO.voteDTO;

import java.util.*;

public class Sondage {
    private String TitreSondage;
    private String Contenu;
    private long IdSondage;
    private long IdUserSondage;
    private long IdFilmSondage;
    private boolean IsEnabled;
    private static long IdSONDAGE=0;
    //TOUJOURS DECLARER ! CE MAUDIT MAP SINON POINTER EXCEPTION NULL AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAARRGHHH
     private List<Vote> Votes = new ArrayList<>();

    public void setVotes(List<Vote> votes) {
        Votes = votes;
    }

    public List<Vote> getVotes() {
        return Votes;
    }

    public Sondage() {
    }
public static Sondage CreateSondage(String titreSondage, String contenu,long idUserSondage, long idFilmSondage, boolean isenabled){
    IdSONDAGE++;
        return new Sondage(titreSondage,contenu, IdSONDAGE, idUserSondage,idFilmSondage,isenabled);
}
    public Sondage(String titreSondage, String contenu, long idSondage, long idUserSondage, long idFilmSondage, Boolean isEnabled) {
        TitreSondage = titreSondage;
        Contenu = contenu;
        IdSondage = idSondage;
        IdUserSondage = idUserSondage;
        IdFilmSondage = idFilmSondage;
        IsEnabled = isEnabled;

    }

    public boolean isEnabled() {
        return IsEnabled;
    }



    public String getTitreSondage() {
        return TitreSondage;
    }

    public String getContenu() {
        return Contenu;
    }

    public long getIdSondage() {
        return IdSondage;
    }

    public long getIdUserSondage() {
        return IdUserSondage;
    }

    public long getIdFilmSondage() {
        return IdFilmSondage;
    }











}
