package pl.biuropodrozy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//rozporzadza przekierowaniami
@Controller
public class MainController {

    @GetMapping("/hello")
    @ResponseBody //niech sie cos wewnatrz wywietli
    public String hello() {
        return "hello user";
    }

}
