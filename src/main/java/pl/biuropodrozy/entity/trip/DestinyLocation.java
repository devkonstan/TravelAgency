package pl.biuropodrozy.entity.trip;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.biuropodrozy.entity.Airport;
import pl.biuropodrozy.entity.City;
import pl.biuropodrozy.entity.Hotel;
import pl.biuropodrozy.entity.ID;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "destiny_location")
public class DestinyLocation extends ID {


    @OneToOne
    private City city;
    @OneToOne
    private Hotel hotel;
    @OneToOne
    private Airport airport;

    public DestinyLocation(City city, Hotel hotel, Airport airport) {
        this.city = city;
        this.hotel = hotel;
        this.airport = airport;
    }

}
