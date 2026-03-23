package alann.spr.repository;

import alann.spr.Entity.Billing;
import alann.spr.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository  extends JpaRepository<Billing, Long> {
}
