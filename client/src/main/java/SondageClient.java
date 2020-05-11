
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
//ça n'existe pas sur le java 8
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.lang.System.out;

public class SondageClient implements SondageClientInter {

    private static final String URI_SERVICE = "http://localhost:8080/Root";

    private static final String Users = "/Users";
    private static final String Films ="/Films";
    //remarque : ici chaque sondage doit etre propre a l'utilisateur
    private static final String Sondages ="/Sondages";
    //remarque : chaque vote doit etre propre au sondages
    private static final String Votes ="/Votes";


    private HttpClient httpClient = HttpClient.newHttpClient();
    // ?
    public ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public int createUserDTO(UserDTO user) {
         //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String body = null;
        try {
            body = objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        HttpRequest requete = HttpRequest.newBuilder()
                .uri(URI.create(URI_SERVICE + Users))
                .setHeader("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        try {
            HttpResponse<String> response = this.httpClient.send(requete, HttpResponse.BodyHandlers.ofString());
//wtf is this ?
           // String location = response.headers().firstValue("Location").get();

            //return location.lastIndexOf("/");
            return 0;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return -1;

    }


    @Override
    public UserDTO getUserById(int id) {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URI_SERVICE + Users + "/" + id))
                .setHeader("Accept", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());


            return this.objectMapper.readValue(response.body(), this.objectMapper.getTypeFactory().constructType(UserDTO.class));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
    public int createFilmDTO(FilmDTO film){
        //creation du body
        String body= null;
        //faire un try catch
        try{
            body = objectMapper.writeValueAsString(film);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //creation de la requete :
        //1) l'URI
        // 2) Le header : content type avec post | accept avec get
        // 3)la requete : post ou get
        // 4) puis  build
        HttpRequest requestFilm  = HttpRequest.newBuilder()
                .uri(URI.create(URI_SERVICE + Films))
                .setHeader("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
        try {
            //envoi de la requete  , est ce qu'on peut seulement faire this.httpClient.send(request, HttpResponse.BodyHandlers.ofString()); ????
            HttpResponse<String> response = this.httpClient.send(requestFilm, HttpResponse.BodyHandlers.ofString());
            return 0;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return 0;
    }
    public int createSondageDTO(SondageDTO sondage) {
        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String body = null;
        try {
            body = objectMapper.writeValueAsString(sondage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        HttpRequest requestSondage = HttpRequest.newBuilder()
                .uri(URI.create(URI_SERVICE + Sondages))
                .setHeader("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        try {
            HttpResponse<String> response = this.httpClient.send(requestSondage, HttpResponse.BodyHandlers.ofString());
//wtf is this ?
            // String location = response.headers().firstValue("Location").get();

            //return location.lastIndexOf("/");
            return 0;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return -1;

    }


    public int createVoteDTO(long idSondage,voteDTO vote) {

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String body = null;
        try {
            body = objectMapper.writeValueAsString(vote);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        HttpRequest requete = HttpRequest.newBuilder().setHeader("Content-Type", "application/json").uri(URI.create(URI_SERVICE+Sondages+"/"+idSondage+Votes)).POST(HttpRequest.BodyPublishers.ofString(body)).build();

        try {
            this.httpClient.send(requete, HttpResponse.BodyHandlers.ofString());


            out.println(" post envoyé ");
            return 0;
        } catch (IOException | InterruptedException e) {
            out.println("post non envoyé");
            e.printStackTrace();
        }

        return 0;

    }


}
