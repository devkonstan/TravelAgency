package pl.biuropodrozy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.biuropodrozy.entity.City;
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
    private CityService cityService;

    @Autowired
    public TripService(TripRepository tripRepository, CityService cityService) {
        this.tripRepository = tripRepository;
        this.cityService = cityService;
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
        City gdansk = new City("Gdańsk", "Lech Walesa", "Polska");
        City mallorca = new City("Mallorca", "Palma", "Spain");
        City krakow = new City("Kraków", "Jan Pawel II", "Polska");
        City heraklion = new City("Heraklion", "Nikos Kazandzakis", "Grecja");
        City goleniow = new City("Goleniów", "NSZZ Solidarność", "Polska");
        City kukesi = new City("Kukesi", "Zayed bin Sultan Al Nahyan", "Albania");
        cityService.addCity(gdansk);
        cityService.addCity(mallorca);
        cityService.addCity(krakow);
        cityService.addCity(heraklion);
        cityService.addCity(goleniow);
        cityService.addCity(kukesi);

        List<City> cityList = cityService.findAll();
        addTrip(new Trip(cityList.get(1), cityList.get(2), LocalDate.now(), LocalDate.now().plusDays(7), Catering.AI, 1500.0, 1400.0, false));
        addTrip(new Trip(cityService.findCityById(3).get(),cityService.findCityById(4).get(), LocalDate.now(), LocalDate.now().plusDays(14), Catering.BB, 2500.0, 2200.0, true));
        addTrip(new Trip(cityService.findCityByName("gdańsk").get(),cityService.findCityByName("mallorca").get(), LocalDate.now().plusDays(10), LocalDate.now().plusDays(17), Catering.HB, 1800.0, 1400.0, false));
    }

}
