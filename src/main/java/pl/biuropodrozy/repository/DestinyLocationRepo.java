package pl.biuropodrozy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinyLocationRepo extends CrudRepository<DestinyLocation, Integer> {
}
