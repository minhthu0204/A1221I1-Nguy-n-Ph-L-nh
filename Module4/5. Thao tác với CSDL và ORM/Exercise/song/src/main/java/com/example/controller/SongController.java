package com.example.controller;

import com.example.model.Song;
import com.example.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"/song","/home"})
public class SongController {
    @Autowired
    private ISongService songService;

    @RequestMapping(value = "/list",
            method = RequestMethod.GET)

    public ModelAndView showSongList(){
        return new ModelAndView("song",
                "songList", songService.findAll());
    }

    @PostMapping("/list")
    public ModelAndView showStudentList1(){

        return new ModelAndView("song",
                "songList", songService.findAll());
    }

    @GetMapping("/create")
    public String showCreatePage(Model model){


        model.addAttribute("song", new Song());
        return "create";
    }
    @GetMapping("/delete/id={id}")
    public String deleteStudent(@PathVariable("id") int id, RedirectAttributes redirectAttributes){
        songService.delete(id);
        redirectAttributes.addFlashAttribute("message","Delete song: OK!");
        return "redirect:song/list";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Song song,
                                RedirectAttributes redirectAttributes){
        System.out.println(song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("message",
                "Create song: " + song.getName() + " OK!");
//        return "forward:/song/list";
        return "redirect:/song/list";
    }
}
