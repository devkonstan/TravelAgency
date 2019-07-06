package pl.biuropodrozy.entity.Trip;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.biuropodrozy.entity.Trip.Catering;
import pl.biuropodrozy.entity.Trip.DestinyLocation;
import pl.biuropodrozy.entity.Trip.FromLocation;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private FromLocation fromLocation;
    @OneToOne
    private DestinyLocation destinyLocation;
    private LocalDate departure;
    private LocalDate arrival;
    private Catering catering;
    @Column(name = "value_adult")
    private Double priceForAdult;
    @Column(name = "value_child")
    private Double priceForChild;
    private boolean promoted;
    private Integer numberOfAdult;
    private Integer numberOfChild;


    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                '}';
    }
}
