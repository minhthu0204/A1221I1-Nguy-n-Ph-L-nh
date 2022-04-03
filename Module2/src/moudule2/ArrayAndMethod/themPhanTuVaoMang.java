package moudule2.ArrayAndMethod;

import java.util.Scanner;

public class themPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        int[] array;
        int k;

        System.out.println("Enter a size");
        size = scanner.nextInt();

        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter element " + i + ": ");
            array[i] = scanner.nextInt();
        }

        System.out.printf("%-20s%s", "Elements in array: ", "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }

        System.out.println("Enter number need to insert");
        int x = scanner.nextInt();

        System.out.println("Enter index of number need to insert");
        k = scanner.nextInt();


        int[] secondArray = new int[size+1];

        for (int i = 0; i < secondArray.length; i++){
            if (i<k){
                secondArray[i]=array[i];
            }
            else if (k==i){
                secondArray[k]=x;
            }
            else {
                secondArray[i]=array[i-1];
            }
        }
        for (int i = 0; i< secondArray.length; i++){
            System.out.println(secondArray[i]);
        }



    }
}
