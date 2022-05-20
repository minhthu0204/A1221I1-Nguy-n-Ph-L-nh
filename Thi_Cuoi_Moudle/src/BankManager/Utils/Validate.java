package BankManager.Utils;

import BankManager.Models.Account;
import BankManager.Service.BankService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static final String DATE_REG="^\\d{1,2}\\/\\d{1,2}\\/\\d{1,4}$";
    private static BankService bankingService=new BankService();
    static Scanner scanner = new Scanner(System.in);
    public static int getInt(){
        int result;
        while (true){
            try {
                result = Integer.parseInt(scanner.nextLine());
                if(result>=0){
                    break;
                }
                else {
                    System.err.println("Dữ liệu phải lớn hơn không. Hãy nhập lại: ");
                }

            }
            catch (Exception e){
                System.err.println("Nhập không đúng định dạng. Hãy nhập lại: ");
            }
        }
        return result;
    }

    public  static String getString(){
        String result;
        while (true){
            result = scanner.nextLine();
            if (!result.trim().equals("")){
                break;
            }
            else {
                System.err.println("Dữ liệu không được để trống. Hãy nhập lại: ");
            }
        }
        return result;
    }

    public static Double getDouble(){
        Double result;
        while (true){
            try {
                result = Double.parseDouble(scanner.nextLine());
                if(result>=0){
                    break;
                }
                else {
                    System.err.println("Dữ liệu phải là số dương. Hãy nhập lại: ");
                }

            }
            catch (Exception e){
                System.err.println("Nhập không đúng định dạng. Hãy nhập lại: ");
            }
        }
        return result;
    }

    public static int getIntFive(){
        int result;
        while (true){
            try {
                result = Integer.parseInt(scanner.nextLine());
                if(result>0 && result<6){
                    break;
                }
                else {
                    System.err.println("Nhập lựa chọn có giá trị từ 1 đến 5. Hãy nhập lại: ");
                }

            }
            catch (Exception e){
                System.err.println("Nhập không đúng định dạng. Hãy nhập lại: ");
            }
        }
        return result;
    }

    public static int getIntTwo(){
        int result;
        while (true){
            try {
                result = Integer.parseInt(scanner.nextLine());
                if(result>0 && result<3){
                    break;
                }
                else {
                    System.err.println("Nhập lựa chọn có giá trị từ 1 đến 2. Hãy nhập lại: ");
                }

            }
            catch (Exception e){
                System.err.println("Nhập không đúng định dạng. Hãy nhập lại: ");
            }
        }
        return result;
    }

    public static boolean isDate(String val){
        Pattern pattern = Pattern.compile(DATE_REG);
        Matcher matcher = pattern.matcher(val);
        return matcher.matches();
    }
    public static boolean isExistsId(int id, List<Account> list){
        return list.stream().anyMatch(e->e.getId() == id);
    }
    public static boolean checkValidDate(String dateString){
        if(!isDate(dateString)){
            return false;
        }
        else {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false); // set false để kiểm tra tính hợp lệ của date. VD: tháng 2 phải có 28-29 ngày, năm có 12 tháng,....
            try {
                df.parse(dateString); // parse dateString thành kiểu Date
                return true;
            }
            catch (ParseException e) { // quăng lỗi nếu dateString ko hợp lệ
                return false;
            }
        }
    }

}
