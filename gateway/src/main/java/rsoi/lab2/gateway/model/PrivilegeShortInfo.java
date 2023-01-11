package rsoi.lab2.gateway.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import rsoi.lab2.gateway.model.enums.PrivilegeStatus;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PrivilegeShortInfo {
    Integer balance;
    PrivilegeStatus status;
}
