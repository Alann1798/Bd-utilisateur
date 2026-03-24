package inaf.boris.Service;


import inaf.boris.Entity.Billing;
import inaf.boris.Entity.Customer;
import inaf.boris.Repository.BillingRepository;
import inaf.boris.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final BillingRepository billingRepository;

    public CustomerService(CustomerRepository customerRepository, BillingRepository billingRepository) {
        this.customerRepository = customerRepository;
        this.billingRepository = billingRepository;
    }

    // CREATE
    public Customer create(Customer customer) {
        if (customer.getBilling() != null) {
            Long billingId = customer.getBilling().getId();
            Billing billing = billingRepository.findById(billingId)
                    .orElseThrow(() -> new RuntimeException("Billing non trouvé"));
            customer.setBilling(billing);
        }
        return customerRepository.save(customer);
    }

    // READ ALL
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    // READ BY ID
    public Customer getById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer non trouvé avec id : " + id));
    }

    // UPDATE
    public Customer update(Long id, Customer newCustomer) {
        Customer customer = getById(id);

        if (newCustomer.getNom() != null) {
            customer.setNom(newCustomer.getNom());
        }
        if (newCustomer.getEmail() != null) {
            customer.setEmail(newCustomer.getEmail());
        }
        if (newCustomer.getTelephone() != null) {
            customer.setTelephone(newCustomer.getTelephone());
        }
        if (newCustomer.getBilling() != null) {
            Long billingId = newCustomer.getBilling().getId();
            Billing billing = billingRepository.findById(billingId)
                    .orElseThrow(() -> new RuntimeException("Billing non trouvé"));
            customer.setBilling(billing);
        }

        return customerRepository.save(customer);
    }

    // DELETE
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
