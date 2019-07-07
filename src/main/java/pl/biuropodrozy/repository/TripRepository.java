package pl.biuropodrozy.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.biuropodrozy.entity.Trip.Catering;
import pl.biuropodrozy.entity.Trip.DestinyLocation;
import pl.biuropodrozy.entity.Trip.FromLocation;
import pl.biuropodrozy.entity.Trip.Trip;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TripRepository extends CrudRepository<Trip, Integer> {

    @Query(value = "SELECT * FROM TRIP", nativeQuery = true)
    List<Trip> findAll();

    @Query(value = "SELECT u FROM Trip u WHERE u.destinyLocation = ?1")
    List<Trip> findTripByDestinyLocation(DestinyLocation destinyLocation);

    @Query("SELECT u FROM Trip u WHERE u.fromLocation = ?1")
    List<Trip> findTripByDeparture(FromLocation fromLocation);

    @Query("SELECT u FROM Trip u WHERE u.startDate = ?1")
    List<Trip> findTripByDepartureDate(LocalDate localDate);

    @Query("SELECT u FROM Trip u WHERE u.endDate = ?1")
    List<Trip> findTripByArrivalDate(LocalDate localDate);

    @Query("SELECT u FROM Trip u WHERE u.catering = ?1")
    List<Trip> findTripByType(Catering catering);

    @Query("SELECT u FROM Trip u WHERE u.startDate = ?1 and u.endDate = ?2")
    List<Trip> findTripByDays(LocalDate departure, LocalDate homecoming);

    @Query("SELECT u FROM Trip u WHERE u.fromLocation = ?1 and u.destinyLocation = ?2 and u.startDate = ?3 and u.endDate = ?4")
    List<Trip> multipleTripFilter(FromLocation fromLocation, DestinyLocation destinyLocation, LocalDate start, LocalDate end);
}
