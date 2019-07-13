package pl.biuropodrozy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.biuropodrozy.entity.trip.Catering;
import pl.biuropodrozy.entity.trip.Trip;
import pl.biuropodrozy.repository.TripRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TripService {

    private TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    public void addTrip(Trip trip) {
        tripRepository.save(trip);
    }

    public List<Trip> multipleTripFilter(String fromLocation,
                                         String destinyLocation,
                                         LocalDate start, LocalDate end) {
        List<Trip> tripList = new ArrayList<>();
        tripList.addAll(tripRepository.multipleTripFilter(fromLocation, destinyLocation, start, end));
        return tripList;
    }

    @PostConstruct
    private void mockData() {
        addTrip(new Trip("Gdańsk", "Mallorca", LocalDate.now(), LocalDate.now().plusDays(7), Catering.AI, 1500.0, 1400.0, false));
        addTrip(new Trip("Kraków", "Kreta", LocalDate.now(), LocalDate.now().plusDays(14), Catering.BB, 2500.0, 2200.0, true));
        addTrip(new Trip("Goleniów", "Kukesi", LocalDate.now().plusDays(10), LocalDate.now().plusDays(17), Catering.HB, 1800.0, 1400.0, false));
    }

}
