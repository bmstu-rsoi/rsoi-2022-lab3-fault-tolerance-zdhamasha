package rsoi.lab2.bonus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rsoi.lab2.bonus.requests.AddPrivilegeHistoryRequest;
import rsoi.lab2.bonus.requests.UpdatePrivilegeBalanceRequest;
import rsoi.lab2.bonus.responses.PrivilegeResponse;
import rsoi.lab2.bonus.usecases.AddPrivilegeHistoryUseCase;
import rsoi.lab2.bonus.usecases.FindPrivilegeUseCase;
import rsoi.lab2.bonus.usecases.UpdatePrivilegeBalanceUseCase;

@RestController
@RequestMapping("/api/v1/privilege")
public class PrivilegesController {

    private final FindPrivilegeUseCase findPrivilegeUseCase;
    private final UpdatePrivilegeBalanceUseCase updatePrivilegeBalanceUseCase;
    private final AddPrivilegeHistoryUseCase addPrivilegeHistoryUseCase;

    public PrivilegesController(FindPrivilegeUseCase findPrivilegeUseCase,
                                UpdatePrivilegeBalanceUseCase updatePrivilegeBalanceUseCase,
                                AddPrivilegeHistoryUseCase addPrivilegeHistoryUseCase) {
        this.findPrivilegeUseCase = findPrivilegeUseCase;
        this.updatePrivilegeBalanceUseCase = updatePrivilegeBalanceUseCase;
        this.addPrivilegeHistoryUseCase = addPrivilegeHistoryUseCase;
    }

    @GetMapping()
    public ResponseEntity<PrivilegeResponse> getPrivilege(@RequestHeader("X-User-Name") String username) {
        return ResponseEntity.ok(findPrivilegeUseCase.execute(username));
    }

    @PostMapping()
    public ResponseEntity<PrivilegeResponse> updatePrivilegeBalance(@RequestBody UpdatePrivilegeBalanceRequest request) {
        return ResponseEntity.ok(updatePrivilegeBalanceUseCase.execute(request));
    }

    @PostMapping("addToHistory")
    public void addToHistory(@RequestBody AddPrivilegeHistoryRequest request) {
        addPrivilegeHistoryUseCase.execute(request);
    }
}
