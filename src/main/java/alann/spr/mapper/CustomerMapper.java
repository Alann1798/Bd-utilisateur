package alann.spr.mapper;

import alann.spr.Dto.ReponseDtoCustomer;
import alann.spr.Dto.RequestDtoCustomer;
import alann.spr.Entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toEntity(RequestDtoCustomer dto) {
        if (dto == null) return null;
        Customer customer = new Customer();
        customer.setNom(dto.getNom());
        customer.setPrenom(dto.getPrenom());
        return customer;
    }

    public static ReponseDtoCustomer toDto(Customer customer) {
        if (customer == null) return null;
        ReponseDtoCustomer dto = new ReponseDtoCustomer();
        dto.setId(customer.getId());
        dto.setNom(customer.getNom());
        dto.setPrenom(customer.getPrenom());
        return dto;

    }
}