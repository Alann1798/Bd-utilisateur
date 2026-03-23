package alann.spr.mapper;

import alann.spr.Dto.ReponseDtoBIlling;
import alann.spr.Dto.RequestDtoBilling;
import alann.spr.Entity.Billing;
import alann.spr.Entity.Customer;
import alann.spr.Entity.Entreprise;
import org.springframework.stereotype.Component;

@Component
public class BillingMapper {

    // DTO → ENTITY
    public Billing toEntity(RequestDtoBilling dto, Customer customer, Entreprise entreprise) {
        Billing bill = new Billing();
        bill.setQuantite(dto.getQuantite());
        bill.setPrix(dto.getPrix());
        bill.setMontant(dto.getQuantite() * dto.getPrix()); // calcul automatique
        bill.setCustomer(customer);
        bill.setEntreprise(entreprise);
        return bill;
    }

    // ENTITY → DTO
    public ReponseDtoBIlling toDto(Billing bill) {
        ReponseDtoBIlling dto = new ReponseDtoBIlling();
        dto.setId(bill.getId());
        dto.setQuantite(bill.getQuantite());
        dto.setPrix(bill.getPrix());
        dto.setMontant(bill.getMontant());
        dto.setCustomerNom(bill.getCustomer().getNom());
        dto.setEntrepriseNom(bill.getEntreprise().getNom());
        return dto;
    }
}
