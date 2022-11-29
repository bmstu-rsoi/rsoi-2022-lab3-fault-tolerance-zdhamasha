package rsoi.lab2.flight.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rsoi.lab2.flight.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Override
    Page<Flight> findAll(Pageable pageable);

    Flight findByFlightNumber(String flightNumber);

    boolean existsByFlightNumber(String flightNumber);
}
