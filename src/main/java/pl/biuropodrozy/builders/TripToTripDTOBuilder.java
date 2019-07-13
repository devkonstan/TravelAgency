package pl.biuropodrozy.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.biuropodrozy.DTO.TripDTO;
import pl.biuropodrozy.entity.trip.Trip;
import pl.biuropodrozy.repository.CityRepository;
import pl.biuropodrozy.repository.TripRepository;

import java.util.Optional;

@Service
public class TripToTripDTOBuilder {


    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private CityRepository cityRepository;


    public TripDTO buildDTO(Trip trip) {
        return TripDTO.builder()
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

    public Trip buildEntity(TripDTO dto) {
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
