package inaf.boris.controller;

import inaf.boris.Dto.ReponseUserDto;
import inaf.boris.Dto.RequestUserDto;
import inaf.boris.Entity.User;
import inaf.boris.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;
import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name = "utilisateur", description = "point entrer controleur de gestion des utilisateurs")
public class UserController {
    private final UserService Service;
    public UserController(UserService service) {
        Service = service;
    }

    // CREATE

    @PostMapping
    @Operation(summary = "creation d'un utilisateur", description = "but est enregistrer un utilisateur quelconque et de retourner un resultat et le code de retour c'est 200")
    public ReponseUserDto createUser(@RequestBody RequestUserDto dto) {

        return Service. createUser(dto);
    }

    // READ ALL

    @GetMapping
    public List<ReponseUserDto> afficherTous() {
        return Service.getUser();
    }


    @GetMapping("/{id}")
    public ReponseUserDto afficherBYId(@PathVariable("id") Long id) {
        return Service.getUserById(id);
    }
    @PutMapping("/{id}")
    public ReponseUserDto updateUser(@PathVariable("id") Long id, @RequestBody RequestUserDto dto){
        return Service.updateUser(id,dto);
    }


    @DeleteMapping("/{id}")
    public void supprimerUser(@PathVariable("id") Long id){
        Service.deleteUser(id);
    }



}
