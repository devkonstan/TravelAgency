package pl.travelagency.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.travelagency.dto.AddTripDto;
import pl.travelagency.entities.trip.Catering;
import pl.travelagency.services.CityService;
import pl.travelagency.services.TripService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private TripService tripService;
    private CityService cityService;

    @Autowired
    public AdminController(TripService tripService, CityService cityService) {
        this.tripService = tripService;
        this.cityService = cityService;
    }


    @GetMapping(value = "/addtrip")
    public String addTripForm(Model model) {
        model.addAttribute(cityService.findAll());
        model.addAttribute("tripFormData", new AddTripDto());
        model.addAttribute("caterings", Catering.values());
        return "addTrip";
    }

    @PostMapping(value = "/addtrip")
    public String addTripEffect(@ModelAttribute(name = "tripFormData") @Valid AddTripDto addTripDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute(cityService.findAll());
            model.addAttribute("caterings", Catering.values());
            return "addTrip";
        }

        tripService.addTrip(addTripDTO);
        model.addAttribute("registrationData", addTripDTO);
        return "addTripEffect";
    }

}
