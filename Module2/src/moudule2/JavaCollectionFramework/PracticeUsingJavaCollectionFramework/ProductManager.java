package moudule2.JavaCollectionFramework.PracticeUsingJavaCollectionFramework;

import java.net.IDN;
import java.util.ArrayList;
import java.util.Scanner;


public class ProductManager {
    static Scanner scanner = new Scanner(System.in);
    ArrayList<Product> listProducts =new ArrayList<>();

    public ProductManager(ArrayList<Product> listProducts) {
        this.listProducts = listProducts;
    }

    public ProductManager(){

    }

    public void edit(int id, Product product){
        int index=-1;
        for (int i=0;i< listProducts.size();i++){
            if (listProducts.get(i).getID()==(id)){
                index=i;
                break;
            }
        }
        if (index!=-1){
            listProducts.add(index,product);
            listProducts.remove(index+1);
        }
    }

    public void findElementByName(String name){
        int index=-1;
        for (int i=0;i< listProducts.size();i++){
            if (listProducts.get(i).getProductName().equals(name)){
                index=i;
                break;
            }
        }
        if(index!=-1){
            System.out.println("Thông tin sản phẩm cần tìm:");
            System.out.printf("%-12s%-15s%s","Id","Name Product","Price\n");
            System.out.printf("%-12s%-15s%s",listProducts.get(index).getID(),listProducts.get(index).getProductName(),listProducts.get(index).getPrice());
            System.out.println();
        }
        else {
            System.out.println("Không có sản phẩm trong kho!");
        }
    }

    public void add(Product product){

        listProducts.add(product);

    }

    public Product addProduct(){
        System.out.println("Enter the ID: ");
        int ID = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the price: ");
        int price = Integer.parseInt(scanner.nextLine());
        return  new  Product(ID,name,price);
    }




    public void display(){
        System.out.printf("%-12s%-12s%-12s%s","STT", "Id","Name","Price\n");
        for (int i=0;i< listProducts.size();i++){
            System.out.printf("%-12s%-12s%-12s%s",(i+1),listProducts.get(i).getID(),listProducts.get(i).getProductName(),listProducts.get(i).getPrice());
            System.out.println();
        }
    }

    public void remove(){
        System.out.println("Enter ID element that you want to delete");
        int ID = Integer.parseInt(scanner.nextLine());
        boolean isHere = false;        
        int index = 0;
        for (int i =0; i<listProducts.size();i++){
            if (listProducts.get(i).getID() == ID){
                isHere = true;
                index = i;
            }
            if (isHere){
                listProducts.remove(index);
            }
        }
    }
}
