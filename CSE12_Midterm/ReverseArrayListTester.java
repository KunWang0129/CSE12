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
public class ReverseArrayListTester {

    Object[] arr3 = {1,"2",3};
    Object[] arr10 = {0,1,2,3,4,5,6,7,8,9};
    MyArrayList arrayLen3,arrayLen10;
    MyLinkedList  linkListlen3,linkListlen10;

    /**
     * Run before every test
     */
    @Before
    public void setUp(){
        arrayLen10 = new MyArrayList<>(arr10);
        arrayLen3 = new MyArrayList<>(arr3);
        linkListlen10 = new MyLinkedList<>(arr10);
        linkListlen3 = new MyLinkedList<>(arr3);
    }


    /**
     * Tests reverseRegion method when either fromIndex or toIndex
     * or both are out of bounds.
     */
    @Test
    public void testReverseIndexOutOfBounds(){
        boolean arrayExceptionThrown = false;
        try{
            arrayLen3.reverseRegion(0, 5);
        } catch(IndexOutOfBoundsException e){
            arrayExceptionThrown = true;
        }
        assertEquals(true, arrayExceptionThrown);

    }

    /**
     * Tests reverseRegion method when
     * fromIndex > toIndex
     */
    @Test
    public void testReverseFromIndexGreater(){
        arrayLen3.reverseRegion(2, 0);
        assertEquals(1, arrayLen3.get(0));
        assertEquals(3, arrayLen3.get(2));
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

        arrayLen10.reverseRegion(2, 8);
        assertEquals(1, arrayLen10.get(1));
        assertEquals(2, arrayLen10.get(8));
        assertEquals(3, arrayLen10.get(7));
        assertEquals(4, arrayLen10.get(6));
    }

    /**
     * Tests reverseRegion method when
     * fromIndex and toIndex are on the bounds 
     * (i.e. fromIndex = 0 and toIndex = size-1), 
     * and fromIndex is less than toIndex.
     * Explain: This test the case when reverse region is entire arrayList
    */
    @Test
    public void testReverseCustom(){
        arrayLen10.reverseRegion(0, 9);
        for(int i=0; i<arrayLen10.size()-1; i++){
            assertEquals(i, arrayLen10.get(arrayLen10.size()-i-1));
        }
    }

    /**
     * Tests reverseRegion method when
     * fromIndex and toIndex are on the bounds 
     * (i.e. fromIndex = 0 and toIndex = size-1), 
     * and fromIndex is less than toIndex.
     * Explain: This test the case when reverse region is entire LinkList
    */
    @Test
    public void testReverseCustomLinkList(){
        linkListlen10.reverseRegion(0, 9);
        for(int i=0; i<linkListlen10.size()-1; i++){
            assertEquals(i, linkListlen10.get(linkListlen10.size()-i-1));
        }
    }

}
