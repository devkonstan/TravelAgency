package pl.biuropodrozy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.biuropodrozy.entity.Country;

@Repository
public interface CountryRepo extends CrudRepository<Country, Integer> {
}
