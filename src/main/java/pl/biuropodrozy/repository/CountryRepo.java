package pl.biuropodrozy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.biuropodrozy.entity.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer> {
}
