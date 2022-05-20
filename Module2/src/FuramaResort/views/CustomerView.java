package FuramaResort.views;

import FuramaResort.controlles.CustomerController;
import FuramaResort.models.Person.Customer;

import java.util.List;
import java.util.Scanner;

public class CustomerView {
    static Scanner scanner = new Scanner(System.in);
    private static CustomerController customerController = new CustomerController();

    public static void displayCustomerMenu() {

        System.out.println("-------------------------");
        System.out.println("1. Display list customers");
        System.out.println("2. Add new customer");
        System.out.println("3. Edit customer");
        System.out.println("4. Return main menu");
        System.out.println("Enter your choice:");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                display();
                break;
            case 2:
                add();
                break;
            case 3:
                edit();
                break;
            case 4:
                HomeView.displayMainMenu();
                break;
        }
    }

    private static void add(){
        System.out.println("Enter Name:");
        String name = scanner.nextLine();
        System.out.println("Enter birthday:");
        String birthDay = scanner.nextLine();
        System.out.println("Enter gender:");
        String gender = scanner.nextLine();
        System.out.println("Enter ID number:");
        int IDNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter phone number:");
        int phoneNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter customer ID:");
        int customerID = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter customer type:");
        String customerType = scanner.nextLine();
        System.out.println("Enter address:");
        String address = scanner.nextLine();
        Customer customer = new Customer(name,birthDay,gender,IDNumber,phoneNumber,email,customerID,customerType,address);

        customerController.add(customer);

        System.out.println("Add customer information successfully!!!");

    }

    private static void display(){
        List<Customer> customerList = customerController.findAll();
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println(customerList.get(i));
        }
    }

    private static void edit(){
        display();
        System.out.println("Enter customer ID that you want to edit :");
        int customerID = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Name:");
        String name = scanner.nextLine();
        System.out.println("Enter birthday:");
        String birthDay = scanner.nextLine();
        System.out.println("Enter gender:");
        String gender = scanner.nextLine();
        System.out.println("Enter ID number:");
        int IDNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter phone number:");
        int phoneNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter customer type:");
        String customerType = scanner.nextLine();
        System.out.println("Enter address:");
        String address = scanner.nextLine();

        Customer customer = new Customer(name,birthDay,gender,IDNumber,phoneNumber,email,customerID,customerType,address);
        customerController.edit(customer);
        System.out.println("Edit customer information successfully!!!");

    }


}
