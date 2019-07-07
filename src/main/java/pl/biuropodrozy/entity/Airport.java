package pl.biuropodrozy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor

@Getter
@Setter
public class Airport extends ID {

    private String name;
    @OneToOne
    private Address address;

    public Airport(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}

