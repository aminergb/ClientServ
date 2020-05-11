import static java.lang.System.out;

public class ClientAppli {
    public static void main(String[] args) {
        SondageClientInter SondageProx = new SondageClient();

        UserDTO gerard = new UserDTO();
        gerard.setNom("mr");
        gerard.setPrenom("patatepeche");
        gerard.setPseudo("jakoir");
        gerard.setMdp("12345");
        SondageProx.createUserDTO(gerard);
        SondageDTO sondage1 = new SondageDTO();
        sondage1.setContenu("ce sondage qui ne sert a rien");
        sondage1.setIdFilmSondage(2);
        sondage1.setTitreSondage("ratataaataaa");
        SondageProx.createSondageDTO(sondage1);
        voteDTO vote1 = new voteDTO();
        vote1.setUP(true);
        vote1.setIdUser(gerard.getIdUser());
        SondageProx.createVoteDTO(3,vote1);
     out.println(vote1.getIdSondage());
     out.println(vote1.getIdUser());
    }

}
