package rsoi.lab2.flight.usecases;

import org.springframework.stereotype.Component;
import rsoi.lab2.flight.repository.FlightRepository;

@Component
public class FlightExistenceUseCase {

    private final FlightRepository flightRepository;

    public FlightExistenceUseCase(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Boolean execute(String flightNumber) {
        return flightRepository.existsByFlightNumber(flightNumber);
    }
}
