package FuramaResort.views;

import FuramaResort.controlles.EmployeeController;
import FuramaResort.models.Person.Employee;

import java.util.List;
import java.util.Scanner;

public class EmployeeView {
    static Scanner scanner = new Scanner(System.in);
    private static EmployeeController employeeController = new EmployeeController();
    public static void displayEmployeeMenu(){
        System.out.println("-------------------------");
        System.out.println("1. Display list employees");
        System.out.println("2. Add new employee");
        System.out.println("3. Edit employee");
        System.out.println("4. Return main menu");
        System.out.println("Enter your choice:");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
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
        System.out.println("Enter employee ID:");
        int employeeID = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter level:");
        String level = scanner.nextLine();
        System.out.println("Enter position:");
        String position = scanner.nextLine();
        System.out.println("Enter salary:");
        int salary = Integer.parseInt(scanner.nextLine());

        Employee employee = new Employee(name,birthDay,gender,IDNumber,phoneNumber,email,employeeID,level,position,salary);

        employeeController.add(employee);

        System.out.println("Add employ information successfully!!!");

    }

    private static void edit(){
        display();
        System.out.println("Enter employeeID that you want to edit:  ");
        int employeeID = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name:");
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
        System.out.println("Enter level:");
        String level = scanner.nextLine();
        System.out.println("Enter position:");
        String position = scanner.nextLine();
        System.out.println("Enter salary:");
        int salary = Integer.parseInt(scanner.nextLine());

        Employee employee = new Employee(name,birthDay,gender,IDNumber,phoneNumber,email,employeeID,level,position,salary);

        employeeController.edit(employee);

        System.out.println("Edit employ information successfully!!!");
    }


    private static void display(){
        List<Employee> employeeList = employeeController.findAll();
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println(employeeList.get(i));
        }
    }

}
