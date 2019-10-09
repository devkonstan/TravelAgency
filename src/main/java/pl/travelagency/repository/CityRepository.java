package pl.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.travelagency.entities.City;


import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Integer> {

    @Query(value = "SELECT * FROM CITY", nativeQuery = true)
    List<City> findAll();

    Optional<City> findCityById(Integer id);

    Optional<City> findCityByName(String name);
}
