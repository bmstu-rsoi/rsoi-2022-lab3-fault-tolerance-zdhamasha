package rsoi.lab2.gateway.responses;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class FlightsResponse implements Serializable {

    private List<FlightResponse> flightResponseList;

    public List<FlightResponse> getFlightResponseList() {
        return flightResponseList;
    }

    public void setFlightResponseList(List<FlightResponse> flightResponseList) {
        this.flightResponseList = flightResponseList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightsResponse that = (FlightsResponse) o;
        return Objects.equals(flightResponseList, that.flightResponseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightResponseList);
    }

    @Override
    public String toString() {
        return "FlightsResponse{" +
                "flightResponseList=" + flightResponseList +
                '}';
    }
}
