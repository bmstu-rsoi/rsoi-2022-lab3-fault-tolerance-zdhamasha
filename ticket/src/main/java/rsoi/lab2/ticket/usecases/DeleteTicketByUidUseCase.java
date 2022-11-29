package rsoi.lab2.ticket.usecases;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import rsoi.lab2.ticket.repository.TicketRepository;

import java.util.UUID;

@Component
@Transactional
public class DeleteTicketByUidUseCase {

    private final TicketRepository ticketRepository;

    public DeleteTicketByUidUseCase(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void execute(String ticketUid) {
        ticketRepository.deleteByTicketUid(UUID.fromString(ticketUid));
    }
}
