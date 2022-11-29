package rsoi.lab2.bonus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rsoi.lab2.bonus.model.Privilege;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    Privilege findByUsername(String username);
}
