package pl.biuropodrozy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.biuropodrozy.entity.Address;

@Repository
public interface AddressRepo extends CrudRepository<Address, Integer> {
}
