package alann.spr.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "client")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Nom;
    private String prenom;


    // 🔥 One Customer → Many Billing
    @OneToMany(mappedBy = "customer")
    private List<Billing> billings;
}
