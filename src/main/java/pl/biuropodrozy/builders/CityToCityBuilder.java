package pl.biuropodrozy.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.biuropodrozy.DTO.CityDTO;
import pl.biuropodrozy.entity.City;
import pl.biuropodrozy.repository.CityRepository;

@Service
public class CityToCityBuilder {

    @Autowired
    private CityRepository cityRepository;


    public CityDTO buildDTO(City city) {
        return CityDTO.builder()
                .id(city.getId())
                .name(city.getName())
                .airport(city.getAirport())
                .country(city.getCountry())
                .build();
    }

    public City buildEntity(CityDTO dto) {
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
