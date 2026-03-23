package alann.spr.Controller;

import alann.spr.Dto.ReponseDtoEntreprise;
import alann.spr.Dto.RequestDtoEntreprise;
import alann.spr.Service.EntrepriseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entreprises")
@Tag(name = "entreprise", description = "point d'entre pour gere les operations ajourté, modification, lecture, recherche en fonction de son identifient et la suppression d'une entreprise en ce referent sur son identifient")
public class EntrepriseController {
    @Autowired
    private EntrepriseService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "ajourt d'une entrprise", description = "cette fonction permet d'ajourte  une entreprise dans notre systeme en utilisant en entre un dto pour retourte une reponse claire et lissible  d'une entreprisse")
    public ReponseDtoEntreprise create(@RequestBody RequestDtoEntreprise dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<ReponseDtoEntreprise> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ReponseDtoEntreprise getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public ReponseDtoEntreprise update(@PathVariable Long id, @RequestBody RequestDtoEntreprise dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
