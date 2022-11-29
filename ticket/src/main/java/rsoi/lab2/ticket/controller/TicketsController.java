package rsoi.lab2.ticket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rsoi.lab2.ticket.requests.PurchaseTicketRequest;
import rsoi.lab2.ticket.responses.FindTicketResponse;
import rsoi.lab2.ticket.responses.FindTicketsResponse;
import rsoi.lab2.ticket.responses.PurchaseTicketResponse;
import rsoi.lab2.ticket.usecases.DeleteTicketByUidUseCase;
import rsoi.lab2.ticket.usecases.FindAllUserTicketsUseCase;
import rsoi.lab2.ticket.usecases.FindTicketByUidUseCase;
import rsoi.lab2.ticket.usecases.PurchaseTicketUseCase;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketsController {

    private final PurchaseTicketUseCase purchaseTicketUseCase;
    private final FindTicketByUidUseCase findTicketByUidUseCase;
    private final FindAllUserTicketsUseCase findAllUserTicketsUseCase;
    private final DeleteTicketByUidUseCase deleteTicketByUidUseCase;

    public TicketsController(PurchaseTicketUseCase purchaseTicketUseCase,
                             FindTicketByUidUseCase findTicketByUidUseCase,
                             FindAllUserTicketsUseCase findAllUserTicketsUseCase,
                             DeleteTicketByUidUseCase deleteTicketByUidUseCase) {
        this.purchaseTicketUseCase = purchaseTicketUseCase;
        this.findTicketByUidUseCase = findTicketByUidUseCase;
        this.findAllUserTicketsUseCase = findAllUserTicketsUseCase;
        this.deleteTicketByUidUseCase = deleteTicketByUidUseCase;
    }

    @PostMapping()
    public ResponseEntity<PurchaseTicketResponse> createTicket(@RequestBody PurchaseTicketRequest request) {
        return ResponseEntity.ok(purchaseTicketUseCase.execute(request));
    }

    @GetMapping("/{ticketUid}")
    public ResponseEntity<FindTicketResponse> findTicketByUid(@PathVariable("ticketUid") String ticketUid) {
        return ResponseEntity.ok(findTicketByUidUseCase.execute(ticketUid));
    }

    @GetMapping()
    public ResponseEntity<FindTicketsResponse> findAllUserTickets(@RequestHeader("X-User-Name") String username) {
        return ResponseEntity.ok(findAllUserTicketsUseCase.execute(username));
    }

    @DeleteMapping("{ticketUid}")
    public void deleteTicket(@PathVariable("ticketUid") String ticketUid) {
        deleteTicketByUidUseCase.execute(ticketUid);
    }
}
