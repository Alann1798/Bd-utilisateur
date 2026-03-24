package alann.spr.mapper;

import alann.spr.Dto.ReponseDtoCustomer;
import alann.spr.Dto.ReponseDtoUser;
import alann.spr.Dto.RequestDtoCustomer;
import alann.spr.Dto.RequestDtoUser;
import alann.spr.Entity.Customer;
import alann.spr.Entity.Entreprise;
import alann.spr.Entity.Role;
import alann.spr.Entity.User;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
@Component
public class UserMapper {



public User toEntity(RequestDtoUser dto, Role role, Entreprise entreprise) {
    User user = new User();
    user.setNom(dto.getNom());
    user.setEmail(dto.getEmail());
    user.setPassword(dto.getPassword());
    user.setRole(role);
    user.setEntreprise(entreprise);
    return user;
}

    public ReponseDtoUser toDto(User user) {
        ReponseDtoUser dto = new ReponseDtoUser();
        dto.setId(user.getId());
        dto.setNom(user.getNom());
        dto.setEmail(user.getEmail());
        dto.setRoleNom(user.getRole().getNom());
        dto.setEntrepriseNom(user.getEntreprise().getNom());
        return dto;
    }
}
