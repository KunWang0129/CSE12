/**
 * Name:Kun Wang
 * ID: A16807435
 * Email: kuw010@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * File for hidden tests on gradescope. Need additional tests implemented
 */

 //IMPORTANT: Do not change the headers!

import static org.junit.Assert.*;

import org.junit.*;


/**
 * This is the class which implement the hidden test for MyArrayList 
 */
public class MyArrayListHiddenTester {

	static final int DEFAULT_CAPACITY = 5;
	static final int MY_CAPACITY = 3;

	Object[] arr = new Object[10];
	Integer[] arrInts = {1,2,3,4,5,6};

	private MyArrayList listEmpty, listDefaultCap, listCustomCapacity, 
	listWithNull, listWithInt, listInvalid;

	/**
	 * This sets up the test fixture. JUnit invokes this method before
	 * every testXXX method. The @Before tag tells JUnit to run this method
	 * before each test */
	@Before
	public void setUp() throws Exception {  
		listEmpty = new MyArrayList();
		listCustomCapacity = new MyArrayList(MY_CAPACITY);
		listWithNull = new MyArrayList(null);
		listWithInt = new MyArrayList<Integer>(arrInts);
	}

	/**
	 * Aims to test the constructor when the input argument
	 * is not valid
	 */
	@Test
	public void testConstructorInvalidArg(){
		boolean exceptionThrown = false;
		try{
			listInvalid= new MyArrayList(-1);
		}catch(IllegalArgumentException e) {
			exceptionThrown = true;
		}
		assertTrue("Except thrown for illegal argument", exceptionThrown);
	}

	/**
	 * Aims to test the constructor when the input argument
	 * is null
	 */
	@Test
	public void testConstructorNullArg(){
		assertEquals("Check for default capacity",5, listWithNull.data.length);
		assertEquals("Check for default size",0, listWithNull.size);
	}

	/**
	 * Aims to test the append method when an element is added to a full list
	 * Check reflection on size and capacity
	 */
	@Test
	public void testAppendAtCapacity(){
		listWithInt.append(7);
		assertEquals("Check that append increments size", 7, 
			listWithInt.size);
		assertEquals("Check that capacity is changed", 12, 
			listWithInt.data.length);
		assertEquals("check the correct element", 1, 
			listWithInt.data[0]);
		assertEquals("check the correct element", 3, 
			listWithInt.data[2]);
	}

	/**
	 * Aims to test the prepend method when a null element is added
	 * Checks reflection on size and capacity
	 * Checks whether null was added successfully
	 */
	@Test
	public void testPrependNull(){
		listWithInt.prepend(null);
		assertEquals("Check that append increments size", 7, 
			listWithInt.size);
		assertEquals("Check that capacity is changed", 12, 
			listWithInt.data.length);
		assertEquals("check the correct element", null, 
			listWithInt.data[0]);
		assertEquals("check the correct element", 2, 
			listWithInt.data[2]);
	}
	
	/**
	 * Aims to test the insert method when input index is out of bounds
	 */
	@Test
	public void testInsertOutOfBound(){
		boolean exceptionThrown = false;
		try{
			listWithInt.insert(9, null);
		}catch(IndexOutOfBoundsException e) {
			exceptionThrown = true;
		}
		assertTrue("Except not thrown for illegal argument", exceptionThrown);
	}

	/**
	 * Insert multiple (eg. 1000) elements sequentially beyond capacity -
	 * Check reflection on size and capacity
	 * Hint: for loop could come in handy
	 */
	@Test
	public void testInsertMultiple(){
		int numElement = 1000;
		for(int i=0; i<numElement; i++){
			listWithInt.insert(i, null);
		}
		assertEquals("Check that insert increments size", 1006, 
			listWithInt.size);
		assertEquals("Check that capacity is changed", 1536, 
			listWithInt.data.length);
		assertEquals("Check element is inserted", null, listWithInt.data[50]);

	}

	/**
	 * Aims to test the get method when input index is out of bound
	 */
	@Test
	public void testGetOutOfBound(){
		boolean exceptionThrown = false;
		try{
			listWithInt.get(10);
		}catch(IndexOutOfBoundsException e) {
			exceptionThrown = true;
		}
		assertTrue("Except not thrown for illegal argument", exceptionThrown);
	}

	/**
	 * Aims to test the set method when input index is out of bound
	 */
	@Test
	public void testSetOutOfBound(){
		boolean exceptionThrown = false;
		try{
			listWithInt.set(10,null);
		}catch(IndexOutOfBoundsException e) {
			exceptionThrown = true;
		}
		assertTrue("Except not thrown for illegal argument", exceptionThrown);
	}


	/**
	 * Aims to test the remove method when input index is out of bound
	 */
	@Test
	public void testRemoveOutOfBound(){
		boolean exceptionThrown = false;
		try{
			listWithInt.remove(10);
		}catch(IndexOutOfBoundsException e) {
			exceptionThrown = true;
		}
		assertTrue("Except not thrown for illegal argument", exceptionThrown);
	}

	/**
	 * Aims to test the expandCapacity method when 
	 * requiredCapacity is strictly less than the current capacity
	 */
	@Test
	public void testExpandCapacitySmaller(){
		boolean exceptionThrown = false;
		try{
			listWithInt.expandCapacity(4);
		}catch(IllegalArgumentException e) {
			exceptionThrown = true;
		}
		assertTrue("Except not thrown for illegal argument", exceptionThrown);
	}

	/**
	 * Aims to test the expandCapacity method when 
	 * requiredCapacity is greater than double(2x) the current capacity
	 */
	@Test
	public void testExpandCapacityExplode(){
		int	requiredCapacity = 20;
		listWithInt.expandCapacity(requiredCapacity);
		assertEquals("Check that capacity is changed correctly", 20, 
			listWithInt.data.length);
	}
	

}
