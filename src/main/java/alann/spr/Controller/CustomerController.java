package alann.spr.Controller;

import alann.spr.Dto.ReponseDtoCustomer;
import alann.spr.Dto.RequestDtoCustomer;
import alann.spr.Service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
@Tag(name = "client", description = "point d'entre pour gere les operations ajourté, modufication, lecture, recherche en fonction de son identifient et la suppression d'un client en ce referent sur son identifient")
public class CustomerController {
    public CustomerController(CustomerService service){
        this.service =service;
    }

    private final CustomerService service;

    @PostMapping
    public ReponseDtoCustomer create(@RequestBody RequestDtoCustomer dto) {
        return service.createCustomer(dto);
    }

    @GetMapping
    public List<ReponseDtoCustomer> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id-client}")
    public ReponseDtoCustomer getById(@PathVariable Long id) {
        return service.getById(id);

    }

    @PutMapping("/{id}")
    public ReponseDtoCustomer update(@PathVariable Long id, @RequestBody RequestDtoCustomer dto) {
        return service.update(id,dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
