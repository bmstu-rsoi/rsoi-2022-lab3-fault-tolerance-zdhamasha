package rsoi.lab2.ticket.usecases;

import org.springframework.stereotype.Component;
import rsoi.lab2.ticket.model.Ticket;
import rsoi.lab2.ticket.repository.TicketRepository;
import rsoi.lab2.ticket.responses.FindTicketResponse;
import rsoi.lab2.ticket.responses.FindTicketsResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindAllUserTicketsUseCase {

    private final TicketRepository ticketRepository;

    public FindAllUserTicketsUseCase(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public FindTicketsResponse execute(String username) {
        List<FindTicketResponse> tickets = ticketRepository.findAllByUsername(username)
                .stream()
                .map(this::mapToFindTicketResponse)
                .collect(Collectors.toList());

        FindTicketsResponse response = new FindTicketsResponse();
        response.setFindTicketResponseList(new ArrayList<>(tickets));
        return response;
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
