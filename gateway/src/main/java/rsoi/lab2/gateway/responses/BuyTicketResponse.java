package rsoi.lab2.gateway.responses;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class BuyTicketResponse implements Serializable {

    private String ticketUid;
    private String flightNumber;
    private String fromAirport;
    private String toAirport;
    private Timestamp date;
    private int price;
    private int paidByMoney;
    private int paidByBonuses;
    private String status;
    private Privilege privilege;

    public String getTicketUid() {
        return ticketUid;
    }

    public void setTicketUid(String ticketUid) {
        this.ticketUid = ticketUid;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPaidByMoney() {
        return paidByMoney;
    }

    public void setPaidByMoney(int paidByMoney) {
        this.paidByMoney = paidByMoney;
    }

    public int getPaidByBonuses() {
        return paidByBonuses;
    }

    public void setPaidByBonuses(int paidByBonuses) {
        this.paidByBonuses = paidByBonuses;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyTicketResponse that = (BuyTicketResponse) o;
        return price == that.price && paidByMoney == that.paidByMoney && paidByBonuses == that.paidByBonuses && Objects.equals(ticketUid, that.ticketUid) && Objects.equals(flightNumber, that.flightNumber) && Objects.equals(fromAirport, that.fromAirport) && Objects.equals(toAirport, that.toAirport) && Objects.equals(date, that.date) && Objects.equals(status, that.status) && Objects.equals(privilege, that.privilege);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketUid, flightNumber, fromAirport, toAirport, date, price, paidByMoney, paidByBonuses, status, privilege);
    }

    @Override
    public String toString() {
        return "BuyTicketResponse{" +
                "ticketUid='" + ticketUid + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", fromAirport='" + fromAirport + '\'' +
                ", toAirport='" + toAirport + '\'' +
                ", date=" + date +
                ", price=" + price +
                ", paidByMoney=" + paidByMoney +
                ", paidByBonuses=" + paidByBonuses +
                ", status='" + status + '\'' +
                ", privilege=" + privilege +
                '}';
    }
}
