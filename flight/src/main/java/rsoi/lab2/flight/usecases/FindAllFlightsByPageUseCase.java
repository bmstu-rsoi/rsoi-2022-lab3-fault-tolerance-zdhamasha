package rsoi.lab2.flight.usecases;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import rsoi.lab2.flight.model.Flight;
import rsoi.lab2.flight.repository.AirportRepository;
import rsoi.lab2.flight.repository.FlightRepository;
import rsoi.lab2.flight.responses.FlightResponse;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindAllFlightsByPageUseCase {

    private final AirportRepository airportRepository;
    private final FlightRepository flightRepository;


    public FindAllFlightsByPageUseCase(AirportRepository airportRepository, FlightRepository flightRepository) {
        this.airportRepository = airportRepository;
        this.flightRepository = flightRepository;
    }

    public List<FlightResponse> execute(PageRequest request) {
        return flightRepository.findAll(PageRequest.of(request.getPageNumber() - 1, request.getPageSize()))
                .stream()
                .map(this::mapToFlight)
                .collect(Collectors.toList());
    }

    private FlightResponse mapToFlight(Flight flight) {
        FlightResponse flightResponse = new FlightResponse();

        flightResponse.setFlightNumber(flight.getFlightNumber());
        flightResponse.setDate(flight.getDateTime());
        flightResponse.setPrice(flight.getPrice());
        flightResponse.setFromAirport(getAirportName(flight.getFromAirportId()));
        flightResponse.setToAirport(getAirportName(flight.getToAirportId()));

        return flightResponse;
    }

    private String getAirportName(Integer airportId) {
        return airportRepository.findById(airportId).orElseThrow(IllegalArgumentException::new)
                .getName();
    }
}
