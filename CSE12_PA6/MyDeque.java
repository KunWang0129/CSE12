/**
 * Name: Kun Wang
 * Email: kuw010@ucsd.edu
 * Sources used: None
 * 
 * This file contains a MyDeque class, which is an implementation for Deque
 */

 /**
  * This class contains all methods and variables of MyDeque, which implement
  * behaviors of Deque
  */

public class MyDeque<E> implements DequeInterface<E>{

    Object[] data;
    int size;
    int rear;
    int front;
    final int doubles = 2;
    final int defaultLength = 10;

    /**
     * This is the constructor of the class MyDeque. which initialize
     * all variables in MyDeque
     * @param initialCapacity initial capacity of the deque
     */
    public MyDeque(int initialCapacity) {
        //check if initlal capacity is legal
        if(initialCapacity < 0){
            throw new IllegalArgumentException();
        }
        //initialize variables
        this.data = ((E[])new Object[initialCapacity]);
        this.size = 0;
        this.rear = 0;
        this.front = 0;
    }

    /**
     * This method return number of element of 
     * deque.
     * @return size of deque
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * This method expand the capacity of deque
     */
    @Override
    public void expandCapacity() {
        //check if current capacity is 0
        if(data.length == 0){
            data = new Object[defaultLength];
            return;
        }
        //double the capacity
        Object[] dataC = data.clone();
        data = new Object[data.length * doubles];
        //add element contiguously 
        for(int i = 0; i<size; i++){
            data[i] = dataC[((front+i) % dataC.length)];
        }
        //set front and rear
        this.front = 0;
        this.rear = this.size-1;
        if(size == 0){
            this.rear = 0;
        }
    }

    /**
     * This method add element at front of the deque
     * @param element element to be added to the deque
     */
    @Override
    public void addFirst(E element) {
        //check if element is null
        if(element == null){
            throw new NullPointerException();
        }
        //check if deque is at capacity
        if(this.size == this.data.length){
            this.expandCapacity();
        }
        //add element and update front
        //case for size == 0
        if(size == 0){
            data[front] = element;
        }
        else if(front == 0){
            data[data.length-1] = element;
            front = data.length-1;
        }
        else{
            data[front-1] = element;
            front--;
        }
        //update size
        this.size++;   
    }

    /**
     * This method add element to the back of the deque
     * @param element element to be added
     */
    @Override
    public void addLast(E element) {
        //check if element is null
        if(element == null){
            throw new NullPointerException();
        }
        //check if deque is at capacity
        if(this.size == this.data.length){
            this.expandCapacity();
        }
        //add element and update rear
        //case where size == 0
        if(size == 0){
            data[front] = element;
        }
        else if(rear == data.length-1){
            data[0] = element;
            rear = 0;
        }
        else{
            data[rear+1] = element;
            rear++;
        }
        //update size
        this.size++;  
    }

    /**
     * This method remove the first element of the deque
     * @return element removed
     */
    @Override
    public E removeFirst() {
        //check if there are element
        if(this.size == 0){
            return null;
        }
        //remove first element
        Object first = data[front];
        data[front] = null;
        //update size
        this.size--;
        if(size == 0){
            front = rear;
        }
        else if(this.front == data.length-1){
            this.front = 0;
        }
        else{
            this.front++;
        }

        return (E)first;
    }

    /**
     * This method remove last element of the deque
     * @return element removed
     */
    @Override
    public E removeLast() {
        //check if there are element
        if(this.size == 0){
            return null;
        }
        //remove last element
        Object last = data[rear];
        data[rear] = null;
        //update size
        this.size--;
        if(this.size == 0){
            rear = front;
        }
        else if(this.rear == 0){
            this.rear = data.length-1;
        }
        else{
            this.rear--;
        }
        return (E)last;
    }

    /**
     * This method return the element at the front
     * of the deque
     * @return element at the front
     */
    @Override
    public E peekFirst() {
        //check if element exist
        if(size == 0){
            return null;
        }
        return (E)data[front];
    }

    /**
     * This method return the element at the rear of 
     * the deque
     * @return element at the rear
     */
    @Override
    public E peekLast() {
        //check if element exist
        if(size == 0){
            return null;
        }
        return (E)data[rear];
    }
}
