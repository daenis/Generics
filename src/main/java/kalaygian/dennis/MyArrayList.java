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

    public E[] getMyArray() {
        return myArray;
    }

    //    + add(E)
//    + add(E, int)
//    + get(): E
//    + set(E)
//    + remove()
//    + clear()
//    + isEmpty(): boolean
//    + contains(Object)
//    + remove(int): E
//    + remove(Object): boolean
//    + size():int
//    + addAll(Collection<? extends E>)

}
