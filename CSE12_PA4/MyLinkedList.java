/**
 * @author Kun Wang
 * Date: 04/16/2022
 * Description: This is the MyLinkedList file for PA3. 
 * It contains content for the MyLinkedList and Node classes.
 */

import java.util.AbstractList;
import java.util.NoSuchElementException;
import java.util.ListIterator;
import java.util.Iterator;

/**
 * The MyLinkedList class that contains all methods and variables
 */

public class MyLinkedList<E> extends AbstractList<E> {

    int size;
    Node head;
    Node tail;

    /**
     * A Node class that holds data and references to previous and next Nodes.
     */
    protected class Node {
        E data;
        Node next;
        Node prev;

        /** 
         * Constructor to create singleton Node 
         * @param element Element to add, can be null	
         */
        public Node(E element) {
            // Initialize the instance variables
            this.data = element;
            this.next = null;
            this.prev = null;
        }

        /** 
         * Set the parameter prev as the previous node
         * @param prev - new previous node
         */
        public void setPrev(Node prev) {
            this.prev = prev;		
        }

        /** 
         * Set the parameter next as the next node
         * @param next - new next node
         */
        public void setNext(Node next) {
            this.next = next;
        }

        /** 
         * Set the parameter element as the node's data
         * @param element - new element 
         */
        public void setElement(E element) {
            this.data = element;
        }

        /** 
         * Accessor to get the next Node in the list 
         * @return the next node
         */
        public Node getNext() {
            return this.next;
        }

        /** 
         * Accessor to get the prev Node in the list
         * @return the previous node  
         */
        public Node getPrev() {
            return this.prev;
        }

        /** 
         * Accessor to get the Nodes Element 
         * @return this node's data
         */
        public E getElement() {
            return this.data;
        }
    }

    /*
      *My Implementation of the MyLinkedList Class
      */
    /** Only 0-argument constructor is defined */

    /** 
     * Constructor of MyLinkedList
     */
    public MyLinkedList() {
        this.head = new Node(null);
        this.tail = new Node(null);
        head.setNext(tail);
        tail.setPrev(head);
        this.size = 0;
    }

    /** 
     * Method to get the size of the LinkedList
     * @return size
     */
    @Override
    public int size() {
        return this.size; 
    }

    /** 
     * Method get the data of note at specified index
     * @param index index of node
     * 
     * @return data of node at index
     */
    @Override
    public E get(int index) {
        //Throws exception if index is out of bounds
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        //Returns the node at index
        Node Goal = head.next; 
        int i = 0;
        while(i < index){
            Goal = Goal.next;
            i++;
        }
        return (E) Goal.getElement();  
    }

    /** 
     * Method add the node at specified index
     * @param index index of node
     * @param data data being added
     */
    @Override
    public void add(int index, E data) {
        //Throws exception if data is null
        if(data == null){
            throw new NullPointerException();
        }
        //Throws exception if index is out of bounds
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        //Find current index
        Node newNode = new Node(data);
        Node currNode = this.head;
        for(int i = 0; i< index; i++){
            currNode = currNode.getNext();
        }
        //Insert the node
        Node nextNode = currNode.getNext();
        currNode.setNext(newNode);
        newNode.setPrev(currNode);
        newNode.setNext(nextNode);
        nextNode.setPrev(newNode);

        //Increment size
        size++;
    }
    

    /** 
     * Method add the node at end of list
     * @param data data being added
     */
    public boolean add(E data) {
        //Throws exception if data is null
        if(data == null){
            throw new NullPointerException();
        }
        //Add the new node 
        Node newNode = new Node(data);
        Node currNode = this.tail;
        newNode.setNext(currNode);
        newNode.setPrev(currNode.getPrev());
        currNode.getPrev().setNext(newNode);
        currNode.setPrev(newNode);
        //Increment size
        this.size++;
        return true;
    }

    /** 
     * Method set the node at specified index
     * @param index index of node
     * @param data data being set
     *  
     * @return data from the old node
     */
    public E set(int index, E data) {
        //Throws exception if data is null
        if(data == null){
            throw new NullPointerException();
        }
        //Throws exception if index is out of bounds
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        //Store old data
        E oldData = this.get(index);
        Node newNode = new Node(data);
        Node currNode = this.getNth(index);
        //Set the node
        newNode.setNext(currNode.getNext());
        newNode.setPrev(currNode.getPrev());
        currNode.getNext().setPrev(newNode);
        currNode.getPrev().setNext(newNode);
        return (E) oldData; 
    }

    /** 
     * Method remove the node at specified index
     * @param index index of node
     * @param data data being set
     *  
     * @return data of the removed node
     */
    public E remove(int index) {
        //Throws exception if index is out of bounds
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        E oldData = this.get(index);
        Node currNode = this.getNth(index);
        //remove the node
        currNode.getPrev().setNext(currNode.getNext());
        currNode.getNext().setPrev(currNode.getPrev());
        //Decrease size
        size --;
        //return the removed data
        return oldData;
    }

    /** 
     * Method remove all node
     */
    public void clear() {
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
        size = 0;
    }

    /** 
     * Method check if list is empty
     */
    public boolean isEmpty() {
        if(!this.head.getNext().equals(this.tail)){
            return false;
        }
        return true;
    }

    /** 
     * Method get the node at specified index
     * @param index index of node
     * 
     * @return node at index
     */
    protected Node getNth(int index) {
        //Throws exception if index is out of bounds
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        //Returns the node at index
        Node Goal = head.next; 
        int i = 0;
        while(i < index){
            Goal = Goal.next;
            i++;
        }
        return Goal;  
    }

    /*
    * The MyListIterator class that implements the linklist iterator
    */
    protected class MyListIterator implements ListIterator<E> {

        Node left,right;
        int idx;
        boolean forward;
        boolean canRemoveOrSet;

        /** 
        * Constructor of MyListIterator
        */
        public MyListIterator(){
            this.left = head;
            this.right = head.getNext();
            this.canRemoveOrSet = false;
            this.forward = true;
            this.idx = 0;
        }


        /** 
        * Checks if MyLinkList has next node
        * @return whether list has next
        */
        public boolean hasNext(){
            if(this.right == tail){
                return false;
            }
            return true;
        }

        /** 
        * Move iterator forward by one node and return next element
        * @return element of next node
        */
        public E next(){
            Node N = this.right;
            //Throw exception if next elemnent is tail or null
            if(N.equals(tail)){
                throw new NoSuchElementException();
            }
            //Move iterator
            this.right = this.right.getNext();
            this.left = this.left.getNext();
            this.idx++;
            this.forward = true;
            this.canRemoveOrSet = true;
            return N.getElement();
        }

        /** 
        * Checks if MyLinkList has previous node
        * @return whether list has previous
        */
        public boolean hasPrevious() {
            if(this.left == head){
                return false;
            }
            return true;
        }

        /** 
        * Move iterator backward by one node and return previous element
        * @return element of previous node
        */
        public E previous(){
            Node N = this.left;
            //Throw exception if next elemnent is tail or null
            if(N.equals(head) || N == null){
                throw new NoSuchElementException();
            }
            //Move iterator
            this.left = this.left.getPrev();
            this.right = this.right.getPrev();
            this.idx--;
            this.forward = false;
            this.canRemoveOrSet = true;
            return N.getElement();
        }

        /** 
        * Return the index of next element
        * @return index of next node
        */
        public int nextIndex() {
            if(this.hasNext() == false) {
                return size();
            }
            return idx;
        }

        /** 
        * Return the index of previous element
        * @return index of previous node
        */
        public int previousIndex() {
            if(this.hasPrevious() == false) {
                return -1;
            }
            return idx-1;
        }

        /** 
        * Add element to the list
        * @param element element to be added
        */
        public void add(E element) {
            //Throw exception if element is null
            if(element == null){
                throw new NullPointerException();
            }
            Node N = new Node(element);
            N.setNext(right);
            this.left.setNext(N);
            this.right.setPrev(N);
            this.left = N;
            this.canRemoveOrSet = false;
            this.idx++;
        }

        /** 
        * Set element to the list
        * @param element element to be set
        */
        public void set(E element){
            //Throw exception if element is null
            if(element == null){
                throw new NullPointerException();
            }
            //Throw exception if neither next nor previous were called
            if(canRemoveOrSet == false) {
                throw new IllegalStateException();
            }
            Node N = new Node(element);
            //Check if next or previous were the most recent call
            if(this.forward == true){
                this.right.setPrev(N);
                this.left.getPrev().setNext(N);
                this.left = N;
            }
            else {
                this.left.setNext(N);
                this.right.getNext().setPrev(N);
                this.right = N;
            }
            this.canRemoveOrSet = false;
        }

        /** 
        * Remove last element call by previous or next from the list
        */
        public void remove() {
            //Throw exception if neither next nor previous were called
            if(canRemoveOrSet == false) {
                throw new IllegalStateException();
            }
            //Check if next or previous were the most recent call
            if(this.forward == true){
                this.right.setPrev(this.left.getPrev());
                this.left.getPrev().setNext(this.right);
                this.left = this.left.getPrev();
                idx--;
            }
            else {
                this.left.setNext(this.right.getNext());
                this.right.getNext().setPrev(this.left);
                this.right = this.right.getNext();
            }
            this.canRemoveOrSet = false;
        }
    }
    /** 
    * Overriding the AbstractList implementations
    * @return ListIterator
    */
    @Override
    public ListIterator<E> listIterator(){
        MyListIterator L = new MyListIterator();
        return L;
    }

    /** 
    * Overriding the AbstractList implementations
    * @return ListIterator
    */
    @Override
    public Iterator<E> iterator(){
        MyListIterator L = new MyListIterator();
        return L;
    }
    
}