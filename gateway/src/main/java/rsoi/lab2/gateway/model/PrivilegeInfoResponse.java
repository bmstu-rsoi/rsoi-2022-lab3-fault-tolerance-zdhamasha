package rsoi.lab2.gateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import rsoi.lab2.gateway.model.enums.PrivilegeStatus;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE)
public class PrivilegeInfoResponse {
    Integer balance;
    PrivilegeStatus status;
    List<BalanceHistory> history;
}
