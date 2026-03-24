package inaf.boris.Service;

import inaf.boris.Entity.Role;
import inaf.boris.Entity.Users;
import inaf.boris.Repository.RoleRepository;
import inaf.boris.Repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final RoleRepository roleRepository;

    public UsersService(UsersRepository usersRepository, RoleRepository roleRepository) {
        this.usersRepository = usersRepository;
        this.roleRepository = roleRepository;
    }

    // CREATE
    public Users createUser(Users user) {
        if (user == null || user.getRole() == null || user.getRole().getId() == null) {
            throw new RuntimeException("Role invalide");
        }

        Long roleId = user.getRole().getId();
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role non trouvé"));

        user.setRole(role);

        if (user.getEntreprises() == null) {
            user.setEntreprises(new java.util.HashSet<>());
        }

        return usersRepository.save(user);
    }

    // READ ALL
    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    // READ BY ID
    public Users getById(Long id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User non trouvé"));
    }

    // UPDATE
    public Users update(Long id, Users newUser) {
        Users user = getById(id);
        user.setNom(newUser.getNom());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        user.setRole(newUser.getRole());
        user.setEntreprises(newUser.getEntreprises());
        return usersRepository.save(user);
    }

    // DELETE
    public void delete(Long id) {
        usersRepository.deleteById(id);
    }
}