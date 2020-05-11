

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDTO implements Serializable {
    //private  Date timestamp;
    private String Nom;
    private String Prenom;
    private String Mdp;
    private String Pseudo;
    private long IdUser;

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
       /* SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        this.timestamp = */
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
