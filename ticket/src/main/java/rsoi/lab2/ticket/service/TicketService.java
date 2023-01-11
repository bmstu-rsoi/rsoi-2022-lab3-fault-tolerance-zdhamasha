package rsoi.lab2.ticket.service;

import rsoi.lab2.ticket.model.Ticket;
import rsoi.lab2.ticket.api.request.TicketPurchaseRequest;

import java.util.List;
import java.util.UUID;

public interface TicketService {

    List<Ticket> getAllByUsername(String username);

    Ticket getByUidAndUsername(UUID ticketUid, String username);

    Ticket create(String username, TicketPurchaseRequest request);

    Ticket refundTicket(Ticket ticket);
}
