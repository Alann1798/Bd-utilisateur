package service;

import inaf.boris.Entity.Role;
import inaf.boris.Entity.Users;
import inaf.boris.Repository.RoleRepository;
import inaf.boris.Repository.UsersRepository;
import inaf.boris.Service.UsersService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsersServiceTest {

    @Mock
    private UsersRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private UsersService service;

    @Test
    void createUser_success() {

        Role role = new Role();
        role.setId(1L);

        Users user = new Users();
        user.setRole(role);

        when(roleRepository.findById(1L)).thenReturn(Optional.of(role));
        when(userRepository.save(user)).thenReturn(user);

        Users result = service.createUser(user);

        assertNotNull(result);
    }
}