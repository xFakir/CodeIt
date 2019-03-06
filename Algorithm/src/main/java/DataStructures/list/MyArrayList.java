package DataStructures.list;

import java.util.Arrays;

/**
 * @ClassName : MyArrayList
 * @Description :
 * @Author : xcx
 * @Date : 2019-02-11 19:28
 * @Version : 1.0
 */
public class MyArrayList<T> {
    private final static int DEFAULT_CAPACITY = 10;

    private Object[] elementData;

    private int capacity;

    private int count;

    MyArrayList(){
        capacity = DEFAULT_CAPACITY;
        init(DEFAULT_CAPACITY);
    }

    MyArrayList(int capacity){
        init(capacity);
    }

    private void init(int capacity){
        if(capacity > 0){
            elementData = new Object[capacity];
            count = 0;
        } else {
            throw new IllegalArgumentException("capacity can not be below zero");
        }

    }


    private void ensureCapacity(){
        if(count >= capacity){
            capacity = capacity*2;
            elementData = Arrays.copyOf(elementData,capacity);

        }
    }

    private void checkRange(int index){
        if(index < 0 || index >= count){
            throw new ArrayIndexOutOfBoundsException("out of bounds");
        }
    }

    public T set(int index,T data){
        checkRange(index);
        T oldData = (T) elementData[index];
        elementData[index] = data;
        return oldData;
    }

    public T get(int index){
        checkRange(index);
        return (T) elementData[index];
    }

    public boolean add(T data){
        ensureCapacity();
        elementData[count++] = data;
        return true;
    }

    public T remove(int index){
        checkRange(index);
        T removeData = (T) elementData[index];
        for (int i = index; i < count-1; i++) {
            elementData[i] = elementData[i + 1];
        }
        count--;
        return removeData;
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count==0;
    }
}
