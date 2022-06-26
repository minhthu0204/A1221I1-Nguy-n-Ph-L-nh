package service;

import model.Product;
import repository.IProductRepository;
import repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    private IProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(int id) {
//        productRepository.remove(id);
    }
}
