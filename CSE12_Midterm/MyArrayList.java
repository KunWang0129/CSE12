/**
 * Name: Kun Wang
 * ID: A16807435
 * Email: kuw010@ucsd.edu
 * File description: A simplified MyArrayList
 */

/**
 * This file contains all functions of MyArrayList
 */
public class MyArrayList<E> implements MyReverseList<E> {
    static final int DEFAULT_CAPACITY = 5;
    
    Object[] data;
    int size;

    //IMPORTANT: DO NOT MODIFY THIS CONSTRUCTOR!
    //IMPORTANT: DO NOT ADD ANY MORE CONSTRUCTORS!

    /**
     * Constructor to create an array list with the given array's elements
     * @param arr - array of elements to be used to construct the ArrayList
     */
    public MyArrayList(E[] arr) {
        if (arr == null) {
            this.data = new Object[DEFAULT_CAPACITY];
        } else {
            this.data = arr.clone();
            this.size = arr.length;
        }
    }

    /**
	 * A method that reverses element between fromIndex
     * and toIndex
     * @param fromIndex index of one element
     * @param toIndex index of another element
	 */
    public void reverseRegion(int fromIndex, int toIndex){
        //Check if out of bounds
        if(fromIndex<0 || fromIndex>this.size || 
        toIndex<0 || toIndex > this.size) {
            throw new IndexOutOfBoundsException();
        }
        //Check of to is less than from
        if(fromIndex>toIndex) {
            return;
        }
        //Exchange data
        for(int i = 0; i<1+(toIndex-fromIndex)/2; i++){
            Object Hold = this.data[fromIndex+i];
            this.data[fromIndex+i] = this.data[toIndex-i];
            this.data[toIndex-i] = Hold;
        }
    }

    @Override
    /**
     * A method that returns the number of valid elements
     * in the ArrayList 
     * @return - number of valid elements in the arraylist
     */
    public int size() {
        return this.size;
    }

    @Override
    /**
     * A method that returns an Element at the specified index
     * @param index - the index of the return Element
     * @return Element at specified index
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) data[index];
    }
}
