package rsoi.lab2.ticket.api.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import rsoi.lab2.ticket.api.response.enums.PrivilegeStatus;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PrivilegeShortInfo {
    String balance;
    PrivilegeStatus status;
}
