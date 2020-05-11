

public interface SondageClientInter {

    int createUserDTO(UserDTO user);

    UserDTO getUserById(int id);
    int createSondageDTO(SondageDTO sondage);
     int createVoteDTO(long idSondage,voteDTO vote);

}
