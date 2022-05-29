
/**
 * Name: Kun Wang
 * ID: A16807435
 * Email: kuw010@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * This is the custom tester for MyLinkedList
 */

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.*;

/**
 * This class contains custom tests for MyLinkList, specifically MyListIterator
 * 
 * IMPORTANT: Do not change the method headers and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class MyLinkedListCustomTester {

	/**
	 * This sets up the test fixture. JUnit invokes this method before
	 * every testXXX method. The @Before tag tells JUnit to run this method
	 * before each test.
	 */

	private MyLinkedList listLen0, listLen1, listLen3;
    private MyLinkedList.MyListIterator listLen0Iter, listLen1Iter, listLen3Iter;

	@Before
	public void setUp() throws Exception {
		listLen0 = new MyLinkedList();
		listLen0Iter = listLen0.new MyListIterator();

		listLen1 = new MyLinkedList<>();
		listLen1.add(000);
		listLen1Iter = listLen1.new MyListIterator();


		listLen3 = new MyLinkedList();
		listLen3.add("1");
		listLen3.add("2");
		listLen3.add("3");
		listLen3Iter = listLen3.new MyListIterator();
	}

	/**
	 * Test the hasNext method when MyLinkedList is empty
	 */
	@Test
	public void testHasNext() {
		assertFalse("HasNext should be false if list is empty", 
		listLen0Iter.hasNext());
	}

	/**
	 * Test the next method when next is called on empty list
	 */
	@Test
	public void testNext() {
		try {
			listLen0Iter.next();
		} 
		catch (NoSuchElementException e){

		}
	}

	/**
	 * Test the hasPrevious method when list is empty
	 */
	@Test
	public void testHasPrevious() {
		assertFalse("HasPrevious should be false if list is empty", 
		listLen0Iter.hasPrevious());
	}

	/**
	 * Test the previous method when multiple time is called
	 */
	@Test
	public void testPrevious() {
		listLen3Iter.left = listLen3.tail.getPrev();
		listLen3Iter.right = listLen3.tail;
		assertEquals("3", listLen3Iter.previous());
		assertEquals("2", listLen3Iter.previous()); 
		assertEquals("1", listLen3Iter.previous()); 
		try {
			listLen0Iter.previous();
		} 
		catch (NoSuchElementException e){

		}
	}

	/**
	 * Test the nextIndex method when list is empty
	 */
	@Test
	public void testNextIndex() {
		assertEquals(0, listLen0Iter.nextIndex());
	}

	/**
	 * Test the previousIndex method when list is empty
	 */
	@Test
	public void testPreviousIndex() {
		assertEquals(0, listLen0Iter.nextIndex());
	}

	/**
	 * Test the set method when element is null
	 */
	@Test
	public void testSet() {
		try{
			listLen0Iter.set(null);
		} catch(NullPointerException e) {

		}
	}

	/**
	 * Test the remove method when list is empty
	 */
	@Test
	public void testRemoveTestOne() {
		try{
			listLen0Iter.remove();
		} catch(IllegalStateException e){

		}

	}

	/**
	 * Test the remove method when list becomes empty
	 */
	@Test
	public void testRemoveTestTwo() {
		assertEquals(000, listLen1Iter.next());
		listLen1Iter.remove();
		try{
			listLen1Iter.remove();
		} catch(IllegalStateException e){

		}
	}

	/**
	 * Test the add method when list is added multiple times
	 */
	@Test
	public void testAdd() {
		for(int i = 0; i<1000; i++){
			listLen0Iter.add(i);
		}
		assertEquals(999, listLen0Iter.left.getElement());
		
	}





}