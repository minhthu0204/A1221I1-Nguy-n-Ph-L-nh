package FuramaResort.views;

import java.util.Scanner;

public class BookingView {
    static Scanner scanner = new Scanner(System.in);

    public static void displayBookingMenu() {
        System.out.println("-------------------------");
        System.out.println("1. Add new booking");
        System.out.println("2. Display list booking");
        System.out.println("3. Create new constracts");
        System.out.println("4. Display list contracts");
        System.out.println("5. Edit contracts");
        System.out.println("6. Return main menu");
        System.out.println("Enter your choice:");

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                HomeView.displayMainMenu();
                break;
        }
    }
}
