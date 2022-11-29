package rsoi.lab2.ticket.requests;

import java.io.Serializable;
import java.util.Objects;

public class PurchaseTicketRequest implements Serializable {

    private String flightNumber;
    private Integer price;
    private String username;

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseTicketRequest that = (PurchaseTicketRequest) o;
        return Objects.equals(flightNumber, that.flightNumber) && Objects.equals(price, that.price) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, price, username);
    }

    @Override
    public String toString() {
        return "PurchaseTicketRequest{" +
                "flightNumber='" + flightNumber + '\'' +
                ", price=" + price +
                ", username='" + username + '\'' +
                '}';
    }
}
