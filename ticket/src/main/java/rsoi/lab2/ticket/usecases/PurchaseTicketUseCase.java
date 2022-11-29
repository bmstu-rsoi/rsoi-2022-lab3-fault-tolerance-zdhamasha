package rsoi.lab2.ticket.usecases;

import org.springframework.stereotype.Component;
import rsoi.lab2.ticket.model.Status;
import rsoi.lab2.ticket.model.Ticket;
import rsoi.lab2.ticket.repository.TicketRepository;
import rsoi.lab2.ticket.requests.PurchaseTicketRequest;
import rsoi.lab2.ticket.responses.PurchaseTicketResponse;

import java.util.UUID;

@Component
public class PurchaseTicketUseCase {

    private final TicketRepository ticketRepository;

    public PurchaseTicketUseCase(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public PurchaseTicketResponse execute(PurchaseTicketRequest request) {
        Ticket createdTicket = ticketRepository.save(createTicket(request));
        return getPurchaseTicketResponse(createdTicket);
    }

    private Ticket createTicket(PurchaseTicketRequest request) {
        Ticket ticket = new Ticket();
        ticket.setFlightNumber(request.getFlightNumber());
        ticket.setTicketUid(UUID.randomUUID());
        ticket.setPrice(request.getPrice());
        ticket.setStatus(Status.PAID);
        ticket.setUsername(request.getUsername());
        return ticket;
    }

    private PurchaseTicketResponse getPurchaseTicketResponse(Ticket createdTicket) {
        PurchaseTicketResponse purchaseTicketResponse = new PurchaseTicketResponse();
        purchaseTicketResponse.setTicketUid(createdTicket.getTicketUid());
        purchaseTicketResponse.setFlightNumber(createdTicket.getFlightNumber());
        purchaseTicketResponse.setUsername(createdTicket.getUsername());
        purchaseTicketResponse.setPrice(createdTicket.getPrice());
        purchaseTicketResponse.setStatus(createdTicket.getStatus());
        return purchaseTicketResponse;
    }
}
