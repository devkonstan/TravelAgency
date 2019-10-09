package pl.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.travelagency.entities.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer> {
}
