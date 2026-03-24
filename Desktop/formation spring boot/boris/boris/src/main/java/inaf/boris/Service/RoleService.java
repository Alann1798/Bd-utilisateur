package inaf.boris.Service;


import inaf.boris.Entity.Role;
import inaf.boris.Repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // CREATE
    public Role createRole(Role role) {
        if (role == null) {
            throw new RuntimeException("Role vide !");
        }
        return roleRepository.save(role);
    }

    // READ ALL
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // READ BY ID
    public Role getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role non trouvé avec id : " + id));
    }

    // UPDATE
    public Role updateRole(Long id, Role newRole) {

        Role role = getRoleById(id);

        role.setNom(newRole.getNom());
        role.setDescription(newRole.getDescription());

        return roleRepository.save(role);
    }

    // DELETE
    public void deleteRole(Long id) {
        Role role = getRoleById(id);
        roleRepository.delete(role);
    }
}


