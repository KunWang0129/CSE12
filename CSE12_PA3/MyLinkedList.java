/**
 * @author Kun Wang
 * Date: 04/16/2022
 * Description: This is the MyLinkedList file for PA3. 
 * It contains content for the MyLinkedList and Node classes.
 */

import java.util.AbstractList;

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
        head.next = tail;
        tail.prev = head;
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
     * 
     * @return true
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
}