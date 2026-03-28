package alann.spr.Service;

import alann.spr.Dto.ReponseDtoUser;
import alann.spr.Dto.RequestDtoUser;
import alann.spr.Entity.Entreprise;
import alann.spr.Entity.Role;
import alann.spr.Entity.User;
import alann.spr.mapper.UserMapper;
import alann.spr.repository.EntrepriseRepository;
import alann.spr.repository.RoleRepository;
import alann.spr.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock UserRepository userRepository;
    @Mock RoleRepository roleRepository;
    @Mock EntrepriseRepository entrepriseRepository;
    @Mock
    UserMapper mapper;

    @InjectMocks UserService userService;

    @Test
    void shouldCreateAndReturnUser() {

        Role role = new Role();
        role.setId(1L);
        role.setNom("admin");

        Entreprise entreprise = new Entreprise();
        entreprise.setId(1L);
        entreprise.setNom("pitro");

        RequestDtoUser requestDtoUser = new RequestDtoUser();
        requestDtoUser.setEmail("alan@gmail.com");
        requestDtoUser.setNom("alann");
        requestDtoUser.setPassword("124578");
        requestDtoUser.setRoleId(1L);
        requestDtoUser.setEntrepriseId(1L);

        User userEntity = new User();
        userEntity.setId(1L);
        userEntity.setNom("alann");
        userEntity.setEmail("alan@gmail.com");
        userEntity.setRole(List.of(role));
        userEntity.setEntreprise(entreprise);

        ReponseDtoUser expectedResponse = new ReponseDtoUser();
        expectedResponse.setId(1L);
        expectedResponse.setNom("alann");
        expectedResponse.setEmail("alan@gmail.com");
        expectedResponse.setRoleNom("admin");
        expectedResponse.setEntrepriseNom("pitro");

        // when
        when(roleRepository.findById(1L)).thenReturn(Optional.of(role));
        when(entrepriseRepository.findById(1L)).thenReturn(Optional.of(entreprise));
        when(mapper.toEntity(requestDtoUser, role, entreprise)).thenReturn(userEntity);
        when(userRepository.save(any(User.class))).thenReturn(userEntity);
        when(mapper.toDto(userEntity)).thenReturn(expectedResponse);

        // Act
        ReponseDtoUser result = userService.createUser(requestDtoUser);

        // Assert
        assertNotNull(result);
        assertEquals("alan@gmail.com", result.getEmail());
        assertEquals("alann", result.getNom());
        assertEquals("admin", result.getRoleNom());
        assertEquals("pitro", result.getEntrepriseNom());
    }
}