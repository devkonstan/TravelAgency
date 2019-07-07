package pl.biuropodrozy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.biuropodrozy.entity.trip.DestinyLocation;
import pl.biuropodrozy.entity.trip.FromLocation;
import pl.biuropodrozy.entity.trip.Trip;
import pl.biuropodrozy.repository.TripRepository;

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

    public List<Trip> multipleTripFilter(FromLocation fromLocation,
                                         DestinyLocation destinyLocation,
                                         LocalDate start, LocalDate end) {
        List<Trip> tripList = new ArrayList<>();
        tripList.addAll(tripRepository.multipleTripFilter(fromLocation, destinyLocation, start, end));
        return tripList;
    }

}
