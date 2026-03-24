package alann.spr.Service;

import alann.spr.Dto.ReponseDtoEntreprise;
import alann.spr.Dto.RequestDtoEntreprise;
import alann.spr.Entity.Entreprise;
import alann.spr.mapper.EntrepriseMapper;
import alann.spr.repository.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntrepriseService {

    @Autowired
    private EntrepriseRepository repository;

    @Autowired
    private EntrepriseMapper mapper;

    // CREATE
    public ReponseDtoEntreprise create(RequestDtoEntreprise dto) {
       Entreprise ent = mapper.toEntity(dto);
        return mapper.toDto(repository.save(ent));
    }

    // READ ALL
    public List<ReponseDtoEntreprise> getAll() {
        return repository.findAll()
                .stream()
                .map(entreprise -> mapper.toDto(entreprise))
                .collect(Collectors.toList());
    }

    // READ ONE
    public ReponseDtoEntreprise getById(Long id) {
        Entreprise e = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entreprise non trouvée"));
        return mapper.toDto(e);
    }

    // UPDATE
    public ReponseDtoEntreprise update(Long id, RequestDtoEntreprise dto) {
        Entreprise e = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entreprise non trouvée"));

        e.setNom(dto.getNom());
        e.setContact(dto.getContact());
        e.setLocal(dto.getLocal());

        return mapper.toDto(repository.save(e));
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
