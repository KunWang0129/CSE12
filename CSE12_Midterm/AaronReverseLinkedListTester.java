/**
 * Tests to check the implementation of reverseRegion method in MyArrayList.java
*/

//other import statements

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;

//IMPORTANT: DO NOT MODIFY THE TEST HEADERS!
/**
 * This class contains various test cases to test the reverseRegion method
 */
public class AaronReverseLinkedListTester {
    private MyLinkedList IntList;
    private Integer[] ints = { 1, 2, 3 ,4 ,5 ,6};

    public Object[] actualsArray(MyLinkedList list){
        Object[] returnList = new Integer[list.size];
        for(int i = 0; i < list.size; i++){
            returnList[i] = list.get(i);
        }
        return returnList;
    }
    /**
     * Run before every test
     */
    @Before
    public void setUp() {
        IntList = new MyLinkedList<Integer>(ints);
    }

    /**
     * Tests reverseRegion method when either fromIndex or toIndex
     * or both are out of bounds.
     */
    @Test
    public void testReverseIndexOutOfBounds() {
        // test when fromIndex are out of bounds
        boolean exceptionThrown1 = false;
        try {
            IntList.reverseRegion(-1, 4);
        } catch (IndexOutOfBoundsException e) {
            exceptionThrown1 = true;
        }
        assertTrue("an exception should caught when front index out of bounds",
                exceptionThrown1);

        // test when toIndex are out of bounds
        boolean exceptionThrown2 = false;
        try {
            IntList.reverseRegion(0, 6);
        } catch (IndexOutOfBoundsException e) {
            exceptionThrown2 = true;
        }
        assertTrue("an exception should caught when toindex out of bounds",
                exceptionThrown2);

        // test when both index are out of bounds
        boolean exceptionThrown3 = false;
        try {
            IntList.reverseRegion(-1, 6);
        } catch (IndexOutOfBoundsException e) {
            exceptionThrown3 = true;
        }
        assertTrue("an exception should caught when both index out of bounds",
                exceptionThrown3);
    }

    /**
     * Tests reverseRegion method when
     * fromIndex > toIndex
     */
    @Test
    public void testReverseFromIndexGreater() {
        IntList.reverseRegion(5, 0);
        Object[] actualsArray = actualsArray(IntList);

        Integer[] testArray = { 1, 2, 3, 4, 5, 6 };

        assertArrayEquals("Two data array should be equals", testArray, actualsArray);
    }

    /**
     * Tests reverseRegion method when
     * fromIndex and toIndex are within bounds and
     * in the middle of the list
     * (i.e. fromIndex > 0 and toIndex < size-1),
     * and fromIndex is less than toIndex.
     */
    @Test
    public void testReverseIndexWithinBounds() {
        IntList.reverseRegion(1, 2);
        Object[] actualsArray = actualsArray(IntList);

        Integer[] testArray = { 1, 3, 2, 4, 5, 6 };

        assertArrayEquals("Two data array should be equals", testArray, actualsArray);
    }

    /**
     * Tests reverseRegion for 
     */
    @Test
    public void testReverseCustom() {
        // TODO: Add your test case

    }

}
