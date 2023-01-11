package rsoi.lab2.ticket.service.impl;

import org.springframework.stereotype.Service;
import rsoi.lab2.ticket.model.Ticket;
import rsoi.lab2.ticket.service.TicketService;
import rsoi.lab2.ticket.api.request.TicketPurchaseRequest;
import rsoi.lab2.ticket.api.response.enums.TicketStatus;
import rsoi.lab2.ticket.repository.TicketRepository;

import java.util.List;
import java.util.UUID;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Ticket> getAllByUsername(String username) {
        return ticketRepository.findAllByUsername(username);
    }

    @Override
    public Ticket getByUidAndUsername(UUID ticketUid, String username) {
        return ticketRepository.findByTicketUidAndUsername(ticketUid, username);
    }

    @Override
    public Ticket create(String username, TicketPurchaseRequest request) {
        Ticket ticket = new Ticket();
        ticket.setTicketUid(UUID.randomUUID());
        ticket.setFlightNumber(request.getFlightNumber());
        ticket.setPrice(Long.valueOf(request.getPrice()));
        ticket.setUsername(username);
        ticket.setStatus(String.valueOf(TicketStatus.PAID));
        ticketRepository.save(ticket);
        return ticket;
    }

    @Override
    public Ticket refundTicket(Ticket ticket) {
        ticket.setStatus(String.valueOf(TicketStatus.CANCELED));
        ticketRepository.save(ticket);
        return ticket;
    }

}
