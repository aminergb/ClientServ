public class User {
    private String Nom;
    private String Prenom;
    private String Mdp;
    private String Pseudo;
    private static long IdUserInc = 0;
    private long IdUser;

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public void setMdp(String mdp) {
        Mdp = mdp;
    }

    public void setPseudo(String pseudo) {
        Pseudo = pseudo;
    }

    public static void setIdUserInc(long idUserInc) {
        IdUserInc = idUserInc;
    }

    public void setIdUser(long idUser) {
        IdUser = idUser;
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

    public static long getIdUserInc() {
        return IdUserInc;
    }

    public long getIdUser() {
        return IdUser;
    }
}
