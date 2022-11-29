package rsoi.lab2.ticket.responses;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class FindTicketsResponse implements Serializable {

    private List<FindTicketResponse> findTicketResponseList;

    public List<FindTicketResponse> getFindTicketResponseList() {
        return findTicketResponseList;
    }

    public void setFindTicketResponseList(List<FindTicketResponse> findTicketResponseList) {
        this.findTicketResponseList = findTicketResponseList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FindTicketsResponse that = (FindTicketsResponse) o;
        return Objects.equals(findTicketResponseList, that.findTicketResponseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(findTicketResponseList);
    }

    @Override
    public String toString() {
        return "FindTicketsResponse{" +
                "findTicketResponseList=" + findTicketResponseList +
                '}';
    }
}
