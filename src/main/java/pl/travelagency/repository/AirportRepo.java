package pl.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.travelagency.entities.Airport;

@Repository
public interface AirportRepo extends JpaRepository<Airport, Integer> {
}
