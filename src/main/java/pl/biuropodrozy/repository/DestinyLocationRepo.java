package pl.biuropodrozy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.biuropodrozy.entity.Trip.DestinyLocation;

@Repository
public interface DestinyLocationRepo extends CrudRepository<DestinyLocation, Integer> {
}
