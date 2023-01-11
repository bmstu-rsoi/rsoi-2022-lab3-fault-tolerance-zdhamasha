package rsoi.lab2.gateway.model;

import lombok.Data;
import lombok.experimental.FieldDefaults;
import rsoi.lab2.gateway.model.enums.TicketStatus;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class TicketResponse {
    String ticketUid;
    String flightNumber;
    String fromAirport;
    String toAirport;
    String date;
    Integer price;
    TicketStatus status;
}
