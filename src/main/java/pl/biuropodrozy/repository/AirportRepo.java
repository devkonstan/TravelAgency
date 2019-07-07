package pl.biuropodrozy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.biuropodrozy.entity.Airport;

@Repository
public interface AirportRepo extends CrudRepository<Airport, Integer> {
}
