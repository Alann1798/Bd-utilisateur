package inaf.boris.integration;

import inaf.boris.Entity.Role;
import inaf.boris.Entity.Users;
import inaf.boris.Repository.RoleRepository;
import inaf.boris.Repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UsersIntegrationTest {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void testSaveUser() {

        Role role = new Role();
        role.setNom("ADMIN");
        Role savedRole = roleRepository.save(role);

        Users user = new Users();
        user.setNom("Boris");
        user.setRole(savedRole);

        Users saved = userRepository.save(user);

        assertNotNull(saved.getId());
    }
}
