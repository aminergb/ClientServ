package com.example.demo.DTO;



import com.example.demo.modele.Film;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public class FilmDTO implements Serializable {
    private String Titre;
    private String Realisateur;
    private String Resume;
    private Collection<String> Acteurs;
    private Date DateSortie;
    private long IdFilm;
    private long IdUserFilm;

    private FilmDTO(Film film) {
        this.Titre = film.getTitre();
        this.Acteurs = film.getActeurs();
        this.IdFilm = film.getIdFilm();
        this.DateSortie = film.getDateSortie();
        this.Realisateur = film.getRealisateur();
        this.Resume = film.getResume();
        this.IdUserFilm = film.getIdUserFilm();
    }

    public static FilmDTO createFilmDTO(Film film) {
        return new FilmDTO(film);
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

    public void setIdFilm(long idFilm) {
        IdFilm = idFilm;
    }

    public void setIdUserFilm(long idUserFilm) {
        IdUserFilm = idUserFilm;
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

    public long getIdFilm() {
        return IdFilm;
    }

    public long getIdUserFilm() {
        return IdUserFilm;
    }
}
