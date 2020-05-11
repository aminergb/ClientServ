package com.example.demo.DTO;



import com.example.demo.modele.User;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private String Nom;
    private String Prenom;
    private String Mdp;
    private String Pseudo;
    private long IdUser;
    private boolean isAdmin;

    public boolean isAdmin() {
        return isAdmin;
    }

    public UserDTO() {

    }

    public static UserDTO createUserDTO(User user) {
        return new UserDTO(user);
    }

    public UserDTO(User user) {
        this.Nom = user.getNom();
        this.Prenom = user.getPrenom();
        this.Pseudo = user.getPseudo();
        this.IdUser = user.getIdUser();
        this.Mdp = user.getMdp();
        this.isAdmin= user.isAdmin();
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getMdp() {
        return Mdp;
    }

    public String getPseudo() {
        return Pseudo;
    }

    public long getIdUser() {
        return IdUser;
    }

    public void setNom(String nom) {
        this.Nom = nom;
    }

    public void setPrenom(String prenom) {
        this.Prenom = prenom;
    }

    public void setMdp(String mdp) {
        this.Mdp = mdp;
    }

    public void setPseudo(String pseudo) {
        this.Pseudo = pseudo;
    }

    public void setIdUser(int idUser) {
        this.IdUser = idUser;
    }
}
