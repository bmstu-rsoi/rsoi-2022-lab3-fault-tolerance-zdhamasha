package rsoi.lab2.bonus.responses;

import java.io.Serializable;
import java.util.List;

public class PrivilegeHistoryListResponse implements Serializable {

    private List<PrivilegeHistoryResponse> historyList;

    public List<PrivilegeHistoryResponse> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<PrivilegeHistoryResponse> historyList) {
        this.historyList = historyList;
    }
}
