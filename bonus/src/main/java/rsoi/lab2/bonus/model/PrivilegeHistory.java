package rsoi.lab2.bonus.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "PRIVILEGE_HISTORY")
public class PrivilegeHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PRIVILEGE_ID")
    private Long privilegeId;

    @Column(name = "TICKET_UID", nullable = false)
    private UUID ticket_uid;

    @Column(name = "DATETIME", nullable = false)
    private Timestamp datetime;

    @Column(name = "BALANCE_DIFF", nullable = false)
    private Integer balanceDiff;

    @Column(name = "OPERATION_TYPE", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private OperationType operationType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
    }

    public UUID getTicket_uid() {
        return ticket_uid;
    }

    public void setTicket_uid(UUID ticket_uid) {
        this.ticket_uid = ticket_uid;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public Integer getBalanceDiff() {
        return balanceDiff;
    }

    public void setBalanceDiff(Integer balanceDiff) {
        this.balanceDiff = balanceDiff;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrivilegeHistory that = (PrivilegeHistory) o;
        return Objects.equals(id, that.id) && Objects.equals(privilegeId, that.privilegeId) && Objects.equals(ticket_uid, that.ticket_uid) && Objects.equals(datetime, that.datetime) && Objects.equals(balanceDiff, that.balanceDiff) && operationType == that.operationType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, privilegeId, ticket_uid, datetime, balanceDiff, operationType);
    }

    @Override
    public String toString() {
        return "PrivilegeHistory{" +
                "id=" + id +
                ", privilegeId=" + privilegeId +
                ", ticket_uid=" + ticket_uid +
                ", datetime=" + datetime +
                ", balanceDiff=" + balanceDiff +
                ", operationType=" + operationType +
                '}';
    }
}
