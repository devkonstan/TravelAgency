package pl.biuropodrozy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Address extends ID {

    private String street;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "house_number")
    private Integer houseNumber;
    @Column(name = "street_number")
    private Integer streetNumber;

    public Address(String street, String zipCode, Integer houseNumber, Integer streetNumber) {
        this.street = street;
        this.zipCode = zipCode;
        this.houseNumber = houseNumber;
        this.streetNumber = streetNumber;
    }

    public Address(String street, String zipCode, Integer streetNumber) {
        this.street = street;
        this.zipCode = zipCode;
        this.streetNumber = streetNumber;
    }
}
