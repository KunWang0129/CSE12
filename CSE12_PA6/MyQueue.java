/**
 * Name: Kun Wang
 * Email: kuw010@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * 
 * This file contains a MyQueue class, which is an implementation for the Queue
 * ADT based on MyDeque. Elements can be added/removed from the queue in a FIFO
 * ordering.
 */

/**
 * This class implements the Queue ADT using a MyDeque instance variable called
 * theStack.
 */
public class MyQueue<E> implements QueueInterface<E> {
    MyDeque<E> theQueue;

    /**
     * Constructor to create new MyQueue that holds a MyDeque.
     * 
     * @param initialCapacity The max amount of elements this data structure
     * can hold.
     */
    public MyQueue(int initialCapacity) {
        this.theQueue = new MyDeque<>(initialCapacity);
    }

    /**
     * Checks whether or not the queue is empty.
     * 
     * @return True if there are no elements in the queue, false otherwise.
     */
    @Override
    public boolean empty() {
        boolean isEmpty = true;
        //If size of theStack is not 0. return false
        if(this.theQueue.size() > 0){
            isEmpty = false;
        }
        return isEmpty;
    }

    /**
     * Adds the specified element to the tail of this MyQueue.
     * 
     * @param element the element to add to the queue
     */
    @Override
    public void enqueue(E element) {
        // use addLast to add to tail
        this.theQueue.addLast(element);;
    }

    /**
     * Removes the element at the head of this MyQueue.
     * Returns the element removed, or null if there was no such
     * element.
     * 
     * @return the element removed, or null if the size was zero.
     */
    @Override
    public E dequeue() {
        // use removeFirst to remove head
        return this.theQueue.removeFirst();
    }

    /**
     * Returns the element at the head of this MyQueue,
     * or null if there was no such element.
     * 
     * @return the element at the head, or null if the size was zero.
     */
    @Override
    public E peek() {
        // use peekFirst to peek at head
        return theQueue.peekFirst();
    }

    /**
     * Returns the number of elements in this queue.
     * 
     * @return the number of elements in the queue
     */
    public int size() {
        return theQueue.size();
    }

}
