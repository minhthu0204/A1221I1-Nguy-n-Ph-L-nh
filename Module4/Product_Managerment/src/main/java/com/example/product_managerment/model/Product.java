package com.example.product_managerment.model;
import com.example.product_managerment.common.NumberValid;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is not empty!")
    private String name;


    @NumberValid
    private Double price;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String expiryDate;

    @NotBlank(message = "Manufacturer is not empty!")
    private String manufacturer;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    public Product() {
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
