package com.example.product_managerment_3.controller;

import com.example.product_managerment_3.model.Product;
import com.example.product_managerment_3.service.CategoryService;
import com.example.product_managerment_3.service.ProductService;
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

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired

    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("list")
    public ModelAndView showList(@RequestParam("search") Optional<String> search, @PageableDefault(value = 2) Pageable pageable) {

        Page<Product> products ;
        ModelAndView modelAndView = new ModelAndView("list");
        if(search.isPresent()){
            products = productService.findAllByNameContaining(search.get(),pageable);
            modelAndView.addObject("product",products);
        } else {
            products = productService.findAll(pageable);
            if(products.isEmpty()){
                modelAndView.addObject("haha","Product list is empty");
            }
            modelAndView.addObject("product",products);
        }

        return  modelAndView;

    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id ){
        productService.remove(id);
        return "redirect:/list";
    }



    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("category", categoryService.findAll());
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
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

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        model.addAttribute("category", categoryService.findAll());
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("product") @Validated Product product, BindingResult bindingResult,
                         Model model){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("category", categoryService.findAll());
            return "edit";
        }
        else {
            productService.save(product);
            return "redirect:/list";
        }

    }


}
