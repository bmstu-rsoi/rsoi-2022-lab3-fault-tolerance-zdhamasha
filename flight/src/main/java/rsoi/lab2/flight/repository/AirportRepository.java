package rsoi.lab2.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rsoi.lab2.flight.model.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer> {

}
