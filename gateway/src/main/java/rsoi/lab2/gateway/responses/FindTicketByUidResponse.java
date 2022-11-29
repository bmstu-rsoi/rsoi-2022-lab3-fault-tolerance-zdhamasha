package rsoi.lab2.gateway.responses;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class FindTicketByUidResponse implements Serializable {

    private String flightNumber;
    private String ticketUid;
    private int price;
    private String status;
    private String fromAirport;
    private String toAirport;
    private Timestamp date;

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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FindTicketByUidResponse that = (FindTicketByUidResponse) o;
        return price == that.price && Objects.equals(flightNumber, that.flightNumber) && Objects.equals(ticketUid, that.ticketUid) && Objects.equals(status, that.status) && Objects.equals(fromAirport, that.fromAirport) && Objects.equals(toAirport, that.toAirport) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, ticketUid, price, status, fromAirport, toAirport, date);
    }

    @Override
    public String toString() {
        return "FindTicketByUidResponse{" +
                "flightNumber='" + flightNumber + '\'' +
                ", ticketUid='" + ticketUid + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", fromAirport='" + fromAirport + '\'' +
                ", toAirport='" + toAirport + '\'' +
                ", date=" + date +
                '}';
    }
}
