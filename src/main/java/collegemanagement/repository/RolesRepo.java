package collegemanagement.repository;

import collegemanagement.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepo  extends JpaRepository<Role,Integer> {
}
