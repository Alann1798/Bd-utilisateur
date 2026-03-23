package alann.spr.repository;

import alann.spr.Entity.Role;
import alann.spr.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
