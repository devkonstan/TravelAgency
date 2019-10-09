package pl.travelagency.entities.trip;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.travelagency.entities.ID;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Contact extends ID {


    @Column(name = "phone_number")
    private String phoneNumber;
    @Email
    private String email;
}
