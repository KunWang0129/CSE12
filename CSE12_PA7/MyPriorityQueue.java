/**
 * Name: Kun Wang
 * ID: A16807435
 * Email: kuw010@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * This file contains MyPriorityQueue class, which contains an 
 * implementation using MyMinHeap
 */

import java.util.Collection;

/**
 * This is the MyPriorityQueue class
 */
public class MyPriorityQueue<E extends Comparable<E>>
{

	public MyMinHeap<E> heap;

	
	/**
	 * Constructor that creates an empty priority queue
	 */
	public MyPriorityQueue(){
		heap = new MyMinHeap<>();
	}

	/**
	 * Constructor that creates a priority queue from a collection
	 * @param collection The collection used to intialize priority queue
	 */
	public MyPriorityQueue(Collection<? extends E> collection){
		heap = new MyMinHeap<>(collection);
	}

	/**
	 * Adds an element to the priority queue
	 * @param element the element to be added
	 */
	public void push(E element){
		heap.insert(element);
	}

	/**
	 * Removes the element with the highest priority from the priority queue 
	 * @return the element with the highest priority
	 */
	public E pop(){
		return heap.remove();
	}

	/**
	 * Sees the element with the highest priority from the priority queue
	 * @return the element with the highest priority
	 */
	public E peek(){
		return heap.getMin();
	}

	/**
	 * Finds the number of elements in the priority queue
	 * @return the number of elements in the priority queue
	 */
	public int getLength(){
		return heap.size();
	}

	/**
	 * Remove all the elements from the priority queue.
	 */
	public void clear(){
		heap.clear();
	}
}