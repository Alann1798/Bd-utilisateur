package inaf.boris.controller;

import inaf.boris.Service.RoleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import inaf.boris.Entity.Role;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    // ✅ CREATE
    @PostMapping
    public Role createRole(@RequestBody Role role) {
        return service.createRole(role);
    }

    // ✅ READ ALL
    @GetMapping
    public List<Role> getAllRoles() {
        return service.getAllRoles();
    }

    // ✅ READ BY ID
    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable Long id) {
        return service.getRoleById(id);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public Role updateRole(@PathVariable Long id, @RequestBody Role role) {
        return service.updateRole(id, role);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable Long id) {
        service.deleteRole(id);
        return "Role supprimé avec succès";
    }
}