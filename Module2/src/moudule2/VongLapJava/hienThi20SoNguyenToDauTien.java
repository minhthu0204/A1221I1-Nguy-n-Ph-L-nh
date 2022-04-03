package moudule2.VongLapJava;

public class hienThi20SoNguyenToDauTien {
    public static void main(String[] args){
        int number = 20;
        int count = 0;
        for (int i = 0; count<= number;i++){
            if (isPrime(i)){
                System.out.println(i);
                count++;
            }
        }
    }
    public static boolean isPrime(int number){
        boolean check = true;
        if(number < 2){
            check = false;
        }
        else {
            for(int i=2; i < number; i++){
                if (number%i==0){
                    check =false;
                    break;
                }
            }
        }
        return check;
    }
}
