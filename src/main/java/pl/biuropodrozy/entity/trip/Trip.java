package pl.biuropodrozy.entity.trip;

import jdk.internal.instrumentation.TypeMapping;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.biuropodrozy.entity.ID;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Trip extends ID {

//    @OneToOne
    private String fromLocation;
//    @OneToOne
    private String destinyLocation;
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
