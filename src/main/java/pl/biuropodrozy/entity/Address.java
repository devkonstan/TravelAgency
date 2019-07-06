package pl.biuropodrozy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "house_number")
    private Integer houseNumber;
    @Column(name = "street_number")
    private Integer streetNumber;
}
