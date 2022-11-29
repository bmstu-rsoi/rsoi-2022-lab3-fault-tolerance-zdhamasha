package rsoi.lab2.bonus.requests;

import java.io.Serializable;
import java.util.Objects;

public class UpdatePrivilegeBalanceRequest implements Serializable {

    private String username;
    private Integer creditedTicketAmount;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCreditedTicketAmount() {
        return creditedTicketAmount;
    }

    public void setCreditedTicketAmount(Integer creditedTicketAmount) {
        this.creditedTicketAmount = creditedTicketAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdatePrivilegeBalanceRequest that = (UpdatePrivilegeBalanceRequest) o;
        return Objects.equals(username, that.username) && Objects.equals(creditedTicketAmount, that.creditedTicketAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, creditedTicketAmount);
    }

    @Override
    public String toString() {
        return "UpdatePrivilegeBalanceRequest{" +
                "username='" + username + '\'' +
                ", creditedTicketAmount=" + creditedTicketAmount +
                '}';
    }
}
