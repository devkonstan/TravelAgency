package pl.biuropodrozy.entity.trip;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.biuropodrozy.entity.Address;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private String surname;
    private Integer age;
    @OneToOne
    private Address address;
    @OneToOne
    private Contact contact;
}
