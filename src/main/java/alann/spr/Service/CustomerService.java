package alann.spr.Service;

import alann.spr.Dto.ReponseDtoCustomer;
import alann.spr.Dto.RequestDtoCustomer;
import alann.spr.Entity.Customer;
import alann.spr.mapper.CustomerMapper;
import alann.spr.repository.CustomerRepository;
import alann.spr.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class CustomerService {


    @Autowired
    private final CustomerRepository repository;
    private final CustomerMapper mapper;


    public CustomerService(CustomerRepository repository,CustomerMapper mapper ) {
        this.repository = repository;
        this.mapper= mapper;
    }

    // CREATE
    public  ReponseDtoCustomer createCustomer(RequestDtoCustomer dto) {
        Customer customer = mapper.toEntity(dto);
        return CustomerMapper.toDto(repository.save(customer));
    }

    // READ ALL
    public List<ReponseDtoCustomer> getAll() {
        return repository.findAll()
                .stream()
                .map(CustomerMapper::toDto)
                .collect(Collectors.toList());
    }

    // READ BY ID
    public ReponseDtoCustomer getById(Long id) {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return CustomerMapper.toDto(customer);
    }

    // UPDATE (sans setter)
    public ReponseDtoCustomer update(Long id, RequestDtoCustomer dto) {

        Customer old = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        old.getNom();
        old.getPrenom();

        Customer updated = repository.save(old);

        return mapper.toDto(repository.save(updated));
    }

    // DELETE
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Customer not found");
        }
        repository.deleteById(id);
    }

}
