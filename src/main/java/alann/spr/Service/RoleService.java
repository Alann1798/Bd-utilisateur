package alann.spr.Service;

import alann.spr.Dto.ReponseDtoRole;
import alann.spr.Dto.RequestDtoRole;
import alann.spr.Entity.Role;
import alann.spr.mapper.RoleMapper;
import alann.spr.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;

    @Autowired
    private RoleMapper mapper;

    // CREATE
    public ReponseDtoRole create(RequestDtoRole dto) {
       Role role = mapper.toEntity(dto);
        return mapper.toDto(repository.save(role));
    }

    // READ ALL
    public List<ReponseDtoRole> getAll() {
        return repository.findAll()
                .stream()
                .map(role -> mapper.toDto(role))
                .collect(Collectors.toList());
    }

    // READ ONE
    public ReponseDtoRole getById(Long id) {
        Role role = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role non trouvé"));
        return mapper.toDto(role);
    }

    // UPDATE
    public ReponseDtoRole update(Long id, RequestDtoRole dto) {
        Role role = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role non trouvé"));

        role.setNom(dto.getNom());

        return mapper.toDto(repository.save(role));
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }
}