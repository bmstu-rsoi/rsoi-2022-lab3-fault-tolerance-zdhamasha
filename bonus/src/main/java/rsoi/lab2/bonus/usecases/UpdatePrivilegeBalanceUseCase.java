package rsoi.lab2.bonus.usecases;

import org.springframework.stereotype.Component;
import rsoi.lab2.bonus.model.Privilege;
import rsoi.lab2.bonus.repositories.PrivilegeRepository;
import rsoi.lab2.bonus.requests.UpdatePrivilegeBalanceRequest;
import rsoi.lab2.bonus.responses.PrivilegeResponse;

@Component
public class UpdatePrivilegeBalanceUseCase {

    private final PrivilegeRepository privilegeRepository;

    public UpdatePrivilegeBalanceUseCase(PrivilegeRepository privilegeRepository) {
        this.privilegeRepository = privilegeRepository;
    }

    public PrivilegeResponse execute(UpdatePrivilegeBalanceRequest request) {
        Privilege privilege = privilegeRepository.findByUsername(request.getUsername());
        privilege.setBalance(privilege.getBalance() + request.getCreditedTicketAmount() * 10 / 100);
        privilegeRepository.save(privilege);

        return mapToPrivilegeResponse(privilege);
    }

    private PrivilegeResponse mapToPrivilegeResponse(Privilege privilege) {
        PrivilegeResponse privilegeResponse = new PrivilegeResponse();
        privilegeResponse.setId(privilege.getId());
        privilegeResponse.setUsername(privilege.getUsername());
        privilegeResponse.setBalance(privilege.getBalance());
        privilegeResponse.setStatus(privilege.getStatus().name());

        return privilegeResponse;
    }
}
