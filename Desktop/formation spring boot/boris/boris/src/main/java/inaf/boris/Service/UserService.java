package inaf.boris.Service;

import inaf.boris.Dto.ReponseUserDto;
import inaf.boris.Dto.RequestUserDto;
import inaf.boris.Entity.User;
import inaf.boris.Exception.CrudException;
import inaf.boris.Exception.GetAllException;
import inaf.boris.Exception.ResourceNotFoundException;
import inaf.boris.Mapper.UserMapper;
import inaf.boris.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static javax.swing.text.html.parser.DTDConstants.ID;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class UserService {
    private final UserRepository repository;
    public UserService(UserRepository repository) {
        this.repository = repository;
    }
    // CREATE
    public ReponseUserDto createUser(RequestUserDto dto) {
        try{

            User user = new User();
            user.setNom(dto.getNom());
            user.setEmail(dto.getEmail());
            user.setPassword(dto.getPassword());
            User saved = repository.save(user);
            return UserMapper.toDTO(saved);

        }catch (Exception e){

            throw new CrudException("Erreur lors de la création de l'utilisateur");

        }
    }

    // UPDATE
    public ReponseUserDto updateUser(Long id, RequestUserDto dto) {
        User user = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Utilisateur non trouvé avec id : " + id));

        user.setNom(dto.getNom());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        User updated = repository.save(user);
        return UserMapper.toDTO(updated);
    }

    // DELETE
    public void deleteUser(Long id) {

        User user = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Utilisateur non trouvé avec id : " + id));

        repository.delete(user);
    }

    // GET ALL
    public List<ReponseUserDto> getUser(){

        List<User> users = repository.findAll();

        if(users.isEmpty()){
            throw new GetAllException("Aucun utilisateur enregistré");
        }

        return users.stream()
                .map(UserMapper::toDTO)
                .toList();
    }

    // GET BY ID
    public ReponseUserDto getUserById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Utilisateur non trouvé avec id : " + id));
        return UserMapper.toDTO(user);
    }
}
