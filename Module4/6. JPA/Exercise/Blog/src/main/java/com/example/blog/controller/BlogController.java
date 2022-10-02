package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.BlogService;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @Value("${a.b}")
    private String path;

    @GetMapping("login")
    public String showLoginPage(){
        return "myLogin";
    }

    @GetMapping("list")
    public ModelAndView showList(@RequestParam("search") Optional<String> search, @PageableDefault(value = 4) Pageable pageable) {

        Page<Blog> blogs;
        ModelAndView modelAndView = new ModelAndView("list");

        if(search.isPresent()){
            blogs = blogService.findAllByNameContaining(search.get(),pageable);
            modelAndView.addObject("blog",blogs);
        } else {
            blogs = blogService.findAll(pageable);
            modelAndView.addObject("blog",blogs);
        }

        return  modelAndView;

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        blogService.remove(id);
        return "redirect:/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("category", categoryService.findAll());
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public  ModelAndView create(Blog blog) throws IOException {
        MultipartFile multipartFile = blog.getMultipartFile();
        String fileName=multipartFile.getOriginalFilename();
        try{
            FileCopyUtils.copy(multipartFile.getBytes(),new File(path+fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        blog.setImage(fileName);

        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product", new Blog());
        modelAndView.addObject("message", "New Product created successfully");
        return modelAndView;
    }

}
