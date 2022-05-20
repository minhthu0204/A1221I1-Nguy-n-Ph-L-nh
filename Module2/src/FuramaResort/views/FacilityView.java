package FuramaResort.views;

import FuramaResort.models.Facility.Facility;
import FuramaResort.models.Facility.Villa;

import java.util.Scanner;

public class FacilityView {
    static Scanner scanner = new Scanner(System.in);
    public static void displayFacilityMenu(){
        System.out.println("-------------------------");
        System.out.println("1. Display list facility");
        System.out.println("2. Add new facility");
        System.out.println("3. Display list facility maintenance");
        System.out.println("4. Return main menu");
        System.out.println("Enter your choice:");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                break;
            case 2:
            {
                System.out.println("1. Add New Villa");
                System.out.println("2. Add New House");
                System.out.println("3. Add New Room");
                System.out.println("4. Return main menu");
                System.out.println("Enter your choice: ");
                int choiceTwo = Integer.parseInt(scanner.nextLine());
                switch (choiceTwo){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        displayFacilityMenu();
                        break;
                }

            }
            case 3:
                break;
            case 4:
                HomeView.displayMainMenu();
                break;
        }
    }
    private static void add(){
        System.out.println("Enter Service Name:");
        String serviceName = scanner.nextLine();
        System.out.println("Enter Usable Area:");
        int usableArea = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the Rental Cost:");
        int rentalCosts = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the Maximum Quantity:");
        int maximumQuantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the Rental Type:");
        String rentalType = scanner.nextLine() ;
    }

    private static void addVilla(){
        System.out.println("Enter Service Name:");
        String serviceName = scanner.nextLine();
        System.out.println("Enter Usable Area:");
        int usableArea = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the Rental Cost:");
        int rentalCosts = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the Maximum Quantity:");
        int maximumQuantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the Rental Type:");
        String rentalType = scanner.nextLine() ;
        System.out.println("Enter Room Standard:");
        String roomStandard = scanner.nextLine();
        System.out.println("Enter SwimmingPoolArea: ");
        int swimmingPoolArea = Integer.parseInt(scanner.nextLine()) ;
        System.out.println("Enter Number of Floors");
        int numberOfFloors = Integer.parseInt(scanner.nextLine());

        Villa villa = new Villa(serviceName,usableArea,rentalCosts,
                maximumQuantity, rentalType, roomStandard,swimmingPoolArea,numberOfFloors);

    }
}
