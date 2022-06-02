/**
 * Name: Kun Wang
 * Email: kuw010@ucsd.edu
 * Sources used: none
 * 
 * This is the Custom test file for part 1 of
 * PA 8. It contains the CustomTester class
 */

import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * This is the CustomTester class that contains 10 
 * tests different from that of the public test
 */
public class CustomTester {
    
    MyBST emptyTree, incompleteTree;


    /**
     * This method set up variables used in the following tests
     */
    @Before
    public void BSTsetup(){
        MyBST.MyBSTNode<Integer, String> root = 
            new MyBST.MyBSTNode<>(4, "four", null);
        MyBST.MyBSTNode<Integer, String> two = 
            new MyBST.MyBSTNode<>(2, "two", root);
        MyBST.MyBSTNode<Integer, String> six = 
            new MyBST.MyBSTNode<>(6, "six", root);
        MyBST.MyBSTNode<Integer, String> three = 
            new MyBST.MyBSTNode<>(3, "three", two);

        this.incompleteTree = new MyBST<>();
        this.incompleteTree.root = root;
        root.setLeft(two);
        root.setRight(six);
        two.setRight(three);
        this.incompleteTree.size = 4;

        this.emptyTree = new MyBST<>();
    }

    //Test successor on non-leaf node
    @Test
    public void successorTest1(){
        MyBST.MyBSTNode<Integer,String> two = incompleteTree.root.getLeft();
        assertEquals(two.getRight(), two.successor());
    }

    //Test successor on leaf node
    @Test
    public void successorTest2(){
        MyBST.MyBSTNode<Integer,String> three = 
            incompleteTree.root.getLeft().getRight();
        assertEquals(incompleteTree.root, three.successor());
    }

    //Test insert on empty tree
    @Test
    public void insertTest1(){
        emptyTree.insert(1, "one");
        MyBST.MyBSTNode<Integer,String> expectedRoot = 
            new MyBST.MyBSTNode<Integer,String>(1, "one", null);
        assertEquals(1, emptyTree.size());
        assertEquals(expectedRoot, emptyTree.root);
    }

    //Test search on empty tree
    @Test
    public void searchTest1(){
        assertEquals(null, emptyTree.search(1));
    }

    //Test remove on empty tree
    @Test
    public void removeTest1(){
        assertEquals(null, emptyTree.remove(1));
        assertEquals(0, emptyTree.size());
    }

    //Test remove till empty on non empty tree
    @Test
    public void removeTest2(){
        //first remove
        assertEquals("four", incompleteTree.remove(4));
        assertEquals("six", incompleteTree.root.getValue());
        assertEquals(3, incompleteTree.size());

        //more removes
        assertEquals("six", incompleteTree.remove(6));
        assertEquals("two", incompleteTree.remove(2));
        assertEquals("three", incompleteTree.remove(3));
        assertEquals(0, incompleteTree.size());

        assertEquals(null, incompleteTree.remove(5));
    }

    //Test inorder on empty tree
    @Test
    public void inorderTest1(){
        ArrayList expected = new ArrayList<>();
        assertEquals(expected, emptyTree.inorder());
    }

    //Test inorder on incomplete tree
    @Test
    public void inorderTest2(){
        ArrayList<MyBST.MyBSTNode<Integer, Integer>> expectedRes 
        = new ArrayList<>();
        expectedRes.add(incompleteTree.root.getLeft());
        expectedRes.add(incompleteTree.root.getLeft().getRight());
        expectedRes.add(incompleteTree.root);
        expectedRes.add(incompleteTree.root.getRight());
        assertEquals(expectedRes, incompleteTree.inorder());
    }

    //Test nodeIterator remove on incomplete tree
    @Test
    public void noteIteratorTest1(){

        MyBSTIterator<Integer, Integer> BSTIter = new MyBSTIterator<>();
        BSTIter.root = incompleteTree.root;
        MyBSTIterator<Integer, Integer>.MyBSTValueIterator ValueIter = 
            BSTIter.new MyBSTValueIterator(BSTIter.root);

        ArrayList<MyBST.MyBSTNode<Integer, Integer>> expectedRes 
        = new ArrayList<>();
        expectedRes.add(incompleteTree.root.getLeft());
        expectedRes.add(incompleteTree.root.getLeft().getRight());
        expectedRes.add(incompleteTree.root.getRight());

        ValueIter.nextNode();
        assertEquals(incompleteTree.root, ValueIter.lastVisited);
        ValueIter.remove();
        assertEquals(6, incompleteTree.root.getKey());                
        assertEquals(expectedRes, incompleteTree.inorder());
        //assertEquals(3, incompleteTree.size());
    }

    //Test calendar stressed
    @Test
    public void calendarTest1(){
        MyCalendar cal = new MyCalendar();
        for(int i = 0;  i<100; i++){
            assertTrue(cal.book(i, i+1));
        }
        assertFalse(cal.book(10, 30));

    }

}
