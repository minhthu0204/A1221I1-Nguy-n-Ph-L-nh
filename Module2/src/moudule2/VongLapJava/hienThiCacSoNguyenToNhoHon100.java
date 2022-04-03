package moudule2.VongLapJava;

import java.util.Scanner;
public class hienThiCacSoNguyenToNhoHon100 {
    public static void main(String[] args){
        for (int i = 0; i<100 ;i++){
            if (isPrime(i)){
                System.out.println(i);
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
