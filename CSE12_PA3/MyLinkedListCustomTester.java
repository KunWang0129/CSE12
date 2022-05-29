/**
 * @author Kun Wang
 * Date: 04/16/2022
 * Description: This is the custom tester file for PA3. 
 * It contains extra test cases for the MyLinkedList and Node classes.
 */

import static org.junit.Assert.*;


import org.junit.*;

/**
 * This class contains custom test cases that ensure basic functionality of
 * MyLinkList. 
 */
public class MyLinkedListCustomTester {

    private MyLinkedList<Object> objectLinkedList;
    private MyLinkedList<Object> emptyLinkedList;
    private MyLinkedList<String> stringLinkedList;
    private Object[] objData = {"a", 1, true};
    private String[] strData = {"a", "b", "c"};
    private int outOfBoundIndex = 100;

    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test.
     */
    @Before
    public void setUp() {
        emptyLinkedList = new MyLinkedList<>();
        objectLinkedList = new MyLinkedList<>();
        stringLinkedList = new MyLinkedList<>();
        for(int i = 0; i<objData.length; i++) {
            objectLinkedList.add(objData[i]);
        }
        for(int i = 0; i<strData.length; i++) {
            stringLinkedList.add(strData[i]);
        }
    }


    /**
     * Test the add method when element null is added to list
     */
    @Test
    public void testAdd() {
        boolean exceptionThrown = false;
        String n = null;
        try{
            stringLinkedList.add(n);
        } catch (NullPointerException e){
            exceptionThrown = true;
        }
        assertTrue("Except not thrown for illegal argument", exceptionThrown);
    }

    /**
     * Test the add with index method when element is added to 
     * a middle index of the list.
     */
    @Test
    public void testAddWithIndexTestOne() {
        String d = "d";
        stringLinkedList.add(1, d);
        assertEquals("Node with index 2 should point to the new node", 
            "d", stringLinkedList.head.getNext().getNext().getElement());
    }

    /**
     * Test the add with index method when null is added to list
     */	
    @Test
    public void testAddWithIndexTestTwo() {
        boolean exceptionThrown = false;
        String n = null;
        try{
            stringLinkedList.add(1,n);
        } catch (NullPointerException e){
            exceptionThrown = true;
        }
        assertTrue("Except not thrown for illegal argument", exceptionThrown);
    }

    /**
     * Test the get method when index is out of bounds
     */
    @Test
    public void testGet() {
        
        boolean exceptionThrown = false;
        try{
            stringLinkedList.get(outOfBoundIndex);
        } catch (IndexOutOfBoundsException e){
            exceptionThrown = true;
        }
        assertTrue("Except not thrown for illegal argument", exceptionThrown);
    }

    /**
     * Test the get method when index is out of bounds
     */
    @Test
    public void testGetNth() {
        boolean exceptionThrown = false;
        try{
            stringLinkedList.getNth(outOfBoundIndex);
        } catch (IndexOutOfBoundsException e){
            exceptionThrown = true;
        }
        assertTrue("Except not thrown for illegal argument", exceptionThrown);
    }

    /**
     * Test the set method when index is out of bounds
     */
    @Test
    public void testSet() {
        boolean exceptionThrown = false;
        try{
            stringLinkedList.set(outOfBoundIndex, "f");
        } catch (IndexOutOfBoundsException e){
            exceptionThrown = true;
        }
        assertTrue("Except not thrown for illegal argument", exceptionThrown);
    
    }

    /**
     * Test the remove method when index is out of bounds
     */
    @Test
    public void testRemoveTestOne() {
        boolean exceptionThrown = false;
        try{
            stringLinkedList.remove(outOfBoundIndex);
        } catch (IndexOutOfBoundsException e){
            exceptionThrown = true;
        }
        assertTrue("Except not thrown for illegal argument", exceptionThrown);
    }
    
    /**
     * Test the remove method when list is already empty
     */
    @Test
    public void testRemoveTestTwo() {
        boolean exceptionThrown = false;
        try{
            emptyLinkedList.remove(0);
        } catch (IndexOutOfBoundsException e){
            exceptionThrown = true;
        }
        assertTrue("Except not thrown for illegal argument", exceptionThrown);
    }

    /**
     * Test the clear method when list is already empty
     */
    @Test
    public void testClear() {
        emptyLinkedList.clear();
        assertEquals(0, emptyLinkedList.size);
    }

    /**
     * Test the size method when list is nonempty
     */
    @Test
    public void testSize() {

        assertEquals(strData.length, stringLinkedList.size());
    }
}