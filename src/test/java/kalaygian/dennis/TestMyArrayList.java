package kalaygian.dennis;

import com.sun.javaws.exceptions.InvalidArgumentException;
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

    // get(int)
    @Test
    public void testGet(){
        // Given
        MyArrayList<String> myArrayList = new MyArrayList<String>(2);
        String element1 = "This is the element at index zero";
        String element2 = "This is the element at index one";
        myArrayList.set(0, element1);
        myArrayList.set(1, element2);
        // When
        String returnedElement = myArrayList.get(1);
        // Then
        Assert.assertEquals("Checking to see if the correct element was retrieved", element2, returnedElement);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGet_indexOutOfBoundsExceptionLow(){
        // Given
        MyArrayList<String> myArrayList = new MyArrayList<String>(2);
        String element1 = "This is the element at index zero";
        String element2 = "This is the element at index one";
        myArrayList.set(0, element1);
        myArrayList.set(1, element2);
        // When
        String returnedElement = myArrayList.get(-1);
        // Then
        // This statement will never be reached mwahahahahaha
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGet_indexOutOfBoundsExceptionHigh(){
        // Given
        MyArrayList<String> myArrayList = new MyArrayList<String>(3);
        String element1 = "This is the element at index zero";
        String element2 = "This is the element at index one";
        String element3 = "This is the element at index two";
        myArrayList.set(0, element1);
        myArrayList.set(1, element2);
        myArrayList.set(2, element3);
        // When
        String returnedElement = myArrayList.get(300);
        // Then
        // This statement will never be reached mwahahahahaha
    }

    @Test (expected = InvalidArgumentException.class)
    public void testGet_invalidArgumentException(){
        // Given
        MyArrayList<String> myArrayList = new MyArrayList<String>(2);
        String element1 = "This is the element at index zero";
        String element2 = "This is the element at index one";
        myArrayList.set(0, element1);
        myArrayList.set(1, element2);
        // When
        String returnedElement = myArrayList.get("This is gonna throw an error");
        // Then
        // This statement will never be reached mwahahahahaha
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

    // size()
    @Test
    public void testSize(){
        // Given
        MyArrayList<String> myArrayList = new MyArrayList<String>(10);
        int expectedSize = 10;
        // When
        int actualSize = myArrayList.size();
        // Then
        Assert.assertEquals("Checking to see if the correct value is returned", expectedSize, actualSize);
    }

    // remove(int)
    @Test
    public void testRemoveObjectByIndex(){
        // Given
        MyArrayList<String> myArrayList = new MyArrayList<String>(3);
        String element1 = "This is the first element";
        String element2 = "This is the second element";
        String element3 = "This is the third element";
        myArrayList.set(0, element1);
        myArrayList.set(1, element2);
        myArrayList.set(2, element3);
        String expectedObject = element2;
        // When
        String returnedObject = myArrayList.remove(1);
        // Then
        Assert.assertEquals("Checking to see if the correct object was removed", expectedObject, returnedObject);
    }

    @Test
    public void testRemoveObjectByIndex_arrayIsSmaller(){
        // Given
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>(3);
        myArrayList.set(0, 1);
        myArrayList.set(1, 2);
        myArrayList.set(2, 3);
        int expectedSize = 2;
        // When
        Integer removedObject = myArrayList.remove(0);
        // Then
        Assert.assertEquals("Checking to see if the array decreased in size", expectedSize, myArrayList.size());
    }

    @Test ()
    public void testRemoveObjectByIndex_differentiatesPrimitivesFromObjects(){
        // Given
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>(3);
        myArrayList.set(0, 1);
        myArrayList.set(1, 2);
        myArrayList.set(2, 3);
        Integer expectedInteger = 2;
        // When
        Integer returnInteger = myArrayList.remove(1);
        // Then
        Assert.assertEquals("Checking to see if the correct Integer was removed", expectedInteger, returnInteger);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveObjectByIndex_indexOutOfBoundsExceptionLow(){
        // Given
        MyArrayList<String> myArrayList = new MyArrayList<String>(3);
        // When
        myArrayList.remove(300);
        // Then
        // This statement cannot be reached!
    }

    // remove(Object)
    @Test
    public void testRemoveObjectByObject(){
        // Given
        MyArrayList<String> myArrayList = new MyArrayList<String>(2);
        myArrayList.set(0, "This is the first element");
        myArrayList.set(1, "This is the second element");
        boolean expectedValue = true;
        // When
        boolean returnValue = myArrayList.remove("This is the first element");
        // Then
        Assert.assertEquals("Checking to see if the correct boolean was returned", expectedValue, returnValue);
    }

    @Test
    public void testRemoveObjectByObject_listSizeShrinks(){
        // Given
        MyArrayList<String> myArrayList = new MyArrayList<String>(2);
        myArrayList.set(0, "This is the first element");
        myArrayList.set(1, "This is the second element");
        int expectedSize = 1;
        // When
        boolean returnValue = myArrayList.remove("This is the second element");
        // Then
        Assert.assertEquals("Checking to see if the list size shrank", expectedSize, myArrayList.size());
    }

    @Test
    public void testRemoveObjectByObject_objectNotInList(){
        // Given
        MyArrayList<String> myArrayList = new MyArrayList<String>(2);
        myArrayList.set(0, "This is the first element");
        myArrayList.set(1, "This is the second element");
        boolean expectedValue = false;
        // When
        boolean returnValue = myArrayList.remove("This element is not in the list");
        // Then
        Assert.assertEquals("Checking to see if the correct boolean was returned", expectedValue, returnValue);
    }

    @Test
    public void testRemoveObjectByObject_checkIfFirstOccurrence(){
        // Given
        MyArrayList<String> myArrayList = new MyArrayList<String>(3);
        myArrayList.set(0, "This is an element");
        myArrayList.set(1, "This is also an element");
        myArrayList.set(2, "This is an element");
        String expectedValue = "This is an element";
        // When
        boolean returnValue = myArrayList.remove("This is an element");
        // Then
        Assert.assertEquals("Checking to see if the second value of the removed element exists", expectedValue, myArrayList.get(1));
    }

    @Test ()
    public void testRemoveObjectByObject_differentiatesPrimitivesFromObjects(){
        // Given
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>(3);
        myArrayList.set(0, 1);
        myArrayList.set(1, 2);
        myArrayList.set(2, 3);
        Integer objectToRemove = 2;
        boolean expectedResult = true;
        // When
        boolean returnResult = myArrayList.remove(objectToRemove);
        // Then
        Assert.assertEquals("Checking to see if the Integer was removed", expectedResult, returnResult);
    }

    // clear()
    @Test
    public void testClear(){
        // Given
        MyArrayList<String> myArrayList = new MyArrayList<String>(3);
        myArrayList.set(0, "This is the first element");
        myArrayList.set(1, "This is the second element");
        myArrayList.set(2, "This is the third element");
        // When
        // Then
    }

//    + isEmpty(): boolean
//    + contains(Object)


//    + addAll(Collection<? extends E>)

}
