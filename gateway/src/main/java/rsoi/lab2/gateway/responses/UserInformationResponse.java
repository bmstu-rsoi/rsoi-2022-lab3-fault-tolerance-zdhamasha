package rsoi.lab2.gateway.responses;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class UserInformationResponse implements Serializable {

    private List<FindAllUserTicketsResponse> tickets;
    private Privilege privilege;

    public List<FindAllUserTicketsResponse> getTickets() {
        return tickets;
    }

    public void setTickets(List<FindAllUserTicketsResponse> tickets) {
        this.tickets = tickets;
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
        UserInformationResponse that = (UserInformationResponse) o;
        return Objects.equals(tickets, that.tickets) && Objects.equals(privilege, that.privilege);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tickets, privilege);
    }

    @Override
    public String toString() {
        return "UserInformationResponse{" +
                "tickets=" + tickets +
                ", privilege=" + privilege +
                '}';
    }
}
