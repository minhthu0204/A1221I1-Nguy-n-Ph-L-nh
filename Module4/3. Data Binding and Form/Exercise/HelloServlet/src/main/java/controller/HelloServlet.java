package controller;

@Controller
public class HelloServlet  {
    @GetMapping("/home")
    public ModelAndView setting(Setting setting)
    {
        return new ModelAndView("home", "setting", setting);
    }

    @PostMapping("/user")
    public ModelAndView user(@ModelAttribute("setting") Setting setting)
    {
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("setting", setting);
        return modelAndView;
    }
}