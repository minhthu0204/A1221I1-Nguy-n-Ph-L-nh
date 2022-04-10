package moudule2.DSA.ArrayList;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    //chỉ truyền "int capacity" vào khi muốn thay đổi tham số, nhưng final nên ko cần truyền vào
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int a) {
        elements = new Object[a];
    }

    //tăng lenghth lên
    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(E element, int index) {
        if(index>=0 && index<=size){
            size +=1;
            ensureCapa();
            for (int i = size-1; i >=index ; i--) {
                elements[i+1] = elements[i];
            }
            elements[index] = element;
        }
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }

    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        } else {
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            size--;
        }
    }

    public int getSize(){
        return size;
    }

    public int indexOf(E e){
        for (int i = 0; i < size; i++) {
            if(elements[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    public boolean contains (E e){
        for (int i = 0; i < size; i++) {
            if(elements[i].equals(e)){
                return true;
            }
        }
        return false;
    }
}
