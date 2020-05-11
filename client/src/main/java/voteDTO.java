import java.io.Serializable;

public class voteDTO implements Serializable {
    private boolean IsUP;
    private long IdSondage;
    private long IdUser;
    private long IdFilm;
    private long IdVote;

    public voteDTO() {
    }

    public voteDTO(Vote vote) {
        IsUP = vote.getisUP();
        IdSondage = vote.getIdSondage();
        IdUser = vote.getIdUser();
        IdFilm = vote.getIdFilm();
        IdVote=  vote.getIdVote();
    }
 public static voteDTO createVoteDTO(Vote vote) {
        return new voteDTO(vote);

    }

    public boolean isUP() {
        return IsUP;
    }

    public void setUP(boolean UP) {
        IsUP = UP;
    }

    public long getIdSondage() {
        return IdSondage;
    }

    public void setIdSondage(long idSondage) {
        IdSondage = idSondage;
    }

    public long getIdUser() {
        return IdUser;
    }

    public void setIdUser(long idUser) {
        IdUser = idUser;
    }

    public long getIdFilm() {
        return IdFilm;
    }

    public void setIdFilm(long idFilm) {
        IdFilm = idFilm;
    }
}

