package alann.spr.Controller;

import alann.spr.Dto.ReponseDtoBIlling;
import alann.spr.Dto.RequestDtoBilling;
import alann.spr.Service.BillingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billings")
@Tag(name = "Facture", description = "point d'entre pour gere les operations ajourté, modification, lecture, recherche en fonction de son identifient et la suppression d'une facture en ce referent sur son identifient")
public class BillingController {

    @Autowired
    private BillingService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "ajourt d'une facture", description = "cette fonction permet d'ajourte  une facture dans notre systeme en utilisant en entre un dto pour retourte une reponse claire et lissible  d'une facture")
    public ReponseDtoBIlling create(@RequestBody RequestDtoBilling dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<ReponseDtoBIlling> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ReponseDtoBIlling getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public ReponseDtoBIlling update(@PathVariable Long id, @RequestBody RequestDtoBilling dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
