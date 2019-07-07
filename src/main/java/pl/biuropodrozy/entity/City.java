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
    @OneToMany
    private Set<Hotel> hotel;
    @OneToOne
    private Airport airport;
    @OneToOne
    private Country country;

    public City(String name, Set<Hotel> hotel, Airport airport, Country country) {
        this.name = name;
        this.hotel = hotel;
        this.airport = airport;
        this.country = country;
    }

    public City(String name, Airport airport) {
        this.name = name;
        this.airport = airport;
    }
}
