package pl.biuropodrozy.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.biuropodrozy.DTO.TripDTO;
import pl.biuropodrozy.entity.trip.Trip;
import pl.biuropodrozy.repository.TripRepository;

@Service
public class TripToTripDTOBuilder {


    @Autowired
    private TripRepository tripRepository;


    public TripDTO buildDTO(Trip trip) {
        return TripDTO.builder()
                .id(trip.getId())
                .catering(trip.getCatering())
                .destinyLocation(trip.getDestinyLocation())
                .fromLocation(trip.getFromLocation())
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
        trip.setFromLocation(dto.getFromLocation());
        trip.setDestinyLocation(dto.getDestinyLocation());
        trip.setStartDate(dto.getStartDate());
        trip.setEndDate(dto.getEndDate());
        trip.setPriceForAdult(dto.getPriceForAdult());
        trip.setPriceForChild(dto.getPriceForChild());
        trip.setPromoted(dto.isPromoted());

        return trip;
    }
}
