package inaf.boris.controller;


import inaf.boris.Entity.Billing;
import inaf.boris.Service.BillingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billings")
public class BillingController {

    private final BillingService billingService;

    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    // CREATE
    @PostMapping
    public Billing create(@RequestBody Billing billing) {
        return billingService.create(billing);
    }

    // READ ALL
    @GetMapping
    public List<Billing> getAll() {
        return billingService.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Billing getById(@PathVariable Long id) {
        return billingService.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Billing update(@PathVariable Long id, @RequestBody Billing billing) {
        return billingService.update(id, billing);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        billingService.delete(id);
    }
}