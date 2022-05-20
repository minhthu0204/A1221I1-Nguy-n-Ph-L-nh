package FuramaResort.views;

import java.util.Scanner;

public class HomeView {
    static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {
        while (true) {
            System.out.println("-------------------------");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            System.out.println("Enter your choice:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    EmployeeView.displayEmployeeMenu();
                    break;

                case 2:
                    CustomerView.displayCustomerMenu();
                    break;

                case 3:
                    FacilityView.displayFacilityMenu();
                    break;

                case 4:
                    BookingView.displayBookingMenu();
                    break;

                case 5:
                    PromotionView.displayPromotionMenu();
                    break;

                case 6:
                    System.exit(1);
                    break;

            }
        }
    }


}
