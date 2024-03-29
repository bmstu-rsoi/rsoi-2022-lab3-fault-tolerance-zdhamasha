package rsoi.lab2.flight.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rsoi.lab2.flight.model.Flight;
import rsoi.lab2.flight.service.FlightService;
import rsoi.lab2.flight.api.response.FlightResponse;
import rsoi.lab2.flight.api.response.PaginationResponse;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/flights", produces = APPLICATION_JSON_VALUE)
public class FlightController {

    private final FlightService flightService;
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/list")
    public List<FlightResponse> getAll() {
        log.info("Fetching all flights");
        List<Flight> pageFlights = flightService.getAll();
        List<FlightResponse> flightResponseList = flightService.make(pageFlights);
        return flightResponseList;
    }
    
    @GetMapping()
    public PaginationResponse getAll(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "3") int size) {
        log.info("Fetching all flights (page)");
        Page<Flight> pageFlights = flightService.getAllToPage(page, size);
        List<FlightResponse> items = flightService.make(pageFlights.getContent());
        return new PaginationResponse(page, size, pageFlights.getTotalElements(), items);
    }

    @GetMapping("/get")
    public FlightResponse getFlightByNumber(@RequestParam String flightNumber) {
        log.info("Get flight entity: {}", flightNumber);
        Flight flight = flightService.getByFlightNumber(flightNumber);
        return flightService.toFlightResponse(flight);
    }

    @GetMapping("/isExist")
    public boolean isFlightExist(@RequestParam String flightNumber) {
        log.info("Checking flight number: {}", flightNumber);
        return flightService.isExistByFlightNumber(flightNumber);
    }
}
