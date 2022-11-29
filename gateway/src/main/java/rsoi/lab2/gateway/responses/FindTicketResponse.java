package rsoi.lab2.gateway.responses;

import java.io.Serializable;
import java.util.Objects;

public class FindTicketResponse implements Serializable {

    private String flightNumber;
    private String ticketUid;
    private int price;
    private String status;

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getTicketUid() {
        return ticketUid;
    }

    public void setTicketUid(String ticketUid) {
        this.ticketUid = ticketUid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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
        FindTicketResponse that = (FindTicketResponse) o;
        return price == that.price && Objects.equals(flightNumber, that.flightNumber) && Objects.equals(ticketUid, that.ticketUid) && status.equals(that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, ticketUid, price, status);
    }

    @Override
    public String toString() {
        return "FindTicketResponse{" +
                "flightNumber='" + flightNumber + '\'' +
                ", ticketUid='" + ticketUid + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
