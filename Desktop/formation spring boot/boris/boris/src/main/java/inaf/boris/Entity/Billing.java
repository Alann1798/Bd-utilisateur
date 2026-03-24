package inaf.boris.Entity;

import jakarta.persistence.*;

import java.util.List;

    @Entity
    @Table(name = "billings")
    public class Billing {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String reference;
        private Double montant;
        private String dateFacture;

        @ManyToOne
        @JoinColumn(name = "entreprise_id")
        private Entreprise entreprise;

        @OneToMany(mappedBy = "billing", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Customer> customers;

        public Billing() {}

        public Billing(String reference, Double montant, String dateFacture) {
            this.reference = reference;
            this.montant = montant;
            this.dateFacture = dateFacture;
        }

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getReference() { return reference; }
        public void setReference(String reference) { this.reference = reference; }

        public Double getMontant() { return montant; }
        public void setMontant(Double montant) { this.montant = montant; }

        public String getDateFacture() { return dateFacture; }
        public void setDateFacture(String dateFacture) { this.dateFacture = dateFacture; }

        public Entreprise getEntreprise() { return entreprise; }
        public void setEntreprise(Entreprise entreprise) { this.entreprise = entreprise; }

        public List<Customer> getCustomers() { return customers; }
        public void setCustomers(List<Customer> customers) { this.customers = customers; }
}
