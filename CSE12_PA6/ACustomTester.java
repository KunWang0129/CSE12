
/**
 * Name:Aaron Li
 * Email:aal005@ucsd.edu
 * Sources used: none
 * 
 * This file contains all customer tests for PA6.
 * It tests the MyDeque class,MyStack class, MyQueue class,
 * and MazeSearchGUI class.
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 * This is the test class and all test cases will be in
 * this class.
 */
public class ACustomTester {
    // ----------------MyDeque class----------------
    /**
     * Test the constructor when the initialCapacity < 0;
     */
    @Test
    public void testMyDequeConstructor() {
        try {
            MyDeque<Integer> deque = new MyDeque<>(-1);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Test the expandCapacity method when the capacity is 0;
     */
    @Test
    public void testMyDequeExpandCapacity() {
        MyDeque<Integer> deque = new MyDeque<>(0);
        deque.expandCapacity();
        assertEquals(deque.data.length, 10);
    }

    /**
     * Test the addFirst method when element is null
     */
    @Test
    public void testAddFirst() {
        MyDeque<Integer> deque = new MyDeque<>(0);
        try {
            deque.addFirst(null);
            fail();
        } catch (NullPointerException e) {
        }
    }

    /**
     * Test the addLast method when [TODO]
     */
    @Test
    public void testAddLast() {
        MyDeque<Integer> deque = new MyDeque<>(0);
        try {
            deque.addLast(null);
            fail();
        } catch (NullPointerException e) {
        }
    }

    /**
     * Test the removeFirst method when
     * there are no elements in the deque
     */
    @Test
    public void testRemoveFirst() {
        MyDeque<Integer> deque = new MyDeque<>(0);
        assertNull(deque.removeFirst());
    }

    /**
     * Test the removeLast method when
     * there are no element in the deque
     */
    @Test
    public void testRemoveLast() {
        MyDeque<Integer> deque = new MyDeque<>(0);
        assertNull(deque.removeLast());
    }

    /**
     * Test the peekFirst method when there is no element
     */
    @Test
    public void testPeekFirst() {
        MyDeque<Integer> deque = new MyDeque<>(0);
        assertNull(deque.peekFirst());
    }

    /**
     * Test the peekLast method when there is no element
     */
    @Test
    public void testPeekLast() {
        MyDeque<Integer> deque = new MyDeque<>(0);
        assertNull(deque.peekLast());
    }

    // ----------------MyStack class----------------
    /**
     * Test MyStack when the stack in originally not empty
     * and then empty
     */
    @Test
    public void testMyStack() {
        MyStack<Integer> stack = new MyStack<>(5);
        assertTrue(stack.empty());

        stack.push((Integer) 1);
        assertFalse(stack.empty());

        stack.pop();
        assertTrue(stack.empty());
    }

    // ----------------MyQueue class----------------
    /**
     * Test MyQueue using enqueue and dequeue method when in 
     * originally not empty and then empty
     */
    @Test
    public void testMyQueue() {
        MyQueue<Integer> queue = new MyQueue<>(5);
        assertTrue(queue.empty());

        queue.enqueue((Integer) 1);
        assertFalse(queue.empty());

        queue.dequeue();
        assertTrue(queue.empty());
    }
}
