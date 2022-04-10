package moudule2.DSA.ArrayList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> integerList = new MyList<>();
        integerList.add(0,1);
        integerList.add(1,2);
        integerList.add(2,3);
        integerList.add(3,4);
        integerList.add(4,5);



        System.out.println(integerList.get(0));
        System.out.println(integerList.get(1));
    }
}
