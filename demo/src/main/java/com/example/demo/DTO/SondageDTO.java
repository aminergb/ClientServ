package com.example.demo.DTO;

import com.example.demo.modele.Sondage;
import com.example.demo.modele.Vote;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

//Data transfere object
//on l'utilise pour : un objet class implements serializable
//l'interface permet de cacher en quelque sorte le deroulement du service (ex : macdo)
//rmi : que l'invocation des methodes et pas la modification de celle ci .
public class SondageDTO implements Serializable {
    private String TitreSondage;
    private String Contenu;
    private ObjectMapper obmap;
    private long IdSondage;
    private long IdUserSondage;
    private long IdFilmSondage;
    private boolean IsEnabled;
    private String Votes;

    public SondageDTO() {
    }

    public String getVotes() {
        return Votes;
    }

    public SondageDTO(Sondage sondage) {

        TitreSondage = sondage.getTitreSondage();
        Contenu = sondage.getContenu();
        IdSondage = sondage.getIdSondage();
        IdUserSondage = sondage.getIdUserSondage();
        IdFilmSondage = sondage.getIdFilmSondage();
        IsEnabled = sondage.isEnabled();

       // Votes = sondage.getVotes().values().toString();

    }

    public static SondageDTO createSondageDTO(Sondage sondage) {
     return new SondageDTO(sondage);
    }

    public String getTitreSondage() {
        return TitreSondage;
    }

    public void setTitreSondage(String titreSondage) {
        TitreSondage = titreSondage;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String contenu) {
        Contenu = contenu;
    }



    public long getIdSondage() {
        return IdSondage;
    }

    public void setIdSondage(long idSondage) {
        IdSondage = idSondage;
    }

    public long getIdUserSondage() {
        return IdUserSondage;
    }

    public void setIdUserSondage(long idUserSondage) {
        IdUserSondage = idUserSondage;
    }

    public long getIdFilmSondage() {
        return IdFilmSondage;
    }

    public void setIdFilmSondage(long idFilmSondage) {
        IdFilmSondage = idFilmSondage;
    }

    public boolean isEnabled() {
        return IsEnabled;
    }

    public void setEnabled(boolean enabled) {
        IsEnabled = enabled;
    }




}
