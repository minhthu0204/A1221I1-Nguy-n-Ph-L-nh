package moudule2.ExceptionAndDebug.Practice;

import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    public static Integer[] createRandom() {
        Random rd = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("Danh sách phần tử của mảng: " );
        for (int i = 0; i < 100; i++) {
            arr[i] = rd.nextInt(100);
            System.out.print(arr[i]+ " ");
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayExample arrayExample = new ArrayExample();

        Integer[] array = arrayExample.createRandom();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chỉ số của phần tử bất kỳ: ");
        int x = Integer.parseInt(scanner.nextLine());

        try {
            System.out.println("Gía trị của phần tử có trị số "+ x + " là: "+ array[x]);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println(" Chỉ số vượt qus giới hạn của mảng");
        }
    }
}
