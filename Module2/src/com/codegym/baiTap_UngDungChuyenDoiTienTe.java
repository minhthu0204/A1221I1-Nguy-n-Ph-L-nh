package com.codegym;
import java.util.Scanner;

public class baiTap_UngDungChuyenDoiTienTe {
    public static void main(String[] args) {
        double vnd =23000;
        double usd ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập USD: ");
        usd= scanner.nextDouble();
        double quyDoi = usd*23000;
        System.out.println("Gía trị VND: "+ quyDoi);
    }
}
