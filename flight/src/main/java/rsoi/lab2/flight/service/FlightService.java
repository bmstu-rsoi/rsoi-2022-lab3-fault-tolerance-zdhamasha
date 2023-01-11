package rsoi.lab2.flight.service;

import org.springframework.data.domain.Page;
import rsoi.lab2.flight.model.Flight;
import rsoi.lab2.flight.api.response.FlightResponse;

import java.util.List;

public interface FlightService {
    Page<Flight> getAllToPage(int page, int size);

    Page<Flight> findPaginated(int page, int size);
    List<Flight> getAll();

    List<FlightResponse> make(List<Flight> pageFlights);

    boolean isExistByFlightNumber(String flightNumber);
    Flight getByFlightNumber(String flightNumber);

    FlightResponse toFlightResponse(Flight flight);
}
