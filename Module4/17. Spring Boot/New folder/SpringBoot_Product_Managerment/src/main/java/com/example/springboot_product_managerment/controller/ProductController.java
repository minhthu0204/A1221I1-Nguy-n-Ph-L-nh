package com.example.springboot_product_managerment.controller;

import com.example.springboot_product_managerment.model.Product;
import com.example.springboot_product_managerment.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("create", "product", new Product());
    }

    @PostMapping("/create")
    public ModelAndView save(@ModelAttribute("product") Product product) {
        iProductService.save(product);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message", "New Product created successfully");
        return modelAndView;
    }

    @GetMapping({"/products", "/"})
    public ModelAndView listProducts() {
        return new ModelAndView("list", "product", iProductService.findAll());
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Optional<Product> product = iProductService.findById(id);
        if (product.isPresent())
        {
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("product", product);
            return modelAndView;
        }else{
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Product product){
        iProductService.save(product);
        return "redirect:/products";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        iProductService.remove(id);
        return "redirect:/products";
    }


}
