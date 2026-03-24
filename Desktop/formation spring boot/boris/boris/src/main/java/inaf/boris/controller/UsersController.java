package inaf.boris.controller;

import inaf.boris.Entity.Users;
import inaf.boris.Service.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    // CREATE
    @PostMapping
    public Users create(@RequestBody Users user) {
        return usersService.createUser(user);
    }

    // READ ALL
    @GetMapping
    public List<Users> getAll() {
        return usersService.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Users getById(@PathVariable Long id) {
        return usersService.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Users update(@PathVariable Long id, @RequestBody Users user) {
        return usersService.update(id, user);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usersService.delete(id);
    }
}