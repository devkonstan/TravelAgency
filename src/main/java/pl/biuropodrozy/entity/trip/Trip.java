package pl.biuropodrozy.entity.trip;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.biuropodrozy.entity.ID;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Trip extends ID {

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


    public Trip(FromLocation fromLocation, DestinyLocation destinyLocation, LocalDate startDate, LocalDate endDate, Catering catering, Double priceForAdult, Double priceForChild, boolean promoted) {
        this.fromLocation = fromLocation;
        this.destinyLocation = destinyLocation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.catering = catering;
        this.priceForAdult = priceForAdult;
        this.priceForChild = priceForChild;
        this.promoted = promoted;
    }
}
