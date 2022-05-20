package moudule2.JavaCollectionFramework.PracticeUsingJavaCollectionFramework;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ProductManager listProducts = new ProductManager();
    public static void main(String[] args) {

        int choice;


        do {
            System.out.println("1. Add Product");
            System.out.println("2. Edit Product by ID");
            System.out.println("3. Delete Product ");
            System.out.println("4. Display Product");
            System.out.println("5. Search Product by Name");
            System.out.println("6. Sort Product ");
            System.out.println("7. Exit Program");
            System.out.println("Enter your choice");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1 :
                    listProducts.add(listProducts.addProduct());
                    break;
                case 2 :
                    System.out.println("Mời bạn nhập Id sản phẩm cần sửa");
                    int id = getId();
                    listProducts.edit(id,listProducts.addProduct());
                    break;
                case 3 :
                    listProducts.remove();
                    break;
                case 4 :
                    listProducts.display();
                    break;
                case 5 :
                    System.out.println("Mời bạn nhập tên sản phẩm cần tìm:");
                    String name=scanner.nextLine();
                    listProducts.findElementByName(name);
                    break;


            }
        }
        while (choice !=7);


    }
    private static int getId() {
        return Integer.parseInt(scanner.nextLine());
    }
}
