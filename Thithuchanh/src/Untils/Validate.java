package Untils;

import java.util.Scanner;

public class Validate {
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

    public static double getDouble(){
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
}
