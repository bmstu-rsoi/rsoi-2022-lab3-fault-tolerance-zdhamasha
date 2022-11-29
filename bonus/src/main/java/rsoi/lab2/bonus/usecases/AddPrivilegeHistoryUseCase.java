package rsoi.lab2.bonus.usecases;

import org.springframework.stereotype.Component;
import rsoi.lab2.bonus.model.OperationType;
import rsoi.lab2.bonus.model.PrivilegeHistory;
import rsoi.lab2.bonus.repositories.PrivilegeHistoryRepository;
import rsoi.lab2.bonus.requests.AddPrivilegeHistoryRequest;

import java.sql.Timestamp;
import java.util.Date;

@Component
public class AddPrivilegeHistoryUseCase {

    private final PrivilegeHistoryRepository privilegeHistoryRepository;

    public AddPrivilegeHistoryUseCase(PrivilegeHistoryRepository privilegeHistoryRepository) {
        this.privilegeHistoryRepository = privilegeHistoryRepository;
    }

    public void execute(AddPrivilegeHistoryRequest request) {
        PrivilegeHistory history = new PrivilegeHistory();
        history.setPrivilegeId(request.getPrivilegeId());
        history.setTicket_uid(request.getTicket_uid());
        history.setBalanceDiff(request.getBalanceDiff());
        history.setOperationType(OperationType.FILL_IN_BALANCE);
        history.setDatetime(new Timestamp(new Date().getTime()));

        privilegeHistoryRepository.save(history);
    }
}
