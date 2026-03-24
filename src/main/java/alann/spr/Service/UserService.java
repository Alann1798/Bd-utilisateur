package alann.spr.Service;

import alann.spr.Dto.ReponseDtoUser;
import alann.spr.Dto.RequestDtoUser;
import alann.spr.Entity.Entreprise;
import alann.spr.Entity.Role;
import alann.spr.Entity.User;
import alann.spr.Exeption.*;
import alann.spr.mapper.CustomerMapper;
import alann.spr.mapper.UserMapper;
import alann.spr.repository.EntrepriseRepository;
import alann.spr.repository.RoleRepository;
import alann.spr.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.AccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final EntrepriseRepository entrepriseRepository;
    private final UserMapper mapper;

    public UserService(UserRepository repository,RoleRepository roleRepository ,EntrepriseRepository entrepriseRepository, UserMapper mapper) {
        this.userRepository = repository;
        this.entrepriseRepository = entrepriseRepository;
        this.roleRepository = roleRepository;

        this.mapper= mapper;
    }

//creer

    public ReponseDtoUser createUser(RequestDtoUser dto) {

        Role role = roleRepository.findById(dto.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        Entreprise entreprise = entrepriseRepository.findById(dto.getEntrepriseId())
                .orElseThrow(() -> new RuntimeException("Entreprise not found"));

        User user = mapper.toEntity(dto, role, entreprise);

        return mapper.toDto(userRepository.save(user));
    }

    //lire tous
    public List<ReponseDtoUser> getAll() {
        return userRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    //lire par ID
    public ReponseDtoUser getById(Long id) {
        return mapper.toDto(userRepository.findById(id).orElseThrow(()->new RuntimeException("utilisateur non trouver")));
    }
    //modifier

    public ReponseDtoUser update(Long id, RequestDtoUser dto) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("utilisateur non trouver"));

        Role role = roleRepository.findById(dto.getRoleId()).orElseThrow(()->new RuntimeException("utilisateur non trouver"));
        Entreprise entreprise = entrepriseRepository.findById(dto.getEntrepriseId()).orElseThrow(()->new RuntimeException("utilisateur non trouver"));

        user.setNom(dto.getNom());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(role);
        user.setEntreprise(entreprise);

        return mapper.toDto(userRepository.save(user));
    }

    //supprimer
    public void delete(Long id) {
        userRepository.deleteById(id);
    }


    //exception serveur
    public String createUser() {
        boolean erreur = true;
        if (erreur) {
            throw new ServerException("erreur interne lors de la creaction de l'utilisateur");
        }
        return "utilisateur cree avec succes";
    }

    //ressource proteger
 //   public String AccessException(String username) {

   //     if (!role.equals("Admin")) {
     //       throw new AccessException("Acces refuser: ressource protegée");

     //   return "bienvenu admin";

    //Exception create
    public String createUser(String nom,String email, String password){
        if(nom == null || nom.isEmpty()){
            throw new CreateException("erreur lors de la creaction de l'utilisateur:" +
                    " nom, email, password invallide");}
        return "utilisateur cree avec succes";
    }
    //exeption read
    public String getUserById(Long id) {

        boolean userNotFound = true;

        if (userNotFound) {
            throw new ReadException(
                    "Utilisateur avec l'id " + id + " introuvable"
            );
        }
        return "Utilisateur trouvé";
    }

    //exception update

    public String updateUser(Long id, String nom) {

        boolean userNotFound = true;
        boolean invalidData = false;

        if (userNotFound) {
            throw new UpdateException(
                    "Impossible de mettre à jour : utilisateur avec l'id " + id + " introuvable"
            );
        }
        if (invalidData) {
            throw new UpdateException(
                    "Données invalides pour la mise à jour de l'utilisateur"
            );
        }
        return "Utilisateur mis à jour avec succès";
    }
    //exception pour le delete
    public String deleteUser(Long id) {
        boolean userNotFound = true;
        boolean deleteError = false;
        if (userNotFound) {
            throw new DeleteException(
                    "Impossible de supprimer : utilisateur avec l'id " + id + " introuvable"
            );
        }
        if (deleteError) {
            throw new DeleteException(
                    "Erreur lors de la suppression de l'utilisateur avec l'id " + id
            );
        }
        return "Utilisateur supprimé avec succès";
    }

    //eception pour le  git
    public Object getUsers(Long id, String nom) {

        // 👉 Cas 1 : GET by ID
        if (id != null) {
            boolean userNotFound = true;

            if (userNotFound) {
                throw new GetException(
                        "Utilisateur avec l'id " + id + " introuvable"
                );
            }
            return "Utilisateur trouvé";
        }
        // 👉 Cas 2 : GET avec filtre
        List<String> results = new ArrayList<>();
        if (results.isEmpty()) {
            throw new GetException(
                    "Aucun utilisateur trouvé avec le nom : " + nom
            );
        }

        return results;
    }
}