package pl.travelagency.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityDto {

    private Integer id;
    private String name;
    private String airport;
    private String country;
}
