package pl.travelagency.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.travelagency.dto.CityDto;
import pl.travelagency.entities.City;
import pl.travelagency.repository.CityRepository;

@Service
public class CityToCityBuilder {

    @Autowired
    private CityRepository cityRepository;


    public CityDto buildDTO(City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .airport(city.getAirport())
                .country(city.getCountry())
                .build();
    }

    public City buildEntity(CityDto dto) {
        City city;
        if (dto.getId() == null) {
            city = new City();
        } else {
            city = cityRepository.getOne(dto.getId());
        }

        city.setName(dto.getName());
        city.setAirport(dto.getAirport());
        city.setCountry(dto.getCountry());

        return city;
    }
}
