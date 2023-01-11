package rsoi.lab2.bonus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rsoi.lab2.bonus.model.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
    Privilege findByUsername(String username);
}
