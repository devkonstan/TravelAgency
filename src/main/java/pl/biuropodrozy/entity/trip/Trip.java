package pl.biuropodrozy.entity.trip;

import lombok.*;
import pl.biuropodrozy.entity.City;
import pl.biuropodrozy.entity.ID;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Trip extends ID {

    @ManyToOne
    private City fromLocation;
    @ManyToOne
    private City destinyLocation;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    private Catering catering;
    @Column(name = "price_adult")
    private Double priceForAdult;
    @Column(name = "price_child")
    private Double priceForChild;
    private boolean promoted;


}
