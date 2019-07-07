package pl.biuropodrozy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import pl.biuropodrozy.entity.*;
import pl.biuropodrozy.entity.Trip.Catering;
import pl.biuropodrozy.entity.Trip.DestinyLocation;
import pl.biuropodrozy.entity.Trip.FromLocation;
import pl.biuropodrozy.entity.Trip.Trip;
import pl.biuropodrozy.repository.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Controller
public class DataBaseStarter {

    private TripRepository tripRepository;
    private FromLocationRepo fromLocationRepo;
    private DestinyLocationRepo destinyLocationRepo;
    private CityRepo cityRepo;
    private AirportRepo airportRepo;
    private AddressRepo addressRepo;
    private HotelRepository hotelRepository;

    @Autowired
    public DataBaseStarter(TripRepository tripRepository, FromLocationRepo fromLocationRepo,
                           DestinyLocationRepo destinyLocationRepo, CityRepo cityRepo,
                           AirportRepo airportRepo, AddressRepo addressRepo, HotelRepository hotelRepository) {
        this.tripRepository = tripRepository;
        this.fromLocationRepo = fromLocationRepo;
        this.destinyLocationRepo = destinyLocationRepo;
        this.cityRepo = cityRepo;
        this.airportRepo = airportRepo;
        this.addressRepo = addressRepo;
        this.hotelRepository = hotelRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void test() {
        cityOne();
    }

    public void cityOne() {
        Address addressCity = new Address("Wojska Polskiego", "70-780", 21, 14);
        Address addressAirport = new Address("Poniatowskiego", "80-200", 12, 90);
        Address addressToCity = new Address("Palma", "8HC32", 12, 33);
        Address addressToAirport = new Address("Palma Mallorca", "3VG37", 1, 3);
        addressRepo.save(addressCity);
        addressRepo.save(addressAirport);
        addressRepo.save(addressToCity);
        addressRepo.save(addressToAirport);

        Hotel hotel = new Hotel("Perla", StarRate.FOUR, "To jest bardzo fajny hotel.");
        Set<Hotel> hotels = new HashSet<>();
        hotelRepository.save(hotel);

        Airport airport = new Airport("Lotnisko Centralne", addressAirport);
        Airport airportTo = new Airport("Palma de Mallorca", addressToAirport);
        airportRepo.save(airport);
        airportRepo.save(airportTo);

        City cityFrom = new City("Kraków", addressCity, airport);
        City cityTo = new City("Mallorca", addressToCity, hotels, airportTo);
        cityRepo.save(cityFrom);
        cityRepo.save(cityTo);


        FromLocation location = new FromLocation(cityFrom, airport);
        fromLocationRepo.save(location);

        DestinyLocation destinyLocation = new DestinyLocation(cityTo, hotel, airportTo);
        destinyLocationRepo.save(destinyLocation);
        Trip trip = new Trip(location, destinyLocation, LocalDate.now(), LocalDate.now(), Catering.HB, 1500.0, 1400.0, false, 1, 1);
        tripRepository.save(trip);
    }
}
