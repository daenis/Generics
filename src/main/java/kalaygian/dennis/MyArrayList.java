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
    

}
