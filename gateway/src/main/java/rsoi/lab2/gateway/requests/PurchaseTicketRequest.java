package rsoi.lab2.gateway.requests;

import java.io.Serializable;
import java.util.Objects;

public class PurchaseTicketRequest implements Serializable {

    private String flightNumber;
    private Integer price;
    private Boolean paidFromBalance;

    public PurchaseTicketRequest() {
    }

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

    public Boolean getPaidFromBalance() {
        return paidFromBalance;
    }

    public void setPaidFromBalance(Boolean paidFromBalance) {
        this.paidFromBalance = paidFromBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseTicketRequest that = (PurchaseTicketRequest) o;
        return Objects.equals(flightNumber, that.flightNumber) && Objects.equals(price, that.price) && Objects.equals(paidFromBalance, that.paidFromBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, price, paidFromBalance);
    }

    @Override
    public String toString() {
        return "PurchaseTicketRequest{" +
                "flightNumber='" + flightNumber + '\'' +
                ", price=" + price +
                ", paidFromBalance=" + paidFromBalance +
                '}';
    }
}
