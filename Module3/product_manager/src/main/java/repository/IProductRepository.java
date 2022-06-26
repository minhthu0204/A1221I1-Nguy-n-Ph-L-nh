package repository;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void save(Product product);
    void remove(int id) throws SQLException;
}
