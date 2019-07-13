package pl.biuropodrozy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import pl.biuropodrozy.entity.trip.Catering;
import pl.biuropodrozy.entity.trip.Trip;
import pl.biuropodrozy.services.TripService;

import java.time.LocalDate;


public class DataBaseStarter {

    @Autowired
    private TripService tripService;


    public DataBaseStarter(TripService tripService) {
        this.tripService = tripService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void test() {
        tripService.addTrip(new Trip("Gdańsk", "Mallorca", LocalDate.now(), LocalDate.now().plusDays(7), Catering.AI, 1500.0, 1400.0, false));
        tripService.addTrip(new Trip("Kraków", "Kreta", LocalDate.now(), LocalDate.now().plusDays(14), Catering.BB, 2500.0, 2200.0, true));
        tripService.addTrip(new Trip("Goleniów", "Kukesi", LocalDate.now().plusDays(10), LocalDate.now().plusDays(17), Catering.HB, 1800.0, 1400.0, false));
    }

}
