package rsoi.lab2.bonus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rsoi.lab2.bonus.model.PrivilegeHistory;

import java.util.List;

public interface PrivilegeHistoryRepository extends JpaRepository<PrivilegeHistory, Long> {
    List<PrivilegeHistory> findAllByPrivilegeId(Long privilegeId);
}
