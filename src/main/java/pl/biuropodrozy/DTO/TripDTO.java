package pl.biuropodrozy.DTO;

import lombok.*;
import pl.biuropodrozy.entity.trip.Catering;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TripDTO {

    private Integer id;
    private Integer fromLocationID;
    private Integer destinyLocationID;

    private LocalDate startDate;
    private LocalDate endDate;
    private Catering catering;

    private Double priceForAdult;
    private Double priceForChild;
    private boolean promoted;

}
