package rsoi.lab2.gateway.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import rsoi.lab2.gateway.model.enums.TicketStatus;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketPurchaseResponse {
    String ticketUid;
    String flightNumber;
    String fromAirport;
    String toAirport;
    String date;
    Integer price;
    Integer paidByMoney;
    Integer paidByBonuses;
    TicketStatus status;
    PrivilegeShortInfo privilege;
}
