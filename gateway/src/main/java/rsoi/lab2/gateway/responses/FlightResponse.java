package rsoi.lab2.gateway.responses;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class FlightResponse implements Serializable {

    private String flightNumber;
    private Timestamp date;
    private Integer price;
    private String fromAirport;
    private String toAirport;

    public FlightResponse() {
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Timestamp getDate() {
        return date;
    }

    public Integer getPrice() {
        return price;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightResponse that = (FlightResponse) o;
        return Objects.equals(flightNumber, that.flightNumber) && Objects.equals(date, that.date) && Objects.equals(price, that.price) && Objects.equals(fromAirport, that.fromAirport) && Objects.equals(toAirport, that.toAirport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, date, price, fromAirport, toAirport);
    }

    @Override
    public String toString() {
        return "FlightResponse{" +
                "flightNumber='" + flightNumber + '\'' +
                ", dateTime=" + date +
                ", price=" + price +
                ", fromAirportId='" + fromAirport + '\'' +
                ", toAirportId='" + toAirport + '\'' +
                '}';
    }
}
