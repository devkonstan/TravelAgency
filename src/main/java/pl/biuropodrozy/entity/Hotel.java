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
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private StarRate starRate;
    private String description;

    public Hotel(String name, StarRate starRate, String description) {
        this.name = name;
        this.starRate = starRate;
        this.description = description;
    }
}
