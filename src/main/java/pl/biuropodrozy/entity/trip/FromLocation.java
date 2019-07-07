package pl.biuropodrozy.entity.trip;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.biuropodrozy.entity.Airport;
import pl.biuropodrozy.entity.City;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "from_location")
public class FromLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private City city;
    @OneToOne
    private Airport airport;

    public FromLocation(City city, Airport airport) {
        this.city = city;
        this.airport = airport;
    }

    @Override
    public String toString() {
        return "FromLocation{" +
                "id=" + id +
                ", city=" + city +
                ", airport=" + airport +
                '}';
    }
}
