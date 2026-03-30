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
import static org.mockito.Mockito.*;

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
        userEntity.setRole( role);
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

    //test par id
    @Test
    void shouldGetByIdReturnUser(){
        User user = new User();
        user.setId(1L);

        ReponseDtoUser reponse = new ReponseDtoUser();
        reponse.setId(1L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(mapper.toDto(user)).thenReturn(reponse);

        ReponseDtoUser result = userService.getById(1L);

        assertEquals(1L,result.getId());

    }
//test pour tous id
    @Test
    void shouldGetByAllReturnUser(){
        List<User> users = List.of(new User(), new User());
        when(userRepository.findAll()).thenReturn(users);
        when(mapper.toDto(any(User.class))).thenReturn(new ReponseDtoUser());

        List<ReponseDtoUser> result = userService.getAll();

        assertEquals(2, result.size());
    }
    //test pour le update
    @Test
    void shouldUpdateReturnUser(){
        //Given


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

            // user existant avant update
            User existingUser = new User();
            existingUser.setId(1L);
            existingUser.setNom("alann");
            existingUser.setEmail("alan@gmail.com");

            // user après update
            User userUpdated = new User();
            userUpdated.setId(1L);
            userUpdated.setNom("alann");
            userUpdated.setEmail("alan@gmail.com");
            userUpdated.setRole(role);
            userUpdated.setEntreprise(entreprise);

            ReponseDtoUser expectedResponse = new ReponseDtoUser();
            expectedResponse.setId(1L);
            expectedResponse.setNom("alann");
            expectedResponse.setEmail("alan@gmail.com");
            expectedResponse.setRoleNom("admin");
            expectedResponse.setEntrepriseNom("pitro");

            // When
            when(userRepository.findById(1L)).thenReturn(Optional.of(existingUser));
            when(roleRepository.findById(1L)).thenReturn(Optional.of(role));
            when(entrepriseRepository.findById(1L)).thenReturn(Optional.of(entreprise));

           // when(mapper.toEntity(requestDtoUser, role, entreprise)).thenReturn(userUpdated);
            when(userRepository.save(any(User.class))).thenReturn(userUpdated);
            when(mapper.toDto(userUpdated)).thenReturn(expectedResponse);

            // Act
            ReponseDtoUser result = userService.update(1L, requestDtoUser);

            // Assert
            assertNotNull(result);
            assertEquals("alan@gmail.com", result.getEmail());
            assertEquals("alann", result.getNom());
            assertEquals("admin", result.getRoleNom());
            assertEquals("pitro", result.getEntrepriseNom());
        }

        //test pour le delete

        @Test
        void shouldDeleteReturnUser() {

                // GIVEN
                Long userId = 1L;

                User user = new User();
                user.setId(1L);
                user.setNom("alann");

                // MOCK
                when(userRepository.findById(userId)).thenReturn(Optional.of(user));
                doNothing().when(userRepository).deleteById(userId);

                // WHEN
                userService.delete(userId);

                // THEN
                verify(userRepository).findById(userId);
                verify(userRepository).deleteById(userId);
            }
}