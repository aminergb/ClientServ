package com.example.demo.modele;

public class Vote {
   private boolean IsUP = false;
   private long IdSondage;
   private long IdUser;
   private long IdFilm;
   private long IdVote;
   private static long IDVOTE=0;

    public Vote() {
    }

    public static Vote CreateVoteByUserAndSondage(boolean isUP, long idSondage, long idUser){
        IDVOTE++;
        return new  Vote(isUP, idSondage,idUser,IDVOTE);
    }
    public Vote(boolean isUP, long idSondage, long idUser , long idVote) {
        IsUP = isUP;
        IdSondage = idSondage;
        IdUser = idUser;
        IdVote = idVote;



    }

    public long getIdVote() {
        return IdVote;
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

    public static long getIDVOTE() {
        return IDVOTE;
    }

    public static void setIDVOTE(long IDVOTE) {
        Vote.IDVOTE = IDVOTE;
    }
}
