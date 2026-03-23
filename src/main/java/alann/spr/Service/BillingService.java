package alann.spr.Service;

import alann.spr.Dto.ReponseDtoBIlling;
import alann.spr.Dto.RequestDtoBilling;
import alann.spr.Entity.Billing;
import alann.spr.Entity.Customer;
import alann.spr.Entity.Entreprise;
import alann.spr.mapper.BillingMapper;
import alann.spr.repository.BillingRepository;
import alann.spr.repository.CustomerRepository;
import alann.spr.repository.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {
    @Autowired
    private BillingRepository repository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @Autowired
    private BillingMapper mapper;

    // CREATE
    public ReponseDtoBIlling create(RequestDtoBilling dto) {

        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer non trouvé"));

        Entreprise entreprise = entrepriseRepository.findById(dto.getEntrepriseId())
                .orElseThrow(() -> new RuntimeException("Entreprise non trouvée"));

        Billing billing = mapper.toEntity(dto, customer, entreprise);

        return mapper.toDto(repository.save(billing));
    }

    // READ ALL
    public List<ReponseDtoBIlling> getAll() {
        return repository.findAll()
                .stream()
                .map(Bill -> mapper.toDto(Bill))
                .toList();
    }

    // READ ONE
    public ReponseDtoBIlling getById(Long id) {
        Billing Bill = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Billing non trouvé"));
        return mapper.toDto(Bill);
    }

    // UPDATE
    public ReponseDtoBIlling update(Long id, RequestDtoBilling dto) {

        Billing Bill = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Billing non trouvé"));

        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer non trouvé"));

        Entreprise entreprise = entrepriseRepository.findById(dto.getEntrepriseId())
                .orElseThrow(() -> new RuntimeException("Entreprise non trouvée"));

        Bill.setQuantite(dto.getQuantite());
        Bill.setPrix(dto.getPrix());
        Bill.setMontant(dto.getQuantite() * dto.getPrix());
        Bill.setCustomer(customer);
        Bill.setEntreprise(entreprise);

        return mapper.toDto(repository.save(Bill));
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
