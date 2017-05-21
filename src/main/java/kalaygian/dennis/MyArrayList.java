package kalaygian.dennis;

import java.lang.reflect.*;


/**
 * Created by denniskalaygian on 5/19/17.
 */
public class MyArrayList<E> {

    private E[] myArray;

    public MyArrayList(){
        myArray = (E[]) new Object[0];
    }

    public MyArrayList(int initialSize){
        myArray = (E[]) new Object[initialSize];
    }

    public void set(int index, E element) throws IndexOutOfBoundsException{
        myArray[index] = element;
    }

    public E get(int index){
        return myArray[index];
    }

}
