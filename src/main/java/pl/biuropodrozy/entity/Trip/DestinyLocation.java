package pl.biuropodrozy.entity.Trip;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.biuropodrozy.entity.Airport;
import pl.biuropodrozy.entity.City;
import pl.biuropodrozy.entity.Hotel;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "destiny_location")
public class DestinyLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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

    @Override
    public String toString() {
        return "DestinyLocation{" +
                "id=" + id +
                ", city=" + city +
                ", hotel=" + hotel +
                ", airport=" + airport +
                '}';
    }
}
