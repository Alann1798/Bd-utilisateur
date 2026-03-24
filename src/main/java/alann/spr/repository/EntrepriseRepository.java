package alann.spr.repository;

import alann.spr.Entity.Entreprise;
import alann.spr.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
}
