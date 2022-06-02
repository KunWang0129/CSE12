/**
 * Name: Kun Wang
 * Email: kuw010@ucsd.edu
 * Sources used: none
 * 
 * This is the BST iterator file that contains the BST iterator class
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This is the class of my implementatio of BST iterator. It contains
 * all methods and variables of a BST iterator
 */

public class MyBSTIterator<K extends Comparable<K>, V> extends MyBST<K, V> {
    abstract class MyBSTNodeIterator<T> implements Iterator<T> {
        MyBSTNode<K, V> next;
        MyBSTNode<K, V> lastVisited;

        /**
         * Constructor that initializes the node iterator
         *
         * @param first The initial node that next points
         */
        MyBSTNodeIterator(MyBSTNode<K, V> first) {
            next = first;
            lastVisited = null;
        }

        /**
         * This method is used for determining if the next pointer in the
         * iterator points to null.
         *
         * @return If next is null based on the current position of iterator
         */
        public boolean hasNext() {
            return next != null;
        }

        /**
         * This method advance to the next node
         * @return the node we visited
         */
        MyBSTNode<K, V> nextNode() {
            //check if there is next node
            if(hasNext() == false){
                throw new NoSuchElementException();
            }
            //set last visited
            this.lastVisited = next;
            //get to the next node
            next = next.successor();
            return lastVisited;
        }

        /**
         * This method removes the last visited node from the tree.
         */
        public void remove() {
            //check if any node has been visited
            if (lastVisited == null) {
                throw new IllegalStateException();
            }
            //check if visited node is a leaf
            if (lastVisited.getRight() != null &&
                    lastVisited.getLeft() != null) {
                next = lastVisited;
            }
            //use remove method
            MyBSTIterator.this.remove(lastVisited.getKey());
            //set last visited to null
            lastVisited = null;
        }
    }

    /**
     * BST Key iterator class that extends the node iterator.
     */
    class MyBSTKeyIterator extends MyBSTNodeIterator<K> {

        MyBSTKeyIterator(MyBSTNode<K, V> first) {
            super(first);
        }

        /**
         * This method advance the iterator and returns a node key
         *
         * @return K the next key
         */
        public K next() {
            return super.nextNode().getKey();
        }
    }

    /**
     * BST value iterator class that extends the node iterator.
     */
    class MyBSTValueIterator extends MyBSTNodeIterator<V> {

        /**
         * Call the constructor method from node iterator
         *
         * @param first The initial value that next points
         */
        MyBSTValueIterator(MyBSTNode<K, V> first) {
            super(first);
        }

        /**
         * This method advance the iterator and returns a node value
         *
         * @return V the next value
         */
        public V next() {
            return super.nextNode().getValue();
        }
    }

    /**
     * This method is used to obtain an iterator that iterates through the
     * value of BST.
     *
     * @return The value iterator of BST.
     */
    public MyBSTKeyIterator getKeyIterator() {
        MyBSTNode<K, V> curr = root;
        if (curr != null) {
            while (curr.getLeft() != null) {
                curr = curr.getLeft();
            }
        }
        return new MyBSTKeyIterator(curr);
    }

    /**
     * This method is used to obtain an iterator that iterates through the
     * value of BST.
     *
     * @return The value iterator of BST.
     */
    public MyBSTValueIterator getValueIterator() {
        MyBSTNode<K, V> curr = root;
        if (curr != null) {
            while (curr.getLeft() != null) {
                curr = curr.getLeft();
            }
        }
        return new MyBSTValueIterator(curr);
    }
}