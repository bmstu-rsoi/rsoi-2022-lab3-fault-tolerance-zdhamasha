package rsoi.lab2.gateway.responses;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class FindAllUserTicketsResponse implements Serializable {

    private String flightNumber;
    private String ticketUid;
    private String status;
    private Timestamp date;
    private Integer price;
    private String fromAirport;
    private String toAirport;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FindAllUserTicketsResponse that = (FindAllUserTicketsResponse) o;
        return Objects.equals(flightNumber, that.flightNumber) && Objects.equals(ticketUid, that.ticketUid) && Objects.equals(status, that.status) && Objects.equals(date, that.date) && Objects.equals(price, that.price) && Objects.equals(fromAirport, that.fromAirport) && Objects.equals(toAirport, that.toAirport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, ticketUid, status, date, price, fromAirport, toAirport);
    }

    @Override
    public String toString() {
        return "FindAllUserTicketsResponse{" +
                "flightNumber='" + flightNumber + '\'' +
                ", ticketUid='" + ticketUid + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                ", price=" + price +
                ", fromAirport='" + fromAirport + '\'' +
                ", toAirport='" + toAirport + '\'' +
                '}';
    }
}
