/**
 * Name: Kun Wang
 * ID: A16807435
 * Email: kuw010@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * 2-4 sentence file description here
 * This file contains all custom tests for PA6. It is design to test
 * methods with different conditions of PublicTester
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 * This class contains all custom testers for PA6
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {
    // ----------------MyDeque class----------------
    /**
     * Test the constructor when initial capacity is -1
     */
    @Test
    public void testMyDequeConstructor() {
        boolean exceptionThrown = false;
        try{
            MyDeque D = new MyDeque<>(-1);
        } catch (IllegalArgumentException e){
            exceptionThrown = true;
        }

        assertTrue(exceptionThrown);
    }

    /**
     * Test the expandCapacity method when elements are spread
     */
    @Test
    public void testMyDequeExpandCapacity() {

        MyDeque D = new MyDeque<>(6);
        Integer[] orig = {3, null, 2, 5, 6, 7};
        Integer[] after = {2,5,6,7,3,null,null,null,null,null,null,null};
        D.data = orig;
        D.front = 2;
        D.rear = 0;
        D.size = 5;
        D.expandCapacity();
        assertArrayEquals(after, D.data);
    }

    /**
     * Test the addFirst method when index 0 is taken
     */
    @Test
    public void testAddFirst() {
        MyDeque D = new MyDeque<>(6);
        Integer[] orig = {3, null, 2, 5, 6, 7};
        Integer[] after = {3,1,2,5,6,7};
        D.data = orig;
        D.front = 2;
        D.rear = 0;
        D.size = 5;
        D.addFirst(1);;
        assertArrayEquals(after, D.data);
    }

    /**
     * Test the addLast method when last element is taken
     */
    @Test
    public void testAddLast() {
        MyDeque D = new MyDeque<>(6);
        Integer[] orig = {3, null, 2, 5, 6, 7};
        Integer[] after = {3,8,2,5,6,7};
        D.data = orig;
        D.front = 2;
        D.rear = 0;
        D.size = 5;
        D.addLast(8);;
        assertArrayEquals(after, D.data);
    }

    /**
     * Test the removeFirst method when front is behind rear
     */
    @Test
    public void testRemoveFirst() {
        MyDeque D = new MyDeque<>(6);
        Integer[] orig = {3, null, 2, 5, 6, 7};
        Integer[] after = {3,null,null,5,6,7};
        D.data = orig;
        D.front = 2;
        D.rear = 0;
        D.size = 5;
        D.removeFirst();
        assertArrayEquals(after, D.data);
        assertEquals(3, D.front);
    }

    /**
     * Test the removeLast method when rear is in
     * front of front
     */
    @Test
    public void testRemoveLast() {
        MyDeque D = new MyDeque<>(6);
        Integer[] orig = {3, null, 2, 5, 6, 7};
        Integer[] after = {null,null,2,5,6,7};
        D.data = orig;
        D.front = 2;
        D.rear = 0;
        D.size = 5;
        D.removeLast();
        assertArrayEquals(after, D.data);
        assertEquals(5, D.rear);
    }

    /**
     * Test the peekFirst method when front is not actually
     * in front
     */
    @Test
    public void testPeekFirst(){
        MyDeque D = new MyDeque<>(6);
        Integer[] orig = {3, null, 2, 5, 6, 7};
        D.data = orig;
        D.front = 2;
        D.rear = 0;
        D.size = 5;
        assertEquals(2, D.peekFirst());
    }

    /**
     * Test the peekLast method when rear isn't at rear
     */
    @Test
    public void testPeekLast(){
        MyDeque D = new MyDeque<>(6);
        Integer[] orig = {3, null, 2, 5, 6, 7};
        D.data = orig;
        D.front = 2;
        D.rear = 0;
        D.size = 5;
        assertEquals(3, D.peekLast());
    }

    // ----------------MyStack class----------------
    /**
     * Test MyStack when stack with no element is manipulated
     * many times
     */
    @Test
    public void testMyStack(){
        // You can test any method from MyStack or a combination of methods
        MyDeque D = new MyDeque<>(3);
        Integer[] orig = {null,null,null};
        Integer[] change1 = {1,3,2};
        Integer[] change2 = {3,2,1,null,null,4};
        Integer[] change3 = {3,2,1,null,null,null};
        MyStack S = new MyStack<>(3);
        assertArrayEquals(orig, S.theStack.data);
        S.push(1);
        S.push(2);
        S.push(3);
        assertArrayEquals(change1, S.theStack.data);
        assertEquals(1, S.theStack.front);
        S.push(4);
        assertArrayEquals(change2, S.theStack.data);
        assertEquals(5, S.theStack.front);
        S.pop();
        assertArrayEquals(change3, S.theStack.data);
        
    }

    // ----------------MyQueue class----------------
    /**
     * Test MyQueue when empty queue is manipulated many times
     */
    @Test
    public void testMyQueue(){
        // You can test any method from MyQueue or a combination of methods
        Integer[] orig = {null,null,null};
        Integer[] change1 = {1,2,3};
        Integer[] change2 = {1,2,3,4,null,null};
        Integer[] change3 = {null,2,3,4,null,null};
        MyQueue Q = new MyQueue<>(3);
        assertArrayEquals(orig, Q.theQueue.data);
        Q.enqueue(1);
        Q.enqueue(2);
        Q.enqueue(3);
        assertArrayEquals(change1, Q.theQueue.data);
        assertEquals(0, Q.theQueue.front);
        Q.enqueue(4);
        assertArrayEquals(change2, Q.theQueue.data);
        assertEquals(0, Q.theQueue.front);
        Q.dequeue();
        assertArrayEquals(change3, Q.theQueue.data);
    }

    @Test
    public void testRemoveFirst2(){
        MyDeque D = new MyDeque<>(6);
        Integer[] orig = {3, 1,null, 2};
        Integer[] after = {null,null,null,null};
        D.data = orig;
        D.front = 3;
        D.rear = 1;
        D.size = 3;
        assertEquals(2,D.removeFirst());
        assertEquals(3,D.removeFirst());

        assertEquals(1, D.front);
        assertEquals(1, D.rear);
        assertEquals(1, D.size);

        assertEquals(1,D.removeFirst());
        assertArrayEquals(after, D.data);
        assertEquals(1, D.front);
        assertEquals(1, D.rear);
        assertEquals(0, D.size);

        assertEquals(null,D.removeFirst());

    }
}
