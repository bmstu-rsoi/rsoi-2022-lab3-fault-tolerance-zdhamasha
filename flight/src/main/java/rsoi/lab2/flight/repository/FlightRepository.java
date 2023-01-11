package rsoi.lab2.flight.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import rsoi.lab2.flight.model.Flight;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    Page<Flight> findAll(Pageable pageable);
    List<Flight> findAll();
    Flight findByFlightNumber(String flightNumber);
}
