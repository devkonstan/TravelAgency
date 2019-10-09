package pl.travelagency.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.travelagency.builders.CityToCityBuilder;
import pl.travelagency.entities.City;
import pl.travelagency.repository.CityRepository;

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

    //napisac metode addTrip
}
