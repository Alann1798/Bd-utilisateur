package alann.spr.Controller;
import alann.spr.Dto.ReponseDtoUser;
import alann.spr.Dto.RequestDtoUser;
import alann.spr.Entity.User;
import alann.spr.Exeption.CreateException;
import alann.spr.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/user")

@Tag(name = "Utilisateur", description = "point d'entre pour gere les operations ajourté, modufication, lecture, recherche en fonction de son identifient et la suppression d'un utilisateur en ce referent sur son identifient")
public class UserController {
    @Autowired
    private UserService service;

    public UserController(UserService service){
        this.service =service;
    }

    //creer
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "ajourt d'un utilisateur, un role, une entreprise", description = "cette fonction permet d'ajourte un utilisateur, un role, une entreprise dans notre systeme en utilisant en entre un dto pour retourte une reponse claire et lissible  l'utilisateur")
    public ReponseDtoUser createUser(@RequestBody RequestDtoUser dto){
        return service.createUser(dto);
    }

    //liste tous

    @GetMapping
    public List<ReponseDtoUser> getUser(){
        return service.getAll();
    }
    //liste pas id
    @GetMapping("/{id}")
    public ReponseDtoUser getUser(@PathVariable Long id){
        return service.getById(id);
    }

    //modifier
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "modifier d'un utilisateur", description = "cette fonction permet de modifier un utilisateur dans notre systeme en utilisant en entre un dto pour retourte une reponse claire et lissible  l'utilisateur")
    public ReponseDtoUser updateUser(@PathVariable long id, @RequestBody RequestDtoUser dto){
        return service.update(id, dto);

    }

    //supprimer
    @DeleteMapping("/{id}")
    @Operation(summary = "suppression d'un utilisateur", description = "cette fonction permet de supprimer un utilisateur dans notre systeme en utilisant en entre un dto pour retourte une reponse claire et lissible  l'utilisateur")
    public void deleteUser (@PathVariable long id){
        service.delete(id);
    }

    //exception
    @GetMapping("/users")
    public Object getUsers(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String nom) {

        return service.getUsers(id, nom);
    }


}



