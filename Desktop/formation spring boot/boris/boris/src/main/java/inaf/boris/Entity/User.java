package inaf.boris.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nom;
    private String email;
    private String password;

    public User() {
    }

    public User(Long id, String email, String password, String nom) {
        Id = id;
        this.email = email;
        this.password = password;
        this.nom = nom;
    }

}
