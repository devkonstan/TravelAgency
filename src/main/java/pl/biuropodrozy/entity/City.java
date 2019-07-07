package pl.biuropodrozy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToOne
    private Address address;
    @OneToMany
    private Set<Hotel> hotel;
    @OneToOne
    private Airport airport;

    public City(String name, Address address, Set<Hotel> hotel, Airport airport) {
        this.name = name;
        this.address = address;
        this.hotel = hotel;
        this.airport = airport;
    }

    public City(String name, Address address, Airport airport) {
        this.name = name;
        this.address = address;
        this.airport = airport;
    }
}
