package alann.spr.Controller;

import alann.spr.Exeption.AccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Admin")
public class AdminController {
    private boolean autorise = false;
    @GetMapping("/dashboard")
    public String dashboard() throws AccessException{
        if (!autorise){
            throw new AccessException("access refusé a cette ressource protege");
        }
        return "bienvenue Admin";
    }
}
