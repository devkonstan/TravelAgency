package pl.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.travelagency.entities.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {
}
