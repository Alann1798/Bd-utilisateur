package inaf.boris.Service;


import inaf.boris.Entity.Entreprise;
import inaf.boris.Repository.EntrepriseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrepriseService {

    private final EntrepriseRepository entrepriseRepository;

    public EntrepriseService(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    // CREATE
    public Entreprise create(Entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    // READ ALL
    public List<Entreprise> getAll() {
        return entrepriseRepository.findAll();
    }

    // READ BY ID
    public Entreprise getById(Long id) {
        return entrepriseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entreprise non trouvée avec id : " + id));
    }

    // UPDATE
    public Entreprise update(Long id, Entreprise newEntreprise) {
        Entreprise entreprise = getById(id);

        if(newEntreprise.getNom() != null) {
            entreprise.setNom(newEntreprise.getNom());
        }

        if(newEntreprise.getAdresse() != null) {
            entreprise.setAdresse(newEntreprise.getAdresse());
        }

        if(newEntreprise.getSecteur() != null) {
            entreprise.setSecteur(newEntreprise.getSecteur());
        }

        return entrepriseRepository.save(entreprise);
    }

    // DELETE
    public void delete(Long id) {
        entrepriseRepository.deleteById(id);
    }
}