package alann.spr.Controller;

import alann.spr.Dto.ReponseDtoRole;
import alann.spr.Dto.RequestDtoRole;
import alann.spr.Service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/role")
@Tag(name = "Role", description = "point d'entre pour gere les operations ajourté, modification, lecture, recherche en fonction de son identifient et la suppression d'un role en ce referent sur son identifient")
public class RoleController {
   @Autowired
    private RoleService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "ajourt d'un un role", description = "cette fonction permet d'ajourte  un role dans notre systeme en utilisant en entre un dto pour retourte une reponse claire et lissible  du role")
    public ReponseDtoRole create(@RequestBody RequestDtoRole dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<ReponseDtoRole> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ReponseDtoRole getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public ReponseDtoRole update(@PathVariable Long id, @RequestBody RequestDtoRole dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
