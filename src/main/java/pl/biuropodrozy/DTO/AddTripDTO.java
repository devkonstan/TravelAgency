package pl.biuropodrozy.DTO;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddTripDTO {

    @NotBlank(message = "Pole musi zostać wypełnione") //zamienic na regexy analogicznie do shop
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
    private Double priceForAdult;
    @NotNull(message = "Pole musi zostać wypełnione")
    private Double priceForChild;

    private boolean promoted;

}
