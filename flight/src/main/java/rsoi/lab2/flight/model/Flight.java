package rsoi.lab2.flight.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "FLIGHT")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FLIGHT_NUMBER", nullable = false, length = 20)
    private String flightNumber;

    @Column(name = "DATE_TIME", nullable = false)
    private Timestamp dateTime;

    @Column(name = "PRICE", nullable = false)
    private Integer price;

    @Column(name = "FROM_AIRPORT_ID", nullable = false)
    private Integer fromAirportId;

    @Column(name = "TO_AIRPORT_ID", nullable = false)
    private Integer toAirportId;

    public Flight() {
    }

    public Flight(Long id, String flightNumber, Timestamp dateTime, Integer price, Integer fromAirportId, Integer toAirportId) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.dateTime = dateTime;
        this.price = price;
        this.fromAirportId = fromAirportId;
        this.toAirportId = toAirportId;
    }

    public Long getId() {
        return id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getFromAirportId() {
        return fromAirportId;
    }

    public Integer getToAirportId() {
        return toAirportId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id) && Objects.equals(flightNumber, flight.flightNumber) && Objects.equals(dateTime, flight.dateTime) && Objects.equals(price, flight.price) && Objects.equals(fromAirportId, flight.fromAirportId) && Objects.equals(toAirportId, flight.toAirportId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightNumber, dateTime, price, fromAirportId, toAirportId);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNumber='" + flightNumber + '\'' +
                ", dateTime=" + dateTime +
                ", price=" + price +
                ", fromAirportId=" + fromAirportId +
                ", toAirportId=" + toAirportId +
                '}';
    }
}
