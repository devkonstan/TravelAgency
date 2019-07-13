package pl.biuropodrozy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.biuropodrozy.entity.Airport;

@Repository
public interface AirportRepo extends JpaRepository<Airport, Integer> {
}
