package Views;

import Models.ExportProduct;
import Models.ImportProduct;
import Models.Product;
import Services.NotFoundProductException;
import Services.ProductService;
import Untils.Validate;

import java.util.List;
import java.util.Scanner;
public class ProductView {
    static Scanner scanner = new Scanner(System.in);
    static ProductService productService = new ProductService();
    public static void displayMenu() {
        while (true) {
            System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM----");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách các sản phẩm");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Thoát");

            System.out.println("Chọn chức năng theo số để tiếp tục.");
            int choice = Validate.getIntFive();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    searchByName();
                    break;
                case 5:
                    System.exit(1);
                    break;

            }
        }
    }

    private static void add() {
        System.out.println("1. Sản phẩm nhập khẩu");
        System.out.println("2. Sản phẩm xuất khẩu");
        System.out.println("Chọn chức năng theo số để tiếp tục:");
        int choice = Validate.getIntTwo();
        System.out.println("Mã sản phẩm: ");
        String code = Validate.getString();
        System.out.println("Tên sản phẩm: ");
        String name = Validate.getString();
        System.out.println("Gía bán: ");
        double price = Validate.getDouble();
        System.out.println("Số lượng: ");
        int quantity = Validate.getInt();
        System.out.println("Nhà sản xuất: ");
        String manufacturer = Validate.getString();
        Product product;
        if (choice == 1) {
            System.out.println("Gía nhập khẩu: ");
            double importPrice = Validate.getDouble();
            System.out.println("Tỉnh thành nhập: ");
            String city = Validate.getString();
            System.out.println("Thuế nhập khẩu: ");
            double tax = Validate.getDouble();

            product = new ImportProduct(0, code, name, price, quantity, manufacturer, importPrice, city, tax);
        } else {
            System.out.println("Gía xuất khẩu: ");
            double exportPrice = Validate.getDouble();
            System.out.println("Số tiền trong tài khoản: ");
            String nation = Validate.getString();

            product = new ExportProduct(0, code, name, price, quantity,manufacturer, exportPrice, nation);
        }
        productService.create(product);
        System.out.println("Tạo tài khoản thành công");
    }


    private static void delete() {
        display();
        boolean isExists;
        System.out.println("Nhập Mã của sản phẩm muốn xóa:");
        do {
            try {
                String code = Validate.getString();
                productService.delete(code);
                System.out.println("Xóa tài khoản thành công ");
                isExists = false;
            } catch (NotFoundProductException e) {
                System.out.println(e.getMessage() + " Vui lòng nhập lại:");
                isExists = true;
            }
        } while (isExists);
    }
    private static void display() {
        List<Product> products = productService.findAll();
        if (products.size() > 0) {
            for (Product p : products) {
                if (p instanceof ImportProduct) {
                    System.out.printf("Sản phẩm nhập khẩu: Id Sản phẩm: %s, Mã sản phẩm: %s, Tên sản phẩm: %s, " +
                                    "Gía bán: %s, Số lượng: %s, Nhà sản xuất: %s," +
                                    " Gía nhập khẩu: %s, Tỉnh thành nhập khẩu: %s,Thuế nhập khẩu:%s \n"
                            , p.getId(), p.getCode(), p.getName(), p.getPrice(), p.getQuantity(),
                            p.getManufacturer(), ((ImportProduct) p).getImportPrice(), ((ImportProduct) p).getCity(),
                            ((ImportProduct) p).getTax());
                } else {
                    System.out.printf("Sản phẩm xuất khẩu: Id Sản phẩm: %s, Mã sản phẩm: %s, Tên sản phẩm: %s, " +
                                    "Gía bán: %s, Số lượng: %s, Nhà sản xuất: %s," +
                                    " Gía xuất khẩu: %s, Quốc gia nhập sản phẩm: %s\n"
                            , p.getId(), p.getCode(), p.getName(), p.getPrice(), p.getQuantity(),
                            p.getManufacturer(), ((ExportProduct) p).getExportPrice()
                            , ((ExportProduct) p).getNation());
                }
            }
        } else {
            System.out.println("Product List is empty");
        }
    }

    private static void searchByName() {
        System.out.println("Enter name to search:");
        String name = scanner.nextLine();
        List<Product> products = productService.searchByName(name);

        for (Product p : products) {
            if (p instanceof ImportProduct) {
                System.out.printf("Sản phẩm nhập khẩu: Id Sản phẩm: %s, Mã sản phẩm: %s, Tên sản phẩm: %s, " +
                                "Gía bán: %s, Số lượng: %s, Nhà sản xuất: %s," +
                                " Gía nhập khẩu: %s, Tỉnh thành nhập khẩu: %s,Thuế nhập khẩu:%s \n"
                        , p.getId(), p.getCode(), p.getName(), p.getPrice(), p.getQuantity(),
                        p.getManufacturer(), ((ImportProduct) p).getImportPrice(), ((ImportProduct) p).getCity(),
                        ((ImportProduct) p).getTax());
            } else {
                System.out.printf("Sản phẩm xuất khẩu: Id Sản phẩm: %s, Mã sản phẩm: %s, Tên sản phẩm: %s, " +
                                "Gía bán: %s, Số lượng: %s, Nhà sản xuất: %s," +
                                " Gía xuất khẩu: %s, Quốc gia nhập sản phẩm: %s\n"
                        , p.getId(), p.getCode(), p.getName(), p.getPrice(), p.getQuantity(),
                        p.getManufacturer(), ((ExportProduct) p).getExportPrice()
                        , ((ExportProduct) p).getNation());
            }
        }
    }


    public static void main(String[] args) {
        displayMenu();
    }
}
