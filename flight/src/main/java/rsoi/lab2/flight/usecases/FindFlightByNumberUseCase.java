package rsoi.lab2.flight.usecases;

import org.springframework.stereotype.Component;
import rsoi.lab2.flight.model.Flight;
import rsoi.lab2.flight.repository.AirportRepository;
import rsoi.lab2.flight.repository.FlightRepository;
import rsoi.lab2.flight.responses.FlightResponse;

@Component
public class FindFlightByNumberUseCase {

    private final AirportRepository airportRepository;
    private final FlightRepository flightRepository;


    public FindFlightByNumberUseCase(AirportRepository airportRepository, FlightRepository flightRepository) {
        this.airportRepository = airportRepository;
        this.flightRepository = flightRepository;
    }

    public FlightResponse execute(String flightNumber) {
        return mapToFlight(flightRepository.findByFlightNumber(flightNumber));
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
