package pl.travelagency.dto;

import lombok.*;
import pl.travelagency.entities.trip.Catering;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TripDto {

    private Integer id;
    private Integer fromLocationID;
    private Integer destinyLocationID;

    private LocalDate startDate;
    private LocalDate endDate;
    private Catering catering;

    private Integer priceForAdult;
    private Integer priceForChild;
    private boolean promoted;

}
