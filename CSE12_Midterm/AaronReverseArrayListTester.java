/**
 * Tests to check the implementation of reverseRegion method in MyArrayList.java
*/

//other import statements

import static org.junit.Assert.assertEquals;

import org.junit.*;

//IMPORTANT: DO NOT MODIFY THE TEST HEADERS!
/**
 * This class contains various test cases to test the reverseRegion method
 */
public class AaronReverseArrayListTester {
    MyArrayList<Integer> l1;
    MyLinkedList l2;
    /**
     * Run before every test
     */
    @Before
    public void setUp(){
        Integer[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        l1 = new MyArrayList<Integer>(arr);
        l2 = new MyLinkedList<>(arr);
        
    }


    /**
     * Tests reverseRegion method when either fromIndex or toIndex
     * or both are out of bounds.
     */
    @Test
    public void testReverseIndexOutOfBounds(){
        try{
            l2.reverseRegion(-1,100);
        } catch (IndexOutOfBoundsException E) {
            System.out.println("Exception catched as expected.");
        }
        try {
            l1.reverseRegion(-1, 100);
        } catch (IndexOutOfBoundsException E) {
            System.out.println("Exception catched as expected.");
        }
    }

    /**
     * Tests reverseRegion method when
     * fromIndex > toIndex
     */
    @Test
    public void testReverseFromIndexGreater() {
        l1.reverseRegion(5, 1);
        assertEquals("Checks that values are not changed",Integer.valueOf(5), l1.get(4));
        l2.reverseRegion(4, 3);
        assertEquals("Checks that values are not changed",4, l2.get(3));

    }

    /**
     * Tests reverseRegion method when
     * fromIndex and toIndex are within bounds and
     * in the middle of the list 
     * (i.e. fromIndex > 0 and toIndex < size-1), 
     * and fromIndex is less than toIndex.
    */
    @Test
    public void testReverseIndexWithinBounds(){
        l1.reverseRegion(1, 5);
        assertEquals("Checks that value is changed",Integer.valueOf(6), l1.get(1));

        l2.reverseRegion(1, 5);
        assertEquals("Checks that value is changed",6, l2.get(1));
    }

    /**
     * Test when fromIndex and toIndex are the same.
    */
    @Test
    public void testReverseCustom(){
        l1.reverseRegion(3, 3);
        assertEquals("Checks that value is not changed",Integer.valueOf(4), l1.get(3));
        l2.reverseRegion(3, 3);
        assertEquals("Checks that value is not changed",Integer.valueOf(4), l2.get(3));
    }


}
