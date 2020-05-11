package com.example.demo.modele;

public class User {
    private String Nom;
    private String Prenom;
    private String Mdp;
    private String Pseudo;
    private static long IdUserInc = 0;
    private long IdUser;
    private boolean isAdmin;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public User() {
    }

    public User(String nom, String prenom, String mdp, String pseudo, long idUser) {
        Nom = nom;
        Prenom = prenom;
        Mdp = mdp;
        Pseudo = pseudo;
        IdUser = idUser;
    }

    public static User createUser(String nom, String prenom, String mdp, String pseudo) {
        IdUserInc++;
        return new User(nom, prenom, mdp, pseudo, IdUserInc);
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
}
