package alann.spr.mapper;

import alann.spr.Dto.ReponseDtoRole;
import alann.spr.Dto.RequestDtoRole;
import alann.spr.Entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public Role toEntity(RequestDtoRole dto) {
        Role role = new Role();
        role.setNom(dto.getNom());
        return role;
    }

    public ReponseDtoRole toDto(Role role) {
        ReponseDtoRole dto = new ReponseDtoRole();
        dto.setId(role.getId());
        dto.setNom(role.getNom());
        return dto;
    }
}
