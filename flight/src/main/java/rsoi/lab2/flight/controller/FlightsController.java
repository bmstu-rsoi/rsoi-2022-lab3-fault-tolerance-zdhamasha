package rsoi.lab2.flight.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rsoi.lab2.flight.responses.FlightPage;
import rsoi.lab2.flight.responses.FlightResponse;
import rsoi.lab2.flight.responses.FlightsResponse;
import rsoi.lab2.flight.usecases.FindAllFlightsByPageUseCase;
import rsoi.lab2.flight.usecases.FindAllFlightsUseCase;
import rsoi.lab2.flight.usecases.FindFlightByNumberUseCase;
import rsoi.lab2.flight.usecases.FlightExistenceUseCase;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightsController {


    private final FindAllFlightsByPageUseCase findAllFlightsByPageUseCase;
    private final FindFlightByNumberUseCase findFlightByNumberUseCase;
    private final FlightExistenceUseCase flightExistenceUseCase;
    private final FindAllFlightsUseCase findAllFlightsUseCase;

    public FlightsController(FindAllFlightsByPageUseCase findAllFlightsByPageUseCase,
                             FindFlightByNumberUseCase findFlightByNumberUseCase,
                             FlightExistenceUseCase flightExistenceUseCase,
                             FindAllFlightsUseCase findAllFlightsUseCase) {
        this.findAllFlightsByPageUseCase = findAllFlightsByPageUseCase;
        this.findFlightByNumberUseCase = findFlightByNumberUseCase;
        this.flightExistenceUseCase = flightExistenceUseCase;
        this.findAllFlightsUseCase = findAllFlightsUseCase;
    }

    @GetMapping()
    public ResponseEntity<FlightPage> findAllFlights(@RequestParam int page,
                                                     @RequestParam int size) {
        List<FlightResponse> flights = findAllFlightsByPageUseCase.execute(PageRequest.of(page, size));
        return ResponseEntity.ok(new FlightPage(flights, page, size, flights.size()));
    }

    @GetMapping("findByFlightNumber")
    public ResponseEntity<FlightResponse> findFlightByNumber(@RequestParam String flightNumber) {
        return ResponseEntity.ok(findFlightByNumberUseCase.execute(flightNumber));
    }

    @GetMapping("isExists")
    public ResponseEntity<Boolean> isFlightExist(@RequestParam String flightNumber) {
        return ResponseEntity.ok(flightExistenceUseCase.execute(flightNumber));
    }

    @GetMapping("all")
    public ResponseEntity<FlightsResponse> findAllFlights() {
        return ResponseEntity.ok(findAllFlightsUseCase.execute());
    }
}
