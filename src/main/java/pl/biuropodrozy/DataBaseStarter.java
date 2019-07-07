package pl.biuropodrozy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import pl.biuropodrozy.entity.*;
import pl.biuropodrozy.entity.trip.Catering;
import pl.biuropodrozy.entity.trip.DestinyLocation;
import pl.biuropodrozy.entity.trip.FromLocation;
import pl.biuropodrozy.entity.trip.Trip;
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
    private CountryRepo countryRepo;

    @Autowired
    public DataBaseStarter(TripRepository tripRepository, FromLocationRepo fromLocationRepo,
                           DestinyLocationRepo destinyLocationRepo, CityRepo cityRepo,
                           AirportRepo airportRepo, AddressRepo addressRepo, HotelRepository hotelRepository, CountryRepo countryRepo) {
        this.tripRepository = tripRepository;
        this.fromLocationRepo = fromLocationRepo;
        this.destinyLocationRepo = destinyLocationRepo;
        this.cityRepo = cityRepo;
        this.airportRepo = airportRepo;
        this.addressRepo = addressRepo;
        this.hotelRepository = hotelRepository;
        this.countryRepo = countryRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void test() {
        cityOne();
        cityFour();
        cityFive();
    }

    private void cityOne() {
        Address addressAirport = new Address("Poniatowskiego", "80-200",90);
        Address addressToHotel = new Address("Palma", "8HC32",33);
        Address addressToAirport = new Address("Palma Mallorca", "3VG37", 3);
        addressRepo.save(addressAirport);
        addressRepo.save(addressToHotel);
        addressRepo.save(addressToAirport);

        Hotel hotel = new Hotel("Perla", StarRate.FOUR, "To jest bardzo fajny hotel.", addressToHotel);
        Set<Hotel> hotels = new HashSet<>();
        hotelRepository.save(hotel);

        Airport airport = new Airport("Lotnisko Centralne", addressAirport);
        Airport airportTo = new Airport("Palma de Mallorca", addressToAirport);
        airportRepo.save(airport);
        airportRepo.save(airportTo);

        Country country = new Country("Mallorca");
        countryRepo.save(country);

        City cityFrom = new City("Kraków", airport);
        City cityTo = new City("Mallorca", hotels, airportTo, country);
        cityRepo.save(cityFrom);
        cityRepo.save(cityTo);

        FromLocation location = new FromLocation(cityFrom, airport);
        fromLocationRepo.save(location);

        DestinyLocation destinyLocation = new DestinyLocation(cityTo, hotel, airportTo);
        destinyLocationRepo.save(destinyLocation);
        Trip trip = new Trip(location, destinyLocation, LocalDate.now(), LocalDate.now(), Catering.HB, 1500.0, 1400.0, false);
        tripRepository.save(trip);
    }

    private void cityFour() {
        Address addressAirport = new Address("Ciechanowskiego", "21-300",56);
        Address addressToHotel = new Address("Kostas", "458V", 33);
        Address addressToAirport = new Address("AiportStreet", "789V5", 8);
        addressRepo.save(addressAirport);
        addressRepo.save(addressToHotel);
        addressRepo.save(addressToAirport);

        Hotel hotel = new Hotel("Georgia", StarRate.THREE, "Bardzo dobre wyposażenie.", addressToHotel);
        Set<Hotel> hotels = new HashSet<>();
        hotelRepository.save(hotel);

        Airport airport = new Airport("Lotnisko Kaczynskiego", addressAirport);
        Airport airportTo = new Airport("Kostas Brawas Airport", addressToAirport);
        airportRepo.save(airport);
        airportRepo.save(airportTo);

        Country country = new Country("Grecja");
        countryRepo.save(country);

        City cityFrom = new City("Wrocław", airport);
        City cityTo = new City("Rodos", hotels, airportTo, country);
        cityRepo.save(cityFrom);
        cityRepo.save(cityTo);

        FromLocation location = new FromLocation(cityFrom, airport);
        fromLocationRepo.save(location);

        DestinyLocation destinyLocation = new DestinyLocation(cityTo, hotel, airportTo);
        destinyLocationRepo.save(destinyLocation);
        Trip trip = new Trip(location, destinyLocation, LocalDate.now(), LocalDate.now(), Catering.FB, 1950.0, 1780.99, false);
        tripRepository.save(trip);
    }

    private void cityFive() {
        Address addressAirport = new Address("Ciechanowskiego", "21-300",56);
        Address addressToHotel = new Address("Kostas", "458V", 78);
        Address addressToAirport = new Address("AiportStreet", "789V5", 5);
        addressRepo.save(addressAirport);
        addressRepo.save(addressToHotel);
        addressRepo.save(addressToAirport);

        Hotel hotel = new Hotel("Larimar", StarRate.FIVE, "Zajebisty hotel.", addressToHotel);
        Set<Hotel> hotels = new HashSet<>();
        hotelRepository.save(hotel);

        Airport airport = new Airport("Lotnisko Kaczynskiego", addressAirport);
        Airport airportTo = new Airport("Duema Fuego Airport", addressToAirport);
        airportRepo.save(airport);
        airportRepo.save(airportTo);

        Country country = new Country("Dominikana");
        countryRepo.save(country);

        City cityFrom = new City("Wrocław", airport);
        City cityTo = new City("Punta Cana", hotels, airportTo, country);
        cityRepo.save(cityFrom);
        cityRepo.save(cityTo);

        FromLocation location = new FromLocation(cityFrom, airport);
        fromLocationRepo.save(location);

        DestinyLocation destinyLocation = new DestinyLocation(cityTo, hotel, airportTo);
        destinyLocationRepo.save(destinyLocation);
        Trip trip = new Trip(location, destinyLocation, LocalDate.now(), LocalDate.now(), Catering.FB, 5650.0, 5280.99, false);
        tripRepository.save(trip);
    }
}
