package repository;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    public static final String SELECT_ALL = "select * from product";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";


    @Override
    public List<Product> findAll() {
        /*B1 tạo connection*/
        Connection connection = DBConnection.getConnection();

        /*B2 Sử dụng Statment/PreparedStatement/CallableStatement để tạo câu lệnh truy vấn*/
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Product> studentList = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL);
                resultSet = statement.executeQuery();

                /*B3 Dùng resultSet để xử lý kết quả trả về*/
                Product product = null;
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    double price = resultSet.getDouble("price");
                    String color = resultSet.getString("color");

                    product = new Product(id,name,price,color);
                    studentList.add(product);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return studentList;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void remove(int id) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
