package alann.spr.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Users")

public class User {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String password;

    // USER

    // 🔥 One User → Many Roles
    @ManyToOne
    @JoinColumn(name = "role_id")
    private List<Role> role;

    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    private Entreprise entreprise;


}


