package hello.hellospirng.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/") //맨처음 페이지
    public String home(){
        return "home";
    }
}
