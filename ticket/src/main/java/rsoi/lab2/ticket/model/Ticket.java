package rsoi.lab2.ticket.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "TICKET")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FLIGHT_NUMBER", nullable = false, length = 20)
    private String flightNumber;

    @Column(name = "TICKET_UID")
    private UUID ticketUid;

    @Column(name = "USERNAME", nullable = false, length = 80)
    private String username;

    @Column(name = "PRICE", nullable = false)
    private int price;

    @Column(name = "STATUS", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Status status;

    public UUID getTicketUid() {
        return ticketUid;
    }

    public void setTicketUid(UUID ticketUid) {
        this.ticketUid = ticketUid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return price == ticket.price && Objects.equals(id, ticket.id) && Objects.equals(flightNumber, ticket.flightNumber) && Objects.equals(ticketUid, ticket.ticketUid) && Objects.equals(username, ticket.username) && status == ticket.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightNumber, ticketUid, username, price, status);
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", flightNumber='" + flightNumber + '\'' +
                ", ticketUid=" + ticketUid +
                ", username='" + username + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}
