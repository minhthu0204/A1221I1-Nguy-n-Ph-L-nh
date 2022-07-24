package controller;

@Controller
public class HelloServlet {
    @GetMapping("/health")
    public ModelAndView form()
    {
        return new ModelAndView("home", "form", new HealthForm());
    }

    @PostMapping("/user")
    public ModelAndView user(@ModelAttribute("form") HealthForm healthForm)
    {
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("form", healthForm);
        return modelAndView;
    }
}