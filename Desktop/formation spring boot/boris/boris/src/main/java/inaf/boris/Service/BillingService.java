package inaf.boris.Service;


import inaf.boris.Entity.Billing;
import inaf.boris.Entity.Entreprise;
import inaf.boris.Exception.ResourceNotFoundException;
import inaf.boris.Repository.BillingRepository;
import inaf.boris.Repository.EntrepriseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {

    private final BillingRepository billingRepository;
    private final EntrepriseRepository entrepriseRepository;

    public BillingService(BillingRepository billingRepository, EntrepriseRepository entrepriseRepository) {
        this.billingRepository = billingRepository;
        this.entrepriseRepository = entrepriseRepository;
    }

    // CREATE
    public Billing create(Billing billing) {
        if (billing.getEntreprise() != null) {
            Long entrepriseId = billing.getEntreprise().getId();
            Entreprise entreprise = entrepriseRepository.findById(entrepriseId)
                    .orElseThrow(() -> new RuntimeException("Entreprise non trouvée"));
            billing.setEntreprise(entreprise);
        }
        return billingRepository.save(billing);
    }

    // READ ALL
    public List<Billing> getAll() {
        return billingRepository.findAll();
    }

    // READ BY ID
    public Billing getById(Long id) {
        return billingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Billing non trouvé avec id : " + id));
    }

    // UPDATE
    public Billing update(Long id, Billing newBilling) {
        Billing billing = getById(id);

        if(newBilling.getReference() != null) {
            billing.setReference(newBilling.getReference());
        }
        if(newBilling.getMontant() != null) {
            billing.setMontant(newBilling.getMontant());
        }
        if(newBilling.getDateFacture() != null) {
            billing.setDateFacture(newBilling.getDateFacture());
        }
        if(newBilling.getEntreprise() != null) {
            Long entrepriseId = newBilling.getEntreprise().getId();
            Entreprise entreprise = entrepriseRepository.findById(entrepriseId)
                    .orElseThrow(() -> new RuntimeException("Entreprise non trouvée"));
            billing.setEntreprise(entreprise);
        }

        return billingRepository.save(billing);
    }

    // DELETE
    public void delete(Long id) {
        Billing  billing = billingRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("billing not found by id: " + id));
        billingRepository.deleteById(billing.getId());
    }
}
