package moudule2.ArrayAndMethod;

import java.util.Scanner;

public class xoaPhanTuKhoiMang {
    public static void main(String[] args) {
        int size;
        int [] array;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Enter a size");
            size = scanner.nextInt();
            if (20> size){
                System.out.println("Size does not exceed 20");
            }
        }while (size>20);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.println("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.printf("%-20s%s", "Elements in array: ", "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        System.out.println("Nhập số nguyên k: ");
        int k = scanner.nextInt();

        int d = 0;
        for (int c = i = 0;i< size; i++){
            if (array[i] != k){
                array[c] = array[i];
                c++;
                d =c ;
            }
        }

        for (i= size - d +1 ;i<size;i++){
            array[i]=0;
        }
        for ( i = 0; i< size; i++){
            System.out.println(array[i]);
        }

    }

}
