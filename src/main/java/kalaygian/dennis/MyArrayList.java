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
        newArray[size()] = element;
        myArray = newArray;
    }

    private E[] growArrayBy(int size){
        E[] newArray = (E[]) new Object[size() + size];
        for(int index = 0; index < size(); index++){
            newArray[index] = myArray[index];
        }
        return newArray;
    }

    public int size(){
        return myArray.length;
    }

    public void add(int index, E element){
        if(index <= size() && get(index) == null)set(index, element);
        else if(index <= size())myArray = insertElementAt(index, element);
        else paddedInsert(index, element);
    }

    private void paddedInsert(int index, E element){
        myArray = growArrayBy(index + 1);
        myArray[index] = element;
    }

    private E[] insertElementAt(int index, E element){
        E[] newArray = growArrayBy(1);
        newArray = fillFirstPart(index, newArray);
        newArray[index] = element;
        newArray = fillSecondPart(index, newArray);
        return newArray;
    }

    private E[] fillFirstPart(int index, E[] newArray){
        for(int i = 0; i < index; i++){
            newArray[i] = myArray[i];
        }
        return newArray;
    }

    private E[] fillSecondPart(int index, E[] newArray){
        for(int i = index + 1; i < size() + 1; i++){
            newArray[i] = myArray[i - 1];
        }
        return newArray;
    }

    public E remove(int index){
        E returnedElement = get(index);
        set(index, null);
        return returnedElement;
    }

    public boolean remove(Object element){
        for(int index = 0; index < size(); index++){
            if(element.equals(get(index))) return nullifyIndex(index);
        }
        return false;
    }

    private boolean nullifyIndex(int index){
        set(index, null);
        return true;
    }

    public void clear(){
        for(int index = 0; index < size(); index++){
            myArray[index] = null;
        }
    }




}
