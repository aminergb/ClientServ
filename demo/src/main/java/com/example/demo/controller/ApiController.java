package com.example.demo.controller;

import com.example.demo.DTO.FilmDTO;
import com.example.demo.DTO.SondageDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.DTO.voteDTO;
import com.example.demo.exeptions.InexistantException;
import com.example.demo.modele.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.security.Principal;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.out;

@RestController
@RequestMapping("/Root")
public class ApiController {

    AtomicLong randId= new AtomicLong(1L);

    //pk faire interface = new class ???? c'est quoi l'interet ?
    private static final InterfApi SondageAPI = new ClassApi();

    @GetMapping(value = "/Users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    //@PreAuthorize("#id==authentication.principal.username")
    //@PathVariable("id") : l'arguement doit etre similaire a /{} de la value getmapping sinon template mismatch
    public ResponseEntity<UserDTO> getUserDTOById(@PathVariable("id") long id) {
        try {
            User user = SondageAPI.getUserById(id);
            return ResponseEntity.ok(UserDTO.createUserDTO(user));

        } catch (InexistantException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


    }


    @GetMapping(value = "/Users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<UserDTO>> getUsersDTO() {

        Collection<User> users = SondageAPI.getUsers();

        return ResponseEntity.ok(users.stream().map(UserDTO::createUserDTO).collect(Collectors.toList()));
    }
    @GetMapping(value = "/Sondages", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<SondageDTO>> getSondagesDTO() {
        Collection<Sondage> sondages = SondageAPI.getSondages();
        //on accede aux objets de la hashmap sondage  via "e" et on crée un dto serializable par createSondageDTO(e) tel que "e" est un objet de class Sondage  puis on l'envoi en serializable vers le client !!!
        return ResponseEntity.ok(sondages.stream().map(SondageDTO::createSondageDTO).collect(Collectors.toList()));
    }

    @PostMapping(value = "/Users", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> createUserDTO(@RequestBody UserDTO userDTO) {
        long resultat = SondageAPI.addUser(userDTO.getNom(), userDTO.getPrenom(), userDTO.getMdp(), userDTO.getPseudo());
        if(resultat==-1){
            return ResponseEntity.badRequest().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(resultat).toUri();
        return ResponseEntity.created(location).build();

    }

    @GetMapping(value = "/Films/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FilmDTO> getFilmDTOByID(@PathVariable("id") long id) {
        try {
            Film film = SondageAPI.getFilmById(id);
            return ResponseEntity.ok(FilmDTO.createFilmDTO(film));

        } catch (InexistantException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


    }
    @GetMapping(value = "/Sondages/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    //@PathVariable("id") : l'arguement doit etre similaire a /{} de la value getmapping sinon template mismatch
    public ResponseEntity<SondageDTO> getSondageDTOById(@PathVariable("id") long id) {
        try {
            Sondage sondage = SondageAPI.getSondageById(id);
            return ResponseEntity.ok(SondageDTO.createSondageDTO(sondage));

        } catch (InexistantException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


    }
    @GetMapping(value = "/Sondages/{ids}/Votes/{idv}", produces = MediaType.APPLICATION_JSON_VALUE)
    //one vote per user :

    //@PathVariable("id") : l'arguement doit etre similaire a /{} de la value getmapping sinon template mismatch
    public ResponseEntity<voteDTO> getVotesDTOById(@PathVariable long ids,@PathVariable long idv) {
        try {
            Vote v = SondageAPI.getVoteById(idv,ids);

           voteDTO vdto=  voteDTO.createVoteDTO(v);
            out.println("!!!!!!!!!!!!!!!"+vdto.getIdVote());
            return ResponseEntity.ok(vdto);

        } catch (InexistantException e) {
            out.println("????");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


    }
    @PostMapping(value = "/Films", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> createFilmDTO(@RequestBody FilmDTO filmDTO) {
        //on recupere l'objet DTO et on le converti en objet film :
        long resultat = SondageAPI.addFilm(filmDTO.getTitre(), filmDTO.getRealisateur(), filmDTO.getResume(), filmDTO.getActeurs(), filmDTO.getDateSortie(), filmDTO.getIdUserFilm());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(resultat).toUri();
        return ResponseEntity.created(location).build();

    }
    @GetMapping(value = "/Films", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<FilmDTO>> getFilmsDTO() {
        Collection<Film> films = SondageAPI.getFilms();
 //on accede aux objets de la hashmap films  via "e" et on crée un dto serializable par createFilmsDTO(e) et e=objet film
        return ResponseEntity.ok(films.stream().map(FilmDTO::createFilmDTO).collect(Collectors.toList()));
    }

    //probleme avec acteurs doit on cree une classe acteurs ?
    //@PostMapping(value = "Users/{id}/Sondages/", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PostMapping(value = "/Sondages", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> createSondageDTO( @RequestBody SondageDTO sondageDTO) {
        long resultat = SondageAPI.addSondageByUser(sondageDTO.getTitreSondage(), sondageDTO.getContenu(), sondageDTO.getIdSondage(), sondageDTO.getIdUserSondage(),sondageDTO.getIdFilmSondage(),sondageDTO.isEnabled());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(resultat).toUri();
        return ResponseEntity.created(location).build();

    }

    //dans le poste , on recupére le serializable en DTO(psk le dto a seulement les getter et les setter comme methodes pour acceder/modifier les données)
    //@RequestHeader("id") long idsondage
    @PostMapping(value = "/Sondages/{id}/Votes", consumes = {MediaType.APPLICATION_JSON_VALUE})

    public ResponseEntity<String> createVotesDTO(@RequestBody  voteDTO vote , @PathVariable long id) {

        //creation d'un objet vote en utilisant le requestbody :
        //
        long idvote = SondageAPI.addVoteByUserAndSondage(vote.isUP(),id,vote.getIdUser());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(idvote).toUri();
        out.println("ça marche "+id+"  "+idvote);
        return ResponseEntity.created(location).build();




    }
    //le probléme au soit dans le get ou le post
    @GetMapping(value ="/Sondages/{id}/Votes", produces = MediaType.APPLICATION_JSON_VALUE)
    //probleme avec le path variable !!!
    public ResponseEntity<Collection<voteDTO>> getVotesBySondage(@PathVariable("id") long idsondage) {
        try {
            Sondage sondage = SondageAPI.getSondageById(idsondage);

            return ResponseEntity.ok(sondage.getVotes().stream().map(e -> voteDTO.createVoteDTO(e)).collect(Collectors.toList()));

        } catch (InexistantException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


    }


}
