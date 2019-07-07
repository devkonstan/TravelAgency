package pl.biuropodrozy.entity.trip;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.biuropodrozy.entity.Address;
import pl.biuropodrozy.entity.ID;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Participant extends ID {

    private String name;
    private String surname;
    private Integer age;
    @OneToOne
    private Address address;
    @OneToOne
    private Contact contact;
}
