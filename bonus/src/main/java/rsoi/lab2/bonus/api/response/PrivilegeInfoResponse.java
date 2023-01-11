package rsoi.lab2.bonus.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import rsoi.lab2.bonus.api.response.enums.Status;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class PrivilegeInfoResponse {
    Integer balance;
    Status status;
    List<BalanceHistory> history;
}
