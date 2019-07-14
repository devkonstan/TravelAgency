package pl.biuropodrozy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.biuropodrozy.DTO.AddTripDTO;
import pl.biuropodrozy.services.TripService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private TripService tripService;

    @Autowired
    public AdminController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/addtrip")
    public String addTripForm(Model model) {
        model.addAttribute("tripFormData", new AddTripDTO());


        return "newTrip";
    }

    @PostMapping(value = "/addtrip")
    public String addTripEffect(@ModelAttribute(name = "tripFormData") @Valid AddTripDTO addTripDTO, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("countries", Countries.values());
//            return "registerForm";
//        }
//        try {
//            userRegistrationService.registerUser(customerFormData);
//        } catch (UserExistsException e) {
//            model.addAttribute("userExistsException", e.getMessage());
//            return "registerForm";
//        }
//        model.addAttribute("registrationData", customerFormData);
        return "addTripEffect";
    }

}
