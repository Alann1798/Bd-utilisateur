package inaf.boris.Entity;


import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "entreprises")
public class Entreprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String adresse;
    private String secteur;

    @ManyToMany(mappedBy = "entreprises")
    private Set<Users> users;

    @OneToMany(mappedBy = "entreprise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Billing> billings;

    public Entreprise() {}

    public Entreprise(String nom, String adresse, String secteur) {
        this.nom = nom;
        this.adresse = adresse;
        this.secteur = secteur;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getSecteur() { return secteur; }
    public void setSecteur(String secteur) { this.secteur = secteur; }

    public Set<Users> getUsers() { return users; }
    public void setUsers(Set<Users> users) { this.users = users; }

    public List<Billing> getBillings() { return billings; }
    public void setBillings(List<Billing> billings) { this.billings = billings; }
}
