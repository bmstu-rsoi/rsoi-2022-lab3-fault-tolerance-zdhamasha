package rsoi.lab2.bonus.responses;

import java.util.List;
import java.util.Objects;

public class PrivilegeResponse {

    private Long id;
    private String username;
    private String status;
    private Integer balance;
    private List<PrivilegeHistoryResponse> history;

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

    public List<PrivilegeHistoryResponse> getHistory() {
        return history;
    }

    public void setHistory(List<PrivilegeHistoryResponse> history) {
        this.history = history;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrivilegeResponse that = (PrivilegeResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(status, that.status) && Objects.equals(balance, that.balance) && Objects.equals(history, that.history);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, status, balance, history);
    }

    @Override
    public String toString() {
        return "PrivilegeResponse{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", status='" + status + '\'' +
                ", balance=" + balance +
                ", history=" + history +
                '}';
    }
}
