import java.io.Serializable;
import java.util.Map;

//Data transfere object
//on l'utilise pour : un objet class implements serializable
//l'interface permet de cacher en quelque sorte le deroulement du service (ex : macdo)
//rmi : que l'invocation des methodes et pas la modification de celle ci .
public class SondageDTO implements Serializable {
    private String TitreSondage;
    private String Contenu;
    private static long IDSONDAGEINC = 0;
    private long IdSondage;
    private long IdUserSondage;
    private long IdFilmSondage;
    private Map<Long , Vote> Votes;

    public void setVotes(Map<Long, Vote> votes) {
        Votes = votes;
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

    public static long getIDSONDAGEINC() {
        return IDSONDAGEINC;
    }

    public static void setIDSONDAGEINC(long IDSONDAGEINC) {
        SondageDTO.IDSONDAGEINC = IDSONDAGEINC;
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
}
