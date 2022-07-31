package codegym.service;

import codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{

    private static final Map<Integer,Product> products ;

    static {
        //    id, tên sản phẩm, giá sản phẩm, mô tả của sản phẩm, nhà sản xuất
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone", 1000.0, "tot","my"));
        products.put(2, new Product(2, "Iphone", 1000.0, "tot","my"));
        products.put(3, new Product(3, "Iphone", 1000.0, "tot","my"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findByName(String name) {
        return null;
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }
}
