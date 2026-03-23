package alann.spr.Entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "Billing")
public class Billing {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantite;
    private double montant;
    private double prix;

    // 🔥 Many Billing → One Customer
    // BILLING
    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    // 🔥 OneToOne avec Entreprise
    @ManyToOne
    @JoinColumn(name = "entreprise")
    private Entreprise entreprise;
}
