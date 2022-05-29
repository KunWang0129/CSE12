/**
 * Name: Kun Wang
 * ID: A16807435
 * Email: kuw010@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * This file contains MyMinHeap class, which is my own implementation
 * of the min-heap.
 */

// Your import statements
import java.util.ArrayList;
import java.util.Collection;

/**
 * This class contains variables and methods of my own implementation of min
 * heap.
 */
public class MyMinHeap<E extends Comparable<E>> implements MinHeapInterface <E>{

	public ArrayList<E> data;
	
	/**
	 * This is the default constructor, which sets data to 
	 * an empty ArrayList
	 */
	public MyMinHeap(){
		this.data = new ArrayList<E>();
	}

	/**
	 * This constructor initialize data using collection
	 * @param collection imported data
	 */
	public MyMinHeap(Collection<? extends E> collection){
		/**
		 * Check if collection is null or any element in
		 * collection is null
		 */ 
		if(collection == null || collection.contains(null)){
			throw new NullPointerException();
		}
		this.data = new ArrayList<E>(collection);
		//percolate each element down backwards
		for(int i = data.size()-1; i>=0; i--){
			this.percolateDown(i);
		}
	}

	//Helpers:
	/**
	 * This method swaps data in two indices
	 * @param from from index of data
	 * @param to to index of data
	 */
	protected void swap(int from, int to){
		//Use object to swap
		Object swap = data.get(from);
		data.set(from, data.get(to));
		data.set(to, (E)swap);
	}

	/**
	 * This method get the parent index of the current
	 * data
	 * @param index index of current data
	 * @return index of parent data
	 */
	protected int getParentIdx(int index){
		//return parent index
		return (index-1)/2;
	}

	/**
	 * This method get the index of left child of
	 * the current data
	 * @param index index of current data
	 * @return index of left child
	 */
	protected int getLeftChildIdx(int index){
		//return left child index
		return (2*index) + 1;
	}

	/**
	 * This method get the index of right child of
	 * the current data
	 * @param index	index of current data
	 * @return index of right child
	 */
	protected int getRightChildIdx(int index){
		//return right child index
		return (2*index)+2;
	}

	/**
	 * This method get the index of child which have
	 * the smallest data of the current data
	 * @param index
	 * @return index of smallest data
	 */
	protected int getMinChildIdx(int index){

		int left = this.getLeftChildIdx(index);
		int right = this.getRightChildIdx(index);

		//Check if this data has child
		if(left >= data.size()){
			return -1;
		}
		else if(right >= data.size()){
			return left;
		}

		//Compare two child's data
		if(data.get(right).compareTo(data.get(left)) < 0){
			return right;
		}
		else{
			return left;
		}
	}

	/**
	 * This method percolate the element at index up
	 * @param index index of data to be move up
	 */
	protected void percolateUp(int index){
		int parent = this.getParentIdx(index);
		//Stopping point
		if(index == 0){
			return;
		}
		//check if parent is no greater than current data
		else if(data.get(parent).compareTo(data.get(index)) > 0){
			this.swap(parent, index);
			//continue percolate up
			percolateUp(parent);
		}
	}

	/**
	 * This method percolate the element at index down
	 * @param index
	 */
	protected void percolateDown(int index){
		int child = this.getMinChildIdx(index);
		//Stopping point
		if(child == -1){
			return;
		}
		//Compare
		if(data.get(index).compareTo(data.get(child)) > 0){
			this.swap(child, index);
			//continue percolate down
			percolateDown(child);
		}
	}

	/**
	 * This method remove and return element at index from data
	 * @param index index of data
	 * @return data being removed
	 */
	protected E deleteIndex(int index){
		Object removed = data.get(index);
		int minChild;
		//Check if element is last of the heap
		if(this.data.size() == 1){
			data.set(index, null);
		}
		//Check if element is last
		else if(index != data.size()-1){
			this.swap(index, data.size()-1);
			minChild = this.getMinChildIdx(index);
			//Check if percolate up or down
			if(data.get(index).compareTo(data.get(minChild))>0){
				this.percolateDown(index);
			}
			else{
				this.percolateUp(index);
			}
		}
		data.remove(data.size()-1);
		return (E)removed;
	}

	/**
	 * Add element to the end of heap and percolate up
	 * @param element
	 */
	@Override
	public void insert(E element) {
		//check for null exception
		if(element == null){
			throw new NullPointerException();
		}
		//add element
		data.add(element);
		//percolate upwards
		this.percolateUp(data.size()-1);
	}

	/**
	 * This method return smallest element of heap
	 * @return smallest element of heap
	 */
	@Override
	public E getMin() {
		if(data.size() == 0){
			return null;
		}
		return data.get(0);
	}

	/**
	 * This method remove the return the root element
	 */
	@Override
	public E remove() {
		//check if heap is empty
		if(data.size() == 0){
			return null;
		}
		//use helper method
		return this.deleteIndex(0);
	}

	/**
	 * This method return the number of elements in this min-heap
	 * @return number of elements in this min-heap
	 */
	@Override
	public int size() {
		return data.size();
	}

	/**
	 * This method clear out the entire heap
	 */
	@Override
	public void clear() {
		data.clear();
	}


}