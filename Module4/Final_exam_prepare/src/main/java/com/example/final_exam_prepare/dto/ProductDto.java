package com.example.final_exam_prepare.dto;

import com.example.final_exam_prepare.common.NumberValid;
import com.example.final_exam_prepare.model.Category;

import javax.validation.constraints.NotBlank;

public class ProductDto {


    private int id;

    @NotBlank(message = "Name is not empty!")
    private String name;

    @NumberValid
    private Double price;

    private String expiryDate;

    @NotBlank(message = "Manufacturer is not empty!")
    private String manufacturer;

    private Category category;

    public ProductDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
