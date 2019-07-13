package pl.biuropodrozy.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO {

    private Integer id;
    private String name;
    private String airport;
    private String country;
}
