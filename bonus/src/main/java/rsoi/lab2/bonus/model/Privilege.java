package rsoi.lab2.bonus.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRIVILEGE")
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "USERNAME", nullable = false, length = 80)
    private String username;

    @Column(name = "STATUS", nullable = false, length = 80)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "BALANCE")
    private Integer balance;

    public Privilege() {
    }

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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
        Privilege privilege = (Privilege) o;
        return Objects.equals(id, privilege.id) && Objects.equals(username, privilege.username) && status == privilege.status && Objects.equals(balance, privilege.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, status, balance);
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", status=" + status +
                ", balance=" + balance +
                '}';
    }
}
