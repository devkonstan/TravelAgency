package pl.travelagency.entities.trip;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.travelagency.entities.Address;
import pl.travelagency.entities.ID;

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
