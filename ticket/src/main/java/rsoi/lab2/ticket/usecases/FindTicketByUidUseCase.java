package rsoi.lab2.ticket.usecases;

import org.springframework.stereotype.Component;
import rsoi.lab2.ticket.model.Ticket;
import rsoi.lab2.ticket.repository.TicketRepository;
import rsoi.lab2.ticket.responses.FindTicketResponse;

import java.util.UUID;

@Component
public class FindTicketByUidUseCase {

    private final TicketRepository ticketRepository;

    public FindTicketByUidUseCase(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public FindTicketResponse execute(String ticketUid) {
        return mapToFindTicketResponse(ticketRepository.findByTicketUid(UUID.fromString(ticketUid)));
    }

    private FindTicketResponse mapToFindTicketResponse(Ticket byTicketUid) {
        FindTicketResponse findTicketResponse = new FindTicketResponse();
        findTicketResponse.setFlightNumber(byTicketUid.getFlightNumber());
        findTicketResponse.setTicketUid(byTicketUid.getTicketUid().toString());
        findTicketResponse.setPrice(byTicketUid.getPrice());
        findTicketResponse.setStatus(byTicketUid.getStatus().name());

        return findTicketResponse;
    }
}
