import com.example.demo.modele.Vote;

import java.util.Map;

public class Sondage {
    private String TitreSondage;
    private String Contenu;
    private static long IDSONDAGEINC = 0;
   // private long IdSondage;
    private long IdUserSondage;
    private long IdFilmSondage;
    private  Map<Long, Vote> Votes;
    public   Map<Long, Vote> getVotes() { return Votes;
    }

    public Sondage() {
    }
    public static Sondage CreateSondage(String titreSondage, String contenu, long idUserSondage, long idFilmSondage, boolean isenabled){
       //IDSONDAGEINC++;
        return new Sondage(titreSondage,contenu, idUserSondage,idFilmSondage,isenabled);
    }
    public Sondage(String titreSondage, String contenu, long idUserSondage, long idFilmSondage, Boolean isEnabled) {
        TitreSondage = titreSondage;
        Contenu = contenu;
        //IdSondage = idSondage;
        IdUserSondage = idUserSondage;
        IdFilmSondage = idFilmSondage;

    }

    public String getTitreSondage() {
        return TitreSondage;
    }

    public String getContenu() {
        return Contenu;
    }



    public long getIdUserSondage() {
        return IdUserSondage;
    }

    public long getIdFilmSondage() {
        return IdFilmSondage;
    }



    public void setTitreSondage(String titreSondage) {
        TitreSondage = titreSondage;
    }

    public void setContenu(String contenu) {
        Contenu = contenu;
    }



    public void setIdUserSondage(long idUserSondage) {
        IdUserSondage = idUserSondage;
    }

    public void setIdFilmSondage(long idFilmSondage) {
        IdFilmSondage = idFilmSondage;
    }



    public static void setNbVoteDown(long nbVoteDown) {
        NbVoteDown = nbVoteDown;
    }

    private static long NbVoteDown=0;



    public static long getNbVoteDown() {
        return NbVoteDown;
    }

}
