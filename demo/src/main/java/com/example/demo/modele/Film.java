package com.example.demo.modele;

import java.util.Collection;
import java.util.Date;

public class Film {
    private String Titre;
    private String Realisateur;
    private String Resume;
    private Collection<String> Acteurs;
    private Date DateSortie;
    private static long IDFILMINC = 0;
    private long IdFilm;
    private long IdUserFilm;


    public Film() {
    }

    public Film(String titre, String realisateur, String resume, Collection<String> acteurs, Date dateSortie, long idfilm, long iduserfilm) {
        Titre = titre;
        Realisateur = realisateur;
        Resume = resume;
        Acteurs = acteurs;
        DateSortie = dateSortie;
        IdFilm = idfilm;
        IdUserFilm = iduserfilm;
    }

    public static Film createFilm(String titre, String realisateur, String resume, Collection<String> acteurs, Date dateSortie, long iduserfilm) {
        IDFILMINC++;
        return new Film(titre, realisateur, resume, acteurs, dateSortie, IDFILMINC, iduserfilm);
    }

    public long getIdUserFilm() {
        return IdUserFilm;
    }

    public long getIdFilm() {
        return IdFilm;
    }

    public String getTitre() {
        return Titre;
    }

    public String getRealisateur() {
        return Realisateur;
    }

    public String getResume() {
        return Resume;
    }

    public Collection<String> getActeurs() {
        return Acteurs;
    }

    public Date getDateSortie() {
        return DateSortie;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public void setRealisateur(String realisateur) {
        Realisateur = realisateur;
    }

    public void setResume(String resume) {
        Resume = resume;
    }

    public void setActeurs(Collection<String> acteurs) {
        Acteurs = acteurs;
    }

    public void setDateSortie(Date dateSortie) {
        DateSortie = dateSortie;
    }
}

