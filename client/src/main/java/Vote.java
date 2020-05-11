public class Vote {
   private boolean IsUP;
   private long IdSondage;
   private long IdUser;
   private long IdFilm;
   private long IdVote;
   private static long IDVOTE=0;

    public long getIdVote() {
        return IdVote;
    }

    public Vote() {
    }
    public static Vote CreateVote(boolean isUP, long idSondage, long idUser,long idvote){
        IDVOTE++;
        return new Vote(isUP, idSondage,idUser,IDVOTE);
    }
    public Vote(boolean isUP, long idSondage, long idUser,long idvote) {
        IsUP = isUP;
        IdSondage = idSondage;
        IdUser = idUser;
        IdVote= idvote;

    }

    public boolean getisUP() {
        return IsUP;
    }

    public void setisUP(boolean UP) {
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

    public static long getIDVOTE() {
        return IDVOTE;
    }

    public static void setIDVOTE(long IDVOTE) {
        Vote.IDVOTE = IDVOTE;
    }
}
