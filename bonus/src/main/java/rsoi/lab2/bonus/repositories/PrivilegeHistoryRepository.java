package rsoi.lab2.bonus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rsoi.lab2.bonus.model.PrivilegeHistory;

import java.util.List;

@Repository
public interface PrivilegeHistoryRepository extends JpaRepository<PrivilegeHistory, Long> {

    List<PrivilegeHistory> findAllByPrivilegeId(Long privilegeId);
}
