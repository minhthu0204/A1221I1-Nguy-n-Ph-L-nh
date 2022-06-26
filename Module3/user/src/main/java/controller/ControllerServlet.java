package controller;

import model.User;
import repository.UserRepositoryImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ControllerServlet", urlPatterns = {"/user",""})
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 5832063776451490808L;
    private UserRepositoryImpl userRepository;
    public void init(){
        userRepository = new UserRepositoryImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    fromCreate(request,response);
                    break;
                case "update":
                    formUpdate(request,response);
                    break;
                case "delete":
                    formDelete(request,response);
                    break;
                case "search":
                    searchUserByAddress(request,response);
                    break;
                case "sort":
                    sortUser(request,response);
                    break;
                case "searchByNumber":
                    searchByNumber(request,response);
                    break;
                case "insertByStored":
                    formInsertUser(request,response);
                    break;
                case "permision":
                    addUserPermision(request, response);
                    break;
                case "test-without-tran":
                    testWithoutTran(request, response);
                    break;
                case "updateByProcedure":
                    formUpdateByProcudure(request,response);
                    break;
                case "deleteByProcedure":
                    formDeleteByStored(request,response);
                    break;
                default:
                    listUser(request,response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void formDeleteByStored(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userRepository.selectUser(id);
        RequestDispatcher dispatcher;
        if (user == null) {
            dispatcher = request.getRequestDispatcher("/view/error404.jsp");
        } else {
            request.setAttribute("user",user);
            dispatcher = request.getRequestDispatcher("/view/delete.jsp");
        }

        dispatcher.forward(request,response);
    }

    private void formUpdateByProcudure(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/update.jsp");
        dispatcher.forward(request,response);
    }
    private void testWithoutTran(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        userRepository.insertUpdateWithOutTransaction();
    }
    private void addUserPermision(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        User user = new User("quan", "quan.nguyen@codegym.vn", "vn");
        int[] permision = {1, 2, 4};
        userRepository.addUserTransaction(user, permision);
    }
    private void formInsertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/insertByStored.jsp");
        dispatcher.forward(request,response);
    }

    private void searchByNumber(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userRepository.getUserById(id);
        RequestDispatcher dispatcher;
        if (user == null) {
            dispatcher = request.getRequestDispatcher("/view/error404.jsp");
        } else {
            request.setAttribute("listUser",user);
            dispatcher = request.getRequestDispatcher("/view/searchById.jsp");
        } dispatcher.forward(request,response);
    }

    private void sortUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = this.userRepository.sortUser();
        RequestDispatcher dispatcher;
        if (users == null) {
            dispatcher = request.getRequestDispatcher("/view/error404.jsp");
        } else {
            request.setAttribute("users",users);
            dispatcher = request.getRequestDispatcher("/view/list.jsp");
        }dispatcher.forward(request,response);
    }
    private void searchUserByAddress(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String address = request.getParameter("search1");
        List<User> user = this.userRepository.searchUserByAddress(address);
        RequestDispatcher dispatcher;
        if (user == null) {
            dispatcher = request.getRequestDispatcher("/view/error404.jsp");
        } else {
            request.setAttribute("user",user);
            dispatcher = request.getRequestDispatcher("/view/search.jsp");
        } dispatcher.forward(request,response);
    }
    private void formUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/update.jsp");
        dispatcher.forward(request,response);
    }
    private void formDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User users = userRepository.selectUser(id);
        RequestDispatcher dispatcher;
        if (users == null) {
            dispatcher = request.getRequestDispatcher("/view/error404.jsp");
        } else {
            request.setAttribute("user",users);
            dispatcher = request.getRequestDispatcher("/view/delete.jsp");
        } dispatcher.forward(request,response);
    }
    private void fromCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/create.jsp");
        dispatcher.forward(request,response);
    }
    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = this.userRepository.selectAllUser();
        RequestDispatcher dispatcher;
        if (users == null) {
            dispatcher = request.getRequestDispatcher("/view/error404.jsp");
        } else {
            request.setAttribute("users",users);
            dispatcher = request.getRequestDispatcher("/view/list.jsp");
        }dispatcher.forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createUser(request,response);
                    break;
                case "update":
                    updateUser(request,response);
                    break;
                case "delete":
                    deleteUser(request,response);
                    break;
                case "insertByStored":
                    insertUserByStored(request,response);
                    break;
                case "updateByProcedure":
                    updateByProcudure(request,response);
                    break;
                case "deleteByProcedure":
                    deleteByStored(request,response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteByStored(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userRepository.deleteByStored(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/delete.jsp");
        dispatcher.forward(request,response);

    }

    private void updateByProcudure(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int id = Integer.parseInt(request.getParameter("id"));
        User users = userRepository.selectUser(id);
        RequestDispatcher dispatcher;
        if (users == null) {
            dispatcher = request.getRequestDispatcher("/view/error404.jsp");
        }
        else {
            users.setName(name);
            users.setEmail(email);
            users.setAddress(address);
            users.setId(id);
            userRepository.updateUserByStored(users);
            dispatcher = request.getRequestDispatcher("/view/update.jsp");
        }
        dispatcher.forward(request,response);
    }
    private void insertUserByStored(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        User users = new User(name,email,address);
        userRepository.insertUserByStored(users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/insertByStored.jsp");
        dispatcher.forward(request,response);
    }
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int id = Integer.parseInt(request.getParameter("id"));
        User users = userRepository.selectUser(id);
        RequestDispatcher dispatcher;
        if (users == null) {
            dispatcher = request.getRequestDispatcher("/view/error404.jsp");
        }
        else {
            users.setName(name);
            users.setEmail(email);
            users.setAddress(address);
            users.setId(id);
            userRepository.updateUser(users);
            dispatcher = request.getRequestDispatcher("/view/update.jsp");
        }
        dispatcher.forward(request,response);
    }
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.userRepository.deleteUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/delete.jsp");
        dispatcher.forward(request,response);
    }
    private void createUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        User users = new User(name,email,address);
        userRepository.insertUser(users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/create.jsp");
        dispatcher.forward(request,response);
    }
}