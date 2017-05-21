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

    public void add(E element){
        E[] newArray = growArrayBy(1);
        newArray[myArray.length] = element;
        myArray = newArray;
    }

    private E[] growArrayBy(int size){
        E[] newArray = (E[]) new Object[myArray.length + size];
        for(int index = 0; index < myArray.length; index++){
            newArray[index] = myArray[index];
        }
        return newArray;
    }

    public int size(){
        return myArray.length;
    }

}
