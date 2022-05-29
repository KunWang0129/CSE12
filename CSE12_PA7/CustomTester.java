/**
 * Name: Kun Wang
 * ID: A16807435
 * Email: kuw010@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * This file contains the custom tester for PA7. The tests in this tester
 * is different from the public tester.
 */

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class contains all custom test for PA7
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {
	
	/**
	 * Test the constructor when collection contains null element
	 */
	@Test
	public void testMyMinHeapConstructor() {
		boolean exceptionCaught = false;
		ArrayList<Integer> listWithNull = new ArrayList<Integer>(
			Arrays.asList(new Integer[] { 0, 2, 5, 7, null, 0 })
		);
		try{
			MyMinHeap<Integer> minHeap = new MyMinHeap<>(listWithNull);
		} catch (NullPointerException e){
			exceptionCaught = true;
		}
		assertTrue(exceptionCaught);		
	}

	/**
	 * Test the getMinChildIdx method when node is leaf
	 */
	@Test
	public void testGetMinChildIdx() {
		ArrayList<Integer> integerList = new ArrayList<Integer>(
			Arrays.asList(new Integer[] { 0, 2, 5, 7, 3, 9 })
		);
		MyMinHeap<Integer> minHeap = new MyMinHeap<>(integerList);
		assertEquals(-1, minHeap.getMinChildIdx(4));
	}

	/**
	 * Test the percolateUp method when integer need to be percolate up all the
	 * way to the root
	 */
	@Test
	public void testPercolateUp() {
		ArrayList<Integer> integerList = new ArrayList<Integer>(
			Arrays.asList(new Integer[] { 1, 2, 5, 7, 3, 0 })
		);
		MyMinHeap<Integer> minHeap = new MyMinHeap<>();
		minHeap.data = integerList;
		minHeap.percolateUp(5);
		ArrayList<Integer> expectedList = new ArrayList<Integer>(
			Arrays.asList(new Integer[] {0, 2, 1, 7, 3, 5})
		);

		for(int i = 0; i < integerList.size(); i++){
			assertEquals(expectedList.get(i), minHeap.data.get(i));
		}
	}

	/**
	 * Test the percolateDown method when node is a leaf
	 */
	@Test
	public void testPercolateDown() {
		ArrayList<Integer> integerList = new ArrayList<Integer>(
			Arrays.asList(new Integer[] { 1, 2, 5, 7, 3, 0 })
		);
		MyMinHeap<Integer> minHeap = new MyMinHeap<>();
		minHeap.data = integerList;
		minHeap.percolateDown(5);
		ArrayList<Integer> expectedList = new ArrayList<Integer>(
			Arrays.asList(new Integer[] { 1, 2, 5, 7, 3, 0 })
		);
		for(int i = 0; i < integerList.size(); i++){
			assertEquals(expectedList.get(i), minHeap.data.get(i));
		}
	}

	/**
	 * Test the deleteIndex method when a leaf is deleted
	 */
	@Test
	public void testDeleteIndex() {
		ArrayList<Integer> integerList = new ArrayList<Integer>(
			Arrays.asList(new Integer[] { 1, 2, 5, 7, 3, 0 })
		);
		MyMinHeap<Integer> minHeap = new MyMinHeap<>();
		minHeap.data = integerList;
		minHeap.deleteIndex(5);
		ArrayList<Integer> expectedList = new ArrayList<Integer>(
			Arrays.asList(new Integer[] { 1, 2, 5, 7, 3})
		);
		for(int i = 0; i < integerList.size(); i++){
			assertEquals(expectedList.get(i), minHeap.data.get(i));
		}
	}

	/**
	 * Test the deleteIndex method when a middle node is deleted
	 */
	@Test
	public void testDeleteIndex2() {
		ArrayList<Integer> integerList = new ArrayList<Integer>(
			Arrays.asList(new Integer[] { 1, 2, 5, 7, 3, 0 })
		);
		MyMinHeap<Integer> minHeap = new MyMinHeap<>();
		minHeap.data = integerList;
		minHeap.deleteIndex(1);
		ArrayList<Integer> expectedList = new ArrayList<Integer>(
			Arrays.asList(new Integer[] { 0, 1, 5, 7, 3})
		);
		for(int i = 0; i < integerList.size(); i++){
			assertEquals(expectedList.get(i), minHeap.data.get(i));
		}
	}

	/**
	 * Test the insert method when element is null
	 */
	@Test
	public void testInsert(){
		boolean exceptionThrown = false;
		ArrayList<Integer> integerList = new ArrayList<Integer>(
			Arrays.asList(new Integer[] { 1, 2, 5, 7, 3, 0 })
		);
		MyMinHeap<Integer> minHeap = new MyMinHeap<>();
		minHeap.data = integerList;
		try{
			minHeap.insert(null);
		} catch (NullPointerException e){
			exceptionThrown = true;
		}
		assertTrue(exceptionThrown);
	}

	/**
	 * Test the insert method when a middle element in inserted
	 */
	@Test
	public void testInsert2(){
		ArrayList<Integer> integerList = new ArrayList<Integer>(
			Arrays.asList(new Integer[] { 1, 2, 5, 7, 3, 0 })
		);
		MyMinHeap<Integer> minHeap = new MyMinHeap<>();
		minHeap.data = integerList;
		minHeap.insert(4);
		ArrayList<Integer> expectedList = new ArrayList<Integer>(
			Arrays.asList(new Integer[] { 1, 2, 4, 7, 3, 0, 5})
		);
		for(int i = 0; i < expectedList.size(); i++){
			assertEquals(expectedList.get(i), minHeap.data.get(i));
		}
	}

   
	/**
	 * Test remove when there is one element in heap
	 */
	@Test
	public void testRemove(){
		ArrayList<Integer> integerList = new ArrayList<Integer>(
			Arrays.asList(new Integer[] { 0})
		);
		MyMinHeap<Integer> minHeap = new MyMinHeap<>(integerList);
		ArrayList<Integer> expectedList = new ArrayList<Integer>(
			Arrays.asList(new Integer[] {})
		);
		minHeap.remove();
		assertEquals(expectedList, minHeap.data);
	}

  
	/**
	 * Test getMin when heap is empty
	 */
	@Test
	public void testGetMin(){
		MyMinHeap<Integer> minHeap = new MyMinHeap<>();
		assertEquals(null, minHeap.getMin());
	}

	public static void main(String[] args) {
		ArrayList<Integer> integerList = new ArrayList<Integer>(
			Arrays.asList(new Integer[] {3, 22, 4, 35, 54, 7, 8, 52})
		);
		MyMinHeap<Integer> minHeap = new MyMinHeap<>();
		minHeap.data = integerList;
		
		minHeap.insert(2);
		System.out.println(minHeap.data);
	}

}