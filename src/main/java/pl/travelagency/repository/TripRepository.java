package pl.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.travelagency.entities.trip.Catering;
import pl.travelagency.entities.trip.Trip;

import java.time.LocalDate;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Integer> {

    @Query(value = "SELECT * FROM TRIP", nativeQuery = true)
    List<Trip> findAll();

    @Query(value = "SELECT u FROM Trip u WHERE u.destinyLocation = ?1")
    List<Trip> findTripByDestinyLocation(String destinyLocation);

    @Query("SELECT u FROM Trip u WHERE u.fromLocation = ?1")
    List<Trip> findTripByDeparture(String fromLocation);

    @Query("SELECT u FROM Trip u WHERE u.startDate = ?1")
    List<Trip> findTripByDepartureDate(LocalDate localDate);

    @Query("SELECT u FROM Trip u WHERE u.endDate = ?1")
    List<Trip> findTripByArrivalDate(LocalDate localDate);

    @Query("SELECT u FROM Trip u WHERE u.catering = ?1")
    List<Trip> findTripByType(Catering catering);

    @Query("SELECT u FROM Trip u WHERE u.startDate = ?1 and u.endDate = ?2")
    List<Trip> findTripByDays(LocalDate departure, LocalDate homecoming);

    @Query("SELECT u FROM Trip u WHERE u.fromLocation = ?1 and u.destinyLocation = ?2 and u.startDate = ?3 and u.endDate = ?4")
    List<Trip> multipleTripFilter(String fromLocation, String destinyLocation, LocalDate start, LocalDate end);
}