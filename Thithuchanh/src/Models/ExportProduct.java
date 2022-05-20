package Models;

public class ExportProduct extends Product {
    private double exportPrice;
    private String nation;

    public ExportProduct(int id, String code, String name, double price,
                         int quantity, String manufacturer, double exportPrice, String nation) {
        super(id, code, name, price, quantity, manufacturer);
        this.exportPrice = exportPrice;
        this.nation = nation;
    }

    public ExportProduct(double exportPrice, String nation) {
        this.exportPrice = exportPrice;
        this.nation = nation;
    }

    public ExportProduct(){

    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        return super.toString()+ exportPrice +","+ nation;
    }
}
