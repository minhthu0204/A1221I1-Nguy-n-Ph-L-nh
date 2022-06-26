package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private static List<Product> productList;


    static {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Nokia 590",123.00, "d1", "Nokia"));
        productList.add(new Product(2, "SamSung A80", 123.11, "d2", "Samsung"));
        productList.add(new Product(3, "Iphone 13", 123.22, "d3", "Apple"));
        productList.add(new Product(4, "Test 13", 123.33, "d3", "Test"));
        productList.add(new Product(5, "LG 139", 123.44, "d3", "LG"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public void remove(int id) {

    }
}
