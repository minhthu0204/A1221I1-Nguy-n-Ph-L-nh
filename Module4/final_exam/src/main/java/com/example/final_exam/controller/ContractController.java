package com.example.final_exam.controller;

import com.example.final_exam.dto.ContractDto;
import com.example.final_exam.model.Contract;
import com.example.final_exam.service.ContractService;
import com.example.final_exam.service.HouseService;
import org.springframework.beans.BeanUtils;
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
public class ContractController {
    @Autowired
    private ContractService contractService;

    @Autowired
    private HouseService houseService;

    @GetMapping("list")
    public ModelAndView showList( @PageableDefault(value = 2) Pageable pageable) {

        Page<Contract> contracts ;
        ModelAndView modelAndView = new ModelAndView("list");


            contracts = contractService.findAll(pageable);
            if(contracts.isEmpty()){
                modelAndView.addObject("haha","Product list is empty");
            }
            modelAndView.addObject("contract",contracts);


        return  modelAndView;

    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id ){
        contractService.remove(id);
        return "redirect:/list";
    }



    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("house", houseService.findAll());
        model.addAttribute("contractDto", new ContractDto());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("contractDto") @Validated ContractDto contractDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("house", houseService.findAll());
            return "create";
        }
        else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto,contract);
            contractService.save(contract);
            redirectAttributes.addFlashAttribute("message","Create contract: "+contract.getName()+" successfully!");
            return "redirect:/create";
        }
    }



}
