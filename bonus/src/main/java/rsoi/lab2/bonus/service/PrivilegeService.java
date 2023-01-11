package rsoi.lab2.bonus.service;

import rsoi.lab2.bonus.model.Privilege;
import rsoi.lab2.bonus.api.response.PrivilegeInfoResponse;
import rsoi.lab2.bonus.api.response.enums.OperationType;

public interface PrivilegeService {
    PrivilegeInfoResponse getPrivilegeInfo(String username);

    void save(Privilege privilege);

    Privilege getByUsername(String username);

    void payFromBalance(Privilege privilege);

    void giveBonuses(Privilege privilege, int price);


    OperationType setOperationType(boolean paidFromBalance, int balance);

}
