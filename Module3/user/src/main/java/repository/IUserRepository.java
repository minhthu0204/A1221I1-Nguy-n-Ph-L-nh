package repository;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    User selectUser(int id);
    List<User> selectAllUser();
    boolean deleteUser(int id) throws SQLException;
    boolean updateUser(User user) throws SQLException;
    List<User> searchUserByAddress(String address) throws SQLException;
    List<User> sortUser();
    User getUserById(int id) throws SQLException;
    void insertUserByStored(User user) throws SQLException;
    void addUserTransaction(User user,int[] permision) throws SQLException;
    void insertUpdateWithOutTransaction() throws SQLException;
    void updateUserByStored(User user) throws SQLException;
    void deleteByStored(int id) throws SQLException;


}
