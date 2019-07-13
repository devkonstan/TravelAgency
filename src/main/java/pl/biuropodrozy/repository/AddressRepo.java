package pl.biuropodrozy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.biuropodrozy.entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {
}
