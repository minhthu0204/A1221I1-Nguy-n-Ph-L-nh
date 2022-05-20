package Services;

import Models.ExportProduct;
import Models.ImportProduct;
import Models.Product;
import Untils.Constant;
import Untils.FileHelper;
import Untils.Validate;
import Views.ProductView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductService {
    private List<Product> productList = new ArrayList<>();

    FileHelper fileHelper = new FileHelper();

    public ProductService() {
        productList = mapToProducts();
    }

    public void create(Product product){

        int lastId = 0;
        if(productList.size() > 0){
            lastId = productList.get(productList.size() - 1).getId();
        }

        product.setId(lastId + 1);
        productList.add(product);
        fileHelper.write(Constant.path, Collections.singletonList(product), true);
    }

    public void delete(String code) throws NotFoundProductException {
        Boolean flag = false;
        int index = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getCode().equals(code)){
                index = i;
                flag = true;
            }
        }
        if (flag) {
            System.out.println("Bạn có muốn xóa hay không");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Validate.getIntTwo();
            if (choice==1){
                productList.remove(index);
                fileHelper.write(Constant.path,productList,false);
                return;
            }
            else {
                ProductView.displayMenu();
            }
        } else {
            throw new NotFoundProductException ("Không thể tìm thấy mã sản phẩm: " + code + " trong danh sách");
        }

    }

    public List findAll(){
        return productList;
    }

    public List searchByName(String name){
        List result = new ArrayList();

        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getName().contains(name)){
                result.add(productList.get(i));
            }
        }

        return result;
    }

    private List mapToProducts(){
        List result = new ArrayList();

        List<String> lines = fileHelper.read(Constant.path);
        for (String line : lines){
            String[] tmp = line.split(",");
            int id = Integer.parseInt(tmp[0]);
            String code = tmp[1];
            String name = tmp[2];
            double price = Double.parseDouble(tmp[3]);
            int quantity = Integer.parseInt(tmp[4]);
            String manufacturer = tmp[5];


            if(tmp.length == 9){
                double importPrice = Double.parseDouble(tmp[6]);
                String city = tmp[7];
                double tax = Double.parseDouble(tmp[8]);
                result.add( new ImportProduct(0, code, name, price, quantity, manufacturer, importPrice, city, tax));
            }
            else {
                double exportPrice = Double.parseDouble(tmp[6]) ;
                String nation = tmp[7];
                result.add(new ExportProduct(0, code, name, price, quantity,manufacturer, exportPrice, nation));
            }
        }

        return result;
    }
}
