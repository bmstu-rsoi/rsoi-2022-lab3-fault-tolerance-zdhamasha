package rsoi.lab2.flight.usecases;

import org.springframework.stereotype.Component;
import rsoi.lab2.flight.model.Flight;
import rsoi.lab2.flight.repository.AirportRepository;
import rsoi.lab2.flight.repository.FlightRepository;
import rsoi.lab2.flight.responses.FlightResponse;
import rsoi.lab2.flight.responses.FlightsResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindAllFlightsUseCase {

    private final AirportRepository airportRepository;
    private final FlightRepository flightRepository;


    public FindAllFlightsUseCase(AirportRepository airportRepository, FlightRepository flightRepository) {
        this.airportRepository = airportRepository;
        this.flightRepository = flightRepository;
    }

    public FlightsResponse execute() {
        List<FlightResponse> flights = flightRepository.findAll()
                .stream()
                .map(this::mapToFlightsResponse)
                .collect(Collectors.toList());

        FlightsResponse response = new FlightsResponse();
        response.setFlightResponseList(new ArrayList<>(flights));

        return response;
    }

    private FlightResponse mapToFlightsResponse(Flight flight) {
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
