package pl.biuropodrozy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.biuropodrozy.entity.City;

@Repository
public interface CityRepo extends CrudRepository<City, Integer> {
}
