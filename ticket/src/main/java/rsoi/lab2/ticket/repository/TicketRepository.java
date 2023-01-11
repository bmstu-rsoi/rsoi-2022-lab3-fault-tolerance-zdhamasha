package rsoi.lab2.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rsoi.lab2.ticket.model.Ticket;

import java.util.List;
import java.util.UUID;


public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByUsername(String username);
    Ticket findByTicketUidAndUsername(UUID ticketUid, String username);
}
