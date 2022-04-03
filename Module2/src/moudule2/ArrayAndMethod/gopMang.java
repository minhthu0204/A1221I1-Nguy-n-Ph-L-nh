package moudule2.ArrayAndMethod;

import java.util.Scanner;

public class gopMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstArraySize;
        int secondArraySize;

        System.out.println("Enter a first Array Size");
        firstArraySize = scanner.nextInt();

        int [] firstArray = new int[firstArraySize];

        for (int i = 0; i < firstArray.length; i++) {
            System.out.println("Enter element " + i + ": ");
            firstArray[i] = scanner.nextInt();
        }

        System.out.println("Enter a second Array Size");
        secondArraySize = scanner.nextInt();

        int [] secondArray = new int[secondArraySize];

        for (int i = 0; i < secondArray.length; i++) {
            System.out.println("Enter element " + i + ": ");
            secondArray[i] = scanner.nextInt();
        }

        int [] thirdArray = new int[firstArraySize + secondArraySize];

        for (int i = 0; i < firstArray.length; i++ ){
            thirdArray[i] = firstArray[i];
        }

        for (int i = 0; i < secondArray.length; i++ ){
            thirdArray[firstArray.length + i ]=secondArray[i];
        }

        System.out.println();
        for (int i = 0; i < thirdArray.length; i++){
            System.out.println(thirdArray[i]);
        }

    }
}
