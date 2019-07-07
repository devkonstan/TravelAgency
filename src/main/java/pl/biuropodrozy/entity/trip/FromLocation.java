package pl.biuropodrozy.entity.trip;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.biuropodrozy.entity.Airport;
import pl.biuropodrozy.entity.City;
import pl.biuropodrozy.entity.ID;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "from_location")
public class FromLocation extends ID {

    @OneToOne
    private City city;
    @OneToOne
    private Airport airport;

    public FromLocation(City city, Airport airport) {
        this.city = city;
        this.airport = airport;
    }
}
