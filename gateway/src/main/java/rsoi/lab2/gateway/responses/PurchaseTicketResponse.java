package rsoi.lab2.gateway.responses;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class PurchaseTicketResponse implements Serializable {

    private String flightNumber;
    private UUID ticketUid;
    private String username;
    private Integer price;
    private String status;

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public UUID getTicketUid() {
        return ticketUid;
    }

    public void setTicketUid(UUID ticketUid) {
        this.ticketUid = ticketUid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseTicketResponse that = (PurchaseTicketResponse) o;
        return Objects.equals(flightNumber, that.flightNumber) && Objects.equals(ticketUid, that.ticketUid) && Objects.equals(username, that.username) && Objects.equals(price, that.price) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, ticketUid, username, price, status);
    }

    @Override
    public String toString() {
        return "PurchaseTicketResponse{" +
                "flightNumber='" + flightNumber + '\'' +
                ", ticketUid=" + ticketUid +
                ", username='" + username + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}
