package moudule2.JavaCollectionFramework.PracticeUsingJavaCollectionFramework;

public class Product {
    public int ID;
    public String productName;
    public int price;

    public Product(int ID, String productName, int price) {
        this.ID = ID;
        this.productName = productName;
        this.price = price;
    }

    public Product(){

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
