package rsoi.lab2.gateway.responses;

import java.io.Serializable;
import java.util.Objects;

public class PrivilegeResponse implements Serializable {

    private Long id;
    private String username;
    private String status;
    private Integer balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrivilegeResponse that = (PrivilegeResponse) o;
        return Objects.equals(username, that.username) && status == that.status && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, status, balance);
    }

    @Override
    public String toString() {
        return "PrivilegeResponse{" +
                "username='" + username + '\'' +
                ", status=" + status +
                ", balance=" + balance +
                '}';
    }
}
