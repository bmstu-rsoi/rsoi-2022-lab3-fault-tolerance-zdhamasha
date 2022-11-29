package rsoi.lab2.bonus.usecases;

import org.springframework.stereotype.Component;
import rsoi.lab2.bonus.model.Privilege;
import rsoi.lab2.bonus.model.PrivilegeHistory;
import rsoi.lab2.bonus.repositories.PrivilegeHistoryRepository;
import rsoi.lab2.bonus.repositories.PrivilegeRepository;
import rsoi.lab2.bonus.responses.PrivilegeHistoryResponse;
import rsoi.lab2.bonus.responses.PrivilegeResponse;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindPrivilegeUseCase {

    private final PrivilegeRepository privilegeRepository;
    private final PrivilegeHistoryRepository privilegeHistoryRepository;

    public FindPrivilegeUseCase(PrivilegeRepository privilegeRepository,
                                PrivilegeHistoryRepository privilegeHistoryRepository) {
        this.privilegeRepository = privilegeRepository;
        this.privilegeHistoryRepository = privilegeHistoryRepository;
    }

    public PrivilegeResponse execute(String username) {
        Privilege privilege = privilegeRepository.findByUsername(username);
        List<PrivilegeHistory> privilegeHistory = privilegeHistoryRepository.findAllByPrivilegeId(privilege.getId());

        return mapToPrivilegeResponse(privilege, privilegeHistory);
    }

    private PrivilegeResponse mapToPrivilegeResponse(Privilege privilege, List<PrivilegeHistory> privilegeHistory) {
        PrivilegeResponse privilegeResponse = new PrivilegeResponse();
        privilegeResponse.setId(privilege.getId());
        privilegeResponse.setUsername(privilege.getUsername());
        privilegeResponse.setBalance(privilege.getBalance());
        privilegeResponse.setStatus(privilege.getStatus().name());
        privilegeResponse.setHistory(privilegeHistory.stream().map(this::mapToPrivilegeHistoryResponse).collect(Collectors.toList()));
        return privilegeResponse;
    }

    private PrivilegeHistoryResponse mapToPrivilegeHistoryResponse(PrivilegeHistory privilegeHistory) {
        PrivilegeHistoryResponse response = new PrivilegeHistoryResponse();
        response.setTicketUid(privilegeHistory.getTicket_uid().toString());
        return response;
    }
}
