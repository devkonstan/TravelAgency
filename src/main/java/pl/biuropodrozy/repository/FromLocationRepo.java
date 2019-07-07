package pl.biuropodrozy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.biuropodrozy.entity.Trip.FromLocation;

@Repository
public interface FromLocationRepo extends CrudRepository<FromLocation, Integer> {
}
