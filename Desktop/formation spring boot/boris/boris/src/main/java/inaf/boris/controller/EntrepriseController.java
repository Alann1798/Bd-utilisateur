package inaf.boris.controller;


import inaf.boris.Entity.Entreprise;
import inaf.boris.Service.EntrepriseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entreprises")

public class EntrepriseController {

    private final EntrepriseService entrepriseService;

    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    // CREATE
    @PostMapping
    public Entreprise create(@RequestBody Entreprise entreprise) {
        return entrepriseService.create(entreprise);
    }

    // READ ALL
    @GetMapping
    public List<Entreprise> getAll() {
        return entrepriseService.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Entreprise getById(@PathVariable Long id) {
        return entrepriseService.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Entreprise update(@PathVariable Long id, @RequestBody Entreprise entreprise) {
        return entrepriseService.update(id, entreprise);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        entrepriseService.delete(id);
    }
}
