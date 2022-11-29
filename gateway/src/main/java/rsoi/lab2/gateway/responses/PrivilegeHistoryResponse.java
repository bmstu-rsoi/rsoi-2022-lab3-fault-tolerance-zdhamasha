package rsoi.lab2.gateway.responses;

import java.io.Serializable;

public class PrivilegeHistoryResponse implements Serializable {

    private String ticketUid;

    public String getTicketUid() {
        return ticketUid;
    }

    public void setTicketUid(String ticketUid) {
        this.ticketUid = ticketUid;
    }
}
