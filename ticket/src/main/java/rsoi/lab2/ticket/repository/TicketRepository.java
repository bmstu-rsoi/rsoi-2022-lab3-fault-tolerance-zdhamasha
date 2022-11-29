package rsoi.lab2.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rsoi.lab2.ticket.model.Ticket;

import java.util.List;
import java.util.UUID;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Ticket findByTicketUid(UUID ticketUid);

    List<Ticket> findAllByUsername(String username);

    void deleteByTicketUid(UUID ticketUid);
}
