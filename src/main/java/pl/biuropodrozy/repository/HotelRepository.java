package pl.biuropodrozy.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.biuropodrozy.entity.Hotel;
import pl.biuropodrozy.entity.StarRate;

import java.util.List;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Integer> {

    @Query("SELECT u FROM Hotel u WHERE u.starRate = ?1")
    List<Hotel> findHotelByTripHotelRate(StarRate starRate);
}
