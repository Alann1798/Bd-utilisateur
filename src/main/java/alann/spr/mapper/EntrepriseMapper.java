package alann.spr.mapper;

import alann.spr.Dto.ReponseDtoEntreprise;
import alann.spr.Dto.ReponseDtoRole;
import alann.spr.Dto.RequestDtoEntreprise;
import alann.spr.Dto.RequestDtoRole;
import alann.spr.Entity.Entreprise;
import alann.spr.Entity.Role;
import org.springframework.stereotype.Component;

@Component
public class EntrepriseMapper {
    // ENTITY → DTO
    public ReponseDtoEntreprise toDto(Entreprise ent) {
        ReponseDtoEntreprise dto = new ReponseDtoEntreprise();
        dto.setId(ent.getId());
        dto.setNom(ent.getNom());
        dto.setContact(ent.getContact());
        dto.setLocal(ent.getLocal());
        return dto;
    }

    // DTO → ENTITY
    public Entreprise toEntity(RequestDtoEntreprise dto) {
        Entreprise ent = new Entreprise();
        ent.setNom(dto.getNom());
        ent.setContact(dto.getContact());
        ent.setLocal(dto.getLocal());
        return ent;
    }
}
