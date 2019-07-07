package pl.biuropodrozy.entity.Trip;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private int id;
    @OneToOne
    private FromLocation fromLocation;
    @OneToOne
    private DestinyLocation destinyLocation;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    private Catering catering;
    @Column(name = "price_adult")
    private Double priceForAdult;
    @Column(name = "price_child")
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

    public Trip(FromLocation fromLocation, DestinyLocation destinyLocation, LocalDate startDate, LocalDate endDate, Catering catering, Double priceForAdult, Double priceForChild, boolean promoted, Integer numberOfAdult, Integer numberOfChild) {
        this.fromLocation = fromLocation;
        this.destinyLocation = destinyLocation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.catering = catering;
        this.priceForAdult = priceForAdult;
        this.priceForChild = priceForChild;
        this.promoted = promoted;
        this.numberOfAdult = numberOfAdult;
        this.numberOfChild = numberOfChild;
    }
}
