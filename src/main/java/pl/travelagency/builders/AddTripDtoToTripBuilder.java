package pl.travelagency.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.travelagency.dto.AddTripDto;
import pl.travelagency.entities.trip.Catering;
import pl.travelagency.entities.trip.Trip;
import pl.travelagency.services.CityService;

import java.time.LocalDate;

@Service
public class AddTripDtoToTripBuilder {

    @Autowired
    private CityService cityService;

    public Trip buildTrip(AddTripDto addTripDTO) {
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