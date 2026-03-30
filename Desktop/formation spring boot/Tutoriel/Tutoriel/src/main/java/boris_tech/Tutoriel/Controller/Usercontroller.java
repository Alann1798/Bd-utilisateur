package boris_tech.Tutoriel.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "test")
public class Usercontroller {
    @GetMapping(path = "string")
    public String getString(){
        return "Chaine de caractére transmise par SA";
    }
}
