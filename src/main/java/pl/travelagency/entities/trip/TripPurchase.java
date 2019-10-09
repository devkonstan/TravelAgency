package pl.travelagency.entities.trip;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.travelagency.entities.ID;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TripPurchase extends ID {

    @OneToOne
    private Trip trip;
    @OneToMany
    private Set<Participant> participant;
    private Integer numberOfAdult;
    private Integer numberOfChild;
}
