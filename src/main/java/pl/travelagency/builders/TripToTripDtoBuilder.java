package pl.travelagency.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.travelagency.dto.TripDto;
import pl.travelagency.entities.trip.Trip;
import pl.travelagency.repository.CityRepository;
import pl.travelagency.repository.TripRepository;

import java.util.Optional;

@Service
public class TripToTripDtoBuilder {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private CityRepository cityRepository;

    public TripDto buildDTO(Trip trip) {
        return TripDto.builder()
                .id(trip.getId())
                .catering(trip.getCatering())
                .fromLocationID(Optional.ofNullable(trip.getFromLocation()).map(c -> c.getId()).orElse(null))
                .destinyLocationID(Optional.ofNullable(trip.getDestinyLocation()).map(c -> c.getId()).orElse(null))
                .startDate(trip.getStartDate())
                .endDate(trip.getEndDate())
                .priceForAdult(trip.getPriceForAdult())
                .priceForChild(trip.getPriceForChild())
                .promoted(trip.isPromoted())
                .build();
    }

    public Trip buildEntity(TripDto dto) {
        Trip trip;
        if (dto.getId() == null) {
            trip = new Trip();
        } else {
            trip = tripRepository.getOne(dto.getId());
        }

        trip.setCatering(dto.getCatering());
        trip.setFromLocation(Optional.ofNullable(dto.getFromLocationID()).map(cityRepository::getOne).orElse(null));
        trip.setDestinyLocation(Optional.ofNullable(dto.getDestinyLocationID()).map(cityRepository::getOne).orElse(null));
        trip.setStartDate(dto.getStartDate());
        trip.setEndDate(dto.getEndDate());
        trip.setPriceForAdult(dto.getPriceForAdult());
        trip.setPriceForChild(dto.getPriceForChild());
        trip.setPromoted(dto.isPromoted());

        return trip;
    }
}
