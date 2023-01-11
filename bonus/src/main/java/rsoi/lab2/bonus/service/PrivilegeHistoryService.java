package rsoi.lab2.bonus.service;

import rsoi.lab2.bonus.model.Privilege;
import rsoi.lab2.bonus.model.PrivilegeHistory;
import rsoi.lab2.bonus.api.response.enums.OperationType;

import java.util.List;
import java.util.UUID;

public interface PrivilegeHistoryService {

    List<PrivilegeHistory> getListByPrivilegeId(Long privilegeId);


    void create(Privilege privilege, String ticketUid, Integer balance, OperationType operationType);
}
