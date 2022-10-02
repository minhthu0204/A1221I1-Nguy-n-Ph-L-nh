package com.example.product_managerment.controller;

import com.example.product_managerment.model.Category;
import com.example.product_managerment.model.Product;
import com.example.product_managerment.service.CategoryService;
import com.example.product_managerment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired

    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("list")
    public ModelAndView showList(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("list");
        Page<Product> products = productService.findAll(pageable);
        modelAndView.addObject("product",products);
        return  modelAndView;

    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        productService.remove(id);
        return "redirect:/list";
    }


    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("category", categoryService.findAll());
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("product") @Validated Product product, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("category", categoryService.findAll());
            return "create";
        }
        else {
            productService.save(product);
            redirectAttributes.addFlashAttribute("message","Create product: "+product.getName()+" successfully!");
            return "redirect:/create";
        }
    }

}