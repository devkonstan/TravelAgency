package pl.biuropodrozy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.biuropodrozy.entity.City;

@Repository
public interface CityRepo extends JpaRepository<City, Integer> {
}
