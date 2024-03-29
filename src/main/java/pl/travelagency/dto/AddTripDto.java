package pl.travelagency.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddTripDto {
    //zamienic na regexy analogicznie do shop
    @NotBlank(message = "Pole musi zostać wypełnione")
    private String fromLocation;
    @NotBlank(message = "Pole musi zostać wypełnione")
    private String destinyLocation;

    @NotBlank(message = "Pole musi zostać wypełnione")
    private String startDate;
    @NotBlank(message = "Pole musi zostać wypełnione")
    private String endDate;

    @NotBlank(message = "Pole musi zostać wypełnione")
    private String catering;

    @NotNull(message = "Pole musi zostać wypełnione")
    private Integer priceForAdult;
    @NotNull(message = "Pole musi zostać wypełnione")
    private Integer priceForChild;

    private boolean promoted;

}
