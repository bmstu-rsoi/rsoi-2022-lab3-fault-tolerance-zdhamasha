package rsoi.lab2.bonus.requests;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class AddPrivilegeHistoryRequest implements Serializable {

    private Long privilegeId;
    private UUID ticket_uid;
    private Integer balanceDiff;

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

    public Integer getBalanceDiff() {
        return balanceDiff;
    }

    public void setBalanceDiff(Integer balanceDiff) {
        this.balanceDiff = balanceDiff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddPrivilegeHistoryRequest that = (AddPrivilegeHistoryRequest) o;
        return Objects.equals(privilegeId, that.privilegeId) && Objects.equals(ticket_uid, that.ticket_uid) && Objects.equals(balanceDiff, that.balanceDiff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(privilegeId, ticket_uid, balanceDiff);
    }

    @Override
    public String toString() {
        return "AddPrivilegeHistoryRequest{" +
                "privilegeId=" + privilegeId +
                ", ticket_uid=" + ticket_uid +
                ", balanceDiff=" + balanceDiff +
                '}';
    }
}
