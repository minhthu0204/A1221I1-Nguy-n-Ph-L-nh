package FuramaResort.views;

import java.util.Scanner;

public class PromotionView {
    static Scanner scanner = new Scanner(System.in);
    public static void displayPromotionMenu(){
        System.out.println("-------------------------");
        System.out.println("1. Display list customers use service");
        System.out.println("2. Display list customers get voucher");
        System.out.println("3. Return main menu");
        System.out.println("Enter your choice:");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                HomeView.displayMainMenu();
                break;
        }
    }
}
