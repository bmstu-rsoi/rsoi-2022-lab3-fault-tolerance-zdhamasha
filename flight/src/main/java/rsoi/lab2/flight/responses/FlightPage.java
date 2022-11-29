package rsoi.lab2.flight.responses;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class FlightPage implements Serializable {

    private List<FlightResponse> items;

    private int page;

    private int pageSize;

    private int totalElements;

    public FlightPage() {
    }

    public FlightPage(List<FlightResponse> items, int page, int pageSize, int totalElements) {
        this.items = items;
        this.page = page;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
    }

    public List<FlightResponse> getItems() {
        return items;
    }

    public int getPage() {
        return page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalElements() {
        return totalElements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightPage that = (FlightPage) o;
        return page == that.page && pageSize == that.pageSize && totalElements == that.totalElements && Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, page, pageSize, totalElements);
    }

    @Override
    public String toString() {
        return "FlightPage{" +
                "items=" + items +
                ", page=" + page +
                ", pageSize=" + pageSize +
                ", totalElements=" + totalElements +
                '}';
    }
}
