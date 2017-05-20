package kalaygian.dennis;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by denniskalaygian on 5/19/17.
 */
public class TestMyArrayList {

    // set(int, E)
    @Test
    public void testSet(){
        // Given
        MyArrayList<String> myArrayList = new MyArrayList<String>(2);
        String expectedElement = "This is the element stored in index 1";
        // When
        myArrayList.set(1, expectedElement);
        // Then
        Assert.assertEquals("Checking to see if the first element was set to the correct value", expectedElement, myArrayList.get(1));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSet_indexOutOfBoundsLow() {
        // Given
        MyArrayList<String> myArrayList = new MyArrayList<String>(2);
        String expectedElement = "This is the element stored in index -1";
        // When
        myArrayList.set(-1, expectedElement);
        // Then
        // This will never be reached :(
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSet_indexOutOfBoundsHigh() {
        // Given
        MyArrayList<String> myArrayList = new MyArrayList<String>(2);
        String expectedElement = "This is the element stored in index 300";
        // When
        myArrayList.set(300, expectedElement);
        // Then
        // This will never be reached :(
    }

    @Test (expected = ClassCastException.class)
    public void testSet_classCastException() {
        // Given
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>(2);
        String errorElement = "I'm going to throw an error yay!";
        // When
        myArrayList.set(1, errorElement);
        // Then
        // This will never be reached :(
    }

    // add(e)
    @Test
    public void testAddElement_elementAdded(){
        // Given
        MyArrayList<String> myArrayList = new MyArrayList<String>();
        int expectedSize = 1;
        // When
        myArrayList.add("I hope that this works");
        // Then
        Assert.assertEquals("Checking to see if the method added an element", expectedSize, myArrayList.size());
    }

    @Test
    public void testAddElement_correctElementAdded(){
        // Given
        MyArrayList<String> myArrayList = new MyArrayList<String>();
        String expectedElement = "I hope that this works";
        // When
        myArrayList.add(expectedElement);
        // Then
        Assert.assertEquals("Checking to see if the method added an element", expectedElement, myArrayList.get(0));
    }

    @Test
    public void testAddElement_elementAddedToEnd(){
        // Given
        MyArrayList<String> myArrayList = new MyArrayList<String>(2);
        myArrayList.set(0, "This is the first element");
        myArrayList.set(1, "This is the second element");
        String expectedElement = "This is the third element";
        // When
        myArrayList.add(expectedElement);
        // Then
        Assert.assertEquals("Checking to see if the method added an element to the end", expectedElement, myArrayList.get(2));
    }

    @Test (expected = ClassCastException.class)
    public void testAddElement_classCastException(){
        // Given
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
        // When
        myArrayList.add("This will throw an error.");
        // Then
        // This statement should never be reached
    }

    // add(int, e)
    @Test
    public void testAddElementByIndex_elementAdded(){
        // Given
        MyArrayList<String> myArrayList = new MyArrayList<String>(3);
        String expectedElement = "This is the value of index one";
        // When
        myArrayList.add(1, expectedElement);
        // Then
        Assert.assertEquals("Checking to see if the correct element was added to the correct index", expectedElement, myArrayList.get(1));
    }

    @Test
    public void testAddElementByIndex_elementAddedBeyondBounds(){
        // Given
        MyArrayList<String> myArrayList = new MyArrayList<String>(3);
        String expectedElement = "This is the value of index five";
        // When
        myArrayList.add(5, expectedElement);
        // Then
        Assert.assertEquals("Checking to see if the element was added appropriately", expectedElement, myArrayList.get(5));
    }

    @Test
    public void testAddElementByIndex_elementAddedBeyondBoundsNullPads(){
        // Given
        MyArrayList<String> myArrayList = new MyArrayList<String>(3);
        String addedElement = "This is the value of index five";
        String padValue = null;
        // When
        myArrayList.add(5, addedElement);
        // Then
        Assert.assertEquals("Checking to see if the added element generated null padding", padValue, myArrayList.get(4));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddElementByIndex_addedToNegativeIndex(){
        // Given
        MyArrayList<String> myArrayList = new MyArrayList<String>(3);
        String addedElement = "This will throw an error";
        // When
        myArrayList.add(-1, addedElement);
        // Then
        // Doesn't matter!
    }

    @Test
    public void testAddElementByIndex_addedToExistingElement(){
        // Given
        MyArrayList<String> myArrayList = new MyArrayList<String>(2);
        String element1 = "This is the first element";
        String element2 = "This is the second element";
        String element3 = "This is the third element";
        myArrayList.set(0, element1);
        myArrayList.set(1, element3);
        // When
        myArrayList.add(1, element2);
        // Then
        Assert.assertEquals("Checking to see if the element caused an appropriate shift", element3, myArrayList.get(2));
    }


//    + remove()
//    + clear()
//    + isEmpty(): boolean
//    + contains(Object)
//    + remove(int): E
//    + remove(Object): boolean
//    + size():int
//    + addAll(Collection<? extends E>)

}
