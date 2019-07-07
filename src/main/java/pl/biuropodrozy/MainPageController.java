package pl.biuropodrozy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pl.biuropodrozy.entity.Trip.Trip;

import java.util.HashSet;
import java.util.Set;

//rozporzadza przekierowaniami
@Controller
public class MainPageController {

    @GetMapping()
    @ResponseBody //niech sie cos wewnatrz wywietli
    public String hello() {
        return "hello user";
    }

    Set<Trip> trip = new HashSet<>();

    @GetMapping("/trips")
    public ModelAndView getMain() {
        ModelAndView m = new ModelAndView();
        m.setViewName("index");
        initTrip();
        m.addObject("trips", trip);
        return m;
    }

    public void initTrip() {
        for (int i = 0; i <= 10; i++) {
            trip.add(new Trip());
        }
    }
}