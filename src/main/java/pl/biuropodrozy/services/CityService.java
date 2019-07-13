package pl.biuropodrozy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.biuropodrozy.DTO.CityDTO;
import pl.biuropodrozy.builders.CityToCityBuilder;
import pl.biuropodrozy.entity.City;
import pl.biuropodrozy.repository.CityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CityToCityBuilder cityToCityBuilder;

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public Optional<City> findCityById(Integer id) {
        return cityRepository.findCityById(id);
    }

    public Optional<City> findCityByName(String name) {
        return cityRepository.findCityByName(name.toLowerCase());
    }

    public void addCity(City city) {
        city.setName(city.getName().toLowerCase());
        cityRepository.save(city);
    }


}
