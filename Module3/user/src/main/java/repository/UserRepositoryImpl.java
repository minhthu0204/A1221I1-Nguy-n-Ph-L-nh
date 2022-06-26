package repository;

import model.User;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements IUserRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo1";
    private String jbdcUserName = "root";
    private String jbdcPassWord = "123456";
    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, address) VALUES " +
            " (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,address from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, address =? where id = ?;";
    private static final String SELECT_USER_BY_ADDRESS = "select * from users where address = ?";
    private static final String SORT_USER_BY_NAME = "select * from users order by name ";
    private static final String SQL_TABLE_INSERT = "INSERT INTO EMPLOYEE(ID,NAME,SALARY) VALUE(?,?,?)";
    private static final String SQL_CREATE ="CREATE TABLE EMPLOYEE"
            + "("
            + "ID serial,"
            +"NAME VARCHAR(50) not null,"
            +"SALARY numeric(15,2) not null,"
            + " CREATED_DATE timestamp,"
            + " PRIMARY KEY (ID)"
            +")";
    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY WHERE NAME = ?";
    private static final String SQL_DROP_TABLE = "DROP TABLE IF EXITS EMPLOYEE";
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jbdcUserName, jbdcPassWord);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        try
                (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getAddress());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();

            if (connection !=null) {
                connection.close();
            }
            if (preparedStatement != null){
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public User selectUser(int id) {
        User user = null;
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                user = new User(id, name, email, address);
            }
            if (connection !=null) {
                connection.close();
            }
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (rs != null) {
                rs.close();
            }
            return user;
        } catch (SQLException e) {
            return null;
        }
    }
    @Override
    public List<User> selectAllUser() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                users.add(new User(id, name, email, address));
            }
            if (connection !=null) {
                connection.close();
            }
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (rs != null) {
                rs.close();
            }
            return users;
        } catch (SQLException e) {
            return null;
        }
    }
    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDelete;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);) {
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }
    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getAddress());
            statement.setInt(4, user.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    @Override
    public List<User> searchUserByAddress(String address) throws SQLException {
        List<User> user = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_ADDRESS);
        statement.setString(1,address);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name =  resultSet.getString("name");
            String email = resultSet.getString("email");
            String address1 = resultSet.getString("address");
            user.add(new User(id,name,email,address1));
        }  return user;
    }
    @Override
    public List<User> sortUser() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SORT_USER_BY_NAME);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                users.add(new User(id, name, email, address));
            }
            if (connection !=null) {
                connection.close();
            }
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (rs != null) {
                rs.close();
            }
            return users;
        } catch (SQLException e) {
            return null;
        }
    }
    @Override
    public User getUserById(int id) throws SQLException {
        User user = null;
        Connection connection = getConnection();
        String query = "{CALL get_user_by_id(?)}";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String address = resultSet.getString("address");
            user = new User(id,name,email,address);
        }
        return user;
    }
    @Override
    public void insertUserByStored(User user) throws SQLException {
        Connection connection = getConnection();
        String query = "{CALL insert_user(?,?,?)}";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,user.getName());
        statement.setString(2,user.getEmail());
        statement.setString(3,user.getAddress());
        statement.executeUpdate();
    }
    @Override
    public void addUserTransaction(User user, int[] permision) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmtAssignment = null;
        ResultSet rs =null;
        conn =getConnection();
        conn.setAutoCommit(false);
        pstmt = conn.prepareStatement(INSERT_USERS_SQL,Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1,user.getName());
        pstmt.setString(2,user.getEmail());
        pstmt.setString(3,user.getAddress());
        int rowAffected = pstmt.executeUpdate();
        rs =pstmt.getGeneratedKeys();
        int userId = 0;
        if (rs.next()){
            userId = rs.getInt(1);
        }
        if (rowAffected == 1 ){
            String sqlPivot = "{insert into User_Permision(permision_id,user_id)" + "value (?,?)}";
            pstmtAssignment = conn.prepareStatement(sqlPivot);
            for (int permisionId : permision) {
                pstmtAssignment.setInt(1, userId);
                pstmtAssignment.setInt(2, permisionId);
                pstmtAssignment.executeUpdate();
            }conn.commit();
        } else {
            conn.rollback();
        }
        if (conn != null)
            conn.rollback();
        if (rs != null) rs.close();
        if (pstmt != null) pstmt.close();
        if (pstmtAssignment != null) pstmtAssignment.close();
        if (conn != null) conn.close();
    }
    @Override
    public void insertUpdateWithOutTransaction() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             PreparedStatement psInsert = connection.prepareStatement(SQL_TABLE_INSERT);
             PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE)){
            statement.execute(SQL_DROP_TABLE);
            statement.execute(SQL_CREATE);
            psInsert.setString(1, "Quynh");
            psInsert.setBigDecimal(2, new BigDecimal(10));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();
            psInsert.setString(1, "Ngan");
            psInsert.setBigDecimal(2, new BigDecimal(20));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();
            psUpdate.setBigDecimal(2, new BigDecimal(999.99));
            psUpdate.setString(2, "Quynh");
            psUpdate.execute();}
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserByStored(User user) throws SQLException {
        Connection connection = getConnection();
        String query = "{CALL update_user(?,?,?,?)}";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,user.getId());
        statement.setString(2,user.getName());
        statement.setString(3,user.getEmail());
        statement.setString(4,user.getAddress());
        statement.executeUpdate();
    }

    @Override
    public void deleteByStored(int id) throws SQLException {
        Connection connection = getConnection();
        String query = "{CALL delete_user(?)}";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,id);
        statement.executeUpdate();
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
