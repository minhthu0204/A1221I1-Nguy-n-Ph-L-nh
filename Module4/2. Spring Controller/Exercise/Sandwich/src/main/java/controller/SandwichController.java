package controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {
@GetMapping("/")
    public String home(){
    return "home";
}
@PostMapping("/save")
    public ModelAndView save(@RequestParam(value = "condiment") String [] condiment){
    ModelAndView modelAndView = new ModelAndView("home","condiment",condiment);
    return modelAndView;
}
}
