package moudule2.JavaCollectionFramework.Exercise.PracticeJavaCollection;

public class Product {
    private static int ID;
    private static String name;
    private static int price;

    public Product() {
    }

    public Product(int ID, String name, int price){
        this.ID = ID;
        this.name = name;
        this.price = price;
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        Product.ID = ID;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Product.name = name;
    }

    public static int getPrice() {
        return price;
    }

    public static void setPrice(int price) {
        Product.price = price;
    }
}
