package alann.spr.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "entreprise")
public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Nom;
    private String contact;
    private String local;

    // 🔥 One Entreprise → Many Users
    @OneToMany(mappedBy = "entreprise")
    private List<User> users;

    // 🔥 OneToOne avec Billing
    @OneToOne
    private Billing billing;

}
