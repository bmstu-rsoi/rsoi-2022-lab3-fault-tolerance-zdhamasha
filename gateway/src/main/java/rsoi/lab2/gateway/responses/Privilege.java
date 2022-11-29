package rsoi.lab2.gateway.responses;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Privilege implements Serializable {

    private Long id;
    private int balance;
    private String status;
    private List<PrivilegeHistoryResponse> history;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PrivilegeHistoryResponse> getHistory() {
        return history;
    }

    public void setHistory(List<PrivilegeHistoryResponse> history) {
        this.history = history;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Privilege privilege = (Privilege) o;
        return balance == privilege.balance && Objects.equals(id, privilege.id) && Objects.equals(status, privilege.status) && Objects.equals(history, privilege.history);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, status, history);
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "id=" + id +
                ", balance=" + balance +
                ", status='" + status + '\'' +
                ", history=" + history +
                '}';
    }
}
