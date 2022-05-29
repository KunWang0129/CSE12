/**
 * Name: Jianrui Zhang
 * ID: A16878087
 * Email: Jiz145@ucsd.edu
 * Sources used: None
 * 
 * Test the methods and constructor in the MyListIterator class
 * Those tests are not included in public test
 */

import static org.junit.Assert.*;
import org.junit.*;
import java.util.NoSuchElementException;

/**
 *
 * 
 * IMPORTANT: Do not change the method headers and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class JMyLinkedListCustomTester {
	private MyLinkedList listLen1, listLen2;
    private MyLinkedList.MyListIterator listLen1Iter, listLen2Iter;

	/**
	 * This sets up the test fixture. JUnit invokes this method before
	 * every testXXX method. The @Before tag tells JUnit to run this method
	 * before each test.
	 */
	@Before
	public void setUp() throws Exception {
	listLen1 = new MyLinkedList();
	listLen1.add("Christine");
	listLen1Iter = listLen1.new MyListIterator();

	listLen2 = new MyLinkedList();
	listLen2.add("Paul");
	listLen2.add("Cao");
	listLen2Iter = listLen2.new MyListIterator();
	}

	/**
	 *test the hasNext method when Calls hasNext on a empty MyLinkedList
	 */
	@Test
	public void testHasNext() {
		listLen1 = new MyLinkedList();
		listLen1Iter = listLen1.new MyListIterator();
		assertEquals("call hasNext when it is empty list",
		false,listLen1Iter.hasNext());
	}

	/**
	 * TODO: test the next method when hasNext is false
	 */
	@Test(expected = NoSuchElementException.class)
	public void testNext() {
		listLen1 = new MyLinkedList();
		listLen1Iter = listLen1.new MyListIterator();
		listLen1Iter.next();
	}

	/**
	 *test the hasPrevious method when call hasPrevious to empty list
	 */
	@Test
	public void testHasPrevious() {
		listLen1 = new MyLinkedList();
		listLen1Iter = listLen1.new MyListIterator();
		assertEquals("call hasNext when it is empty list",false,listLen1Iter.hasPrevious());

	}

	/**
	 * TODO: test the previous method when hasPrevious is false
	 */
	@Test(expected = NoSuchElementException.class)
	public void testPrevious() {
		listLen1 = new MyLinkedList();
		listLen1Iter = listLen1.new MyListIterator();
		listLen1Iter.previous();
	}

	/**
	 * TODO: test the nextIndex method when empty list
	 */
	@Test
	public void testNextIndex() {
		listLen1 = new MyLinkedList();
		listLen1Iter = listLen1.new MyListIterator();
		assertEquals(0, listLen1Iter.nextIndex());
	}

	/**
	 * TODO: test the previousIndex method when empty list
	 */
	@Test
	public void testPreviousIndex() {
		listLen1 = new MyLinkedList();
		listLen1Iter = listLen1.new MyListIterator();
		assertEquals(-1, listLen1Iter.previousIndex());
	}

	/**
	 * TODO: test the set method when no recent next/previous are called
	 */
	@Test(expected = IllegalStateException.class)
	public void testSet() {
		listLen1 = new MyLinkedList();
		listLen1Iter = listLen1.new MyListIterator();
		listLen1Iter.set(2);
	}

	/**
	 * TODO: test the remove method when no recent next/previous are called
	 */
	@Test(expected = IllegalStateException.class)
	public void testRemoveTestOne() {
		listLen1 = new MyLinkedList();
		listLen1Iter = listLen1.new MyListIterator();
		listLen1Iter.remove();
	}

	/**
	 * TODO: test the remove method when remove multiple times
	 */
	@Test
	public void testRemoveTestTwo() {
		listLen2Iter.next();
		listLen2Iter.remove();
		assertEquals("Cao",listLen2Iter.right.getElement());
		assertEquals(null,listLen2Iter.left.getElement());
		listLen2Iter.next();
		listLen2Iter.remove();
		assertEquals(null,listLen2Iter.left.getElement());
		assertEquals(null,listLen2Iter.right.getElement());

		

	}

	/**
	 * TODO: test the add method when input is invalid
	 */
	@Test(expected = NullPointerException.class)
	public void testAdd() {
		listLen1Iter.add(null);
	}

}