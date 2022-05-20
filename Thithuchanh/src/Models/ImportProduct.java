package Models;

public class ImportProduct extends Product{
    private double importPrice;
    private String city;
    private double tax;

    public ImportProduct(int id, String code, String name, double price,
                         int quantity, String manufacturer, double importPrice, String city, double tax) {
        super(id, code, name, price, quantity, manufacturer);
        this.importPrice = importPrice;
        this.city = city;
        this.tax = tax;
    }

    public ImportProduct(double importPrice, String city, double tax) {
        this.importPrice = importPrice;
        this.city = city;
        this.tax = tax;
    }

    public ImportProduct(){

    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return super.toString()+ importPrice +","+ city+","+tax;
    }
}
