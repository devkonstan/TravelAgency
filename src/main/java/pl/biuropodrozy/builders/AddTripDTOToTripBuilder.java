package pl.biuropodrozy.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.biuropodrozy.DTO.AddTripDTO;
import pl.biuropodrozy.DTO.TripDTO;
import pl.biuropodrozy.entity.trip.Catering;
import pl.biuropodrozy.entity.trip.Trip;
import pl.biuropodrozy.services.CityService;
import pl.biuropodrozy.services.TripService;

import java.time.LocalDate;

@Service
public class AddTripDTOToTripBuilder {

    @Autowired
    private TripService tripService;

    @Autowired
    private CityService cityService;

    public Trip buildTrip(AddTripDTO addTripDTO) {
        return Trip.builder()
                .fromLocation(cityService.findCityByName(addTripDTO.getFromLocation()).get())
                .destinyLocation(cityService.findCityByName(addTripDTO.getDestinyLocation()).get())
                .catering(Catering.valueOf(addTripDTO.getCatering()))
                .startDate(LocalDate.parse(addTripDTO.getStartDate()))
                .endDate(LocalDate.parse(addTripDTO.getEndDate()))
                .priceForAdult(addTripDTO.getPriceForAdult())
                .priceForChild(addTripDTO.getPriceForChild())
                .promoted(addTripDTO.isPromoted())
                .build();
    }


}