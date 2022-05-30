/**
 * Name: Kun Wang
 * Email: kuw010@ucsd.edu
 * Sources used: zybook
 * 
 * This is the BST file that contains my own implementation of BST. 
 * It has both node class the tree itself.
 */
import java.util.ArrayList;

/**
 * This is the myBST class that contains basic functions of a BST
 */

public class MyBST<K extends Comparable<K>,V>{
    MyBSTNode<K,V> root = null;
    int size = 0;

    /**
     * This method returns the size of the tree
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * This method insert key and value into BST
     * @param key key of node
     * @param value value of node
     * @return the preexisting node that is replaced
     */
    public V insert(K key, V value){
        //update size
        this.size++;
        //if there is not element in tree
        if(root == null){
            root = new MyBSTNode<K,V>(key, value, null);
            return null;
        }
        else{
            MyBSTNode node = new MyBSTNode<K,V>(key, value, root);
            MyBSTNode curr = root;
            while(curr != null){
                //if two node have same value
                if(curr.getKey().equals(key)){
                    Object replaced = curr.getValue();
                    curr.setValue(value);
                    return (V) replaced;
                }
                //if key is less than curr.key
                else if(((Integer)node.getKey())
                .compareTo((Integer)curr.getKey()) < 0){
                    //if there is no left child, stop
                    if(curr.getLeft() == null){
                        node.setParent(curr);
                        curr.setLeft(node);
                    }
                    else{
                        curr = curr.getLeft();
                    }
                }
                //if key is greater than or equal to curr.key
                else {
                    //if there is no right child, stop
                    if(curr.getRight() == null){
                        node.setParent(curr);
                        curr.setRight(node);
                    }
                    else{
                        curr = curr.getRight();
                    }
                }
            }
        }   
        return null;
    }

    /**
     * This helper method search for a node with key equal to key
     * @param key key to be searched
     * @return node with same key
     */
    private MyBSTNode searchHelper(K key){
        MyBSTNode<K,V> curr = root;
        //if key is null
        if(key == null){
            return null;
        }
        //Looking for node
        while(curr != null){
            //if equal, return
            if(key == curr.getKey()){
                return curr;
            }
            //if less than, go left
            else if(key.compareTo(curr.getKey()) < 0){
                curr = curr.getLeft();
            }
            else{
                curr = curr.getRight();
            }
        }
        //Not found
        return null;
    }

    /**
     * This method search for a node with key equal to key
     * @param key key to be searched
     * @return value of node
     */
    public V search(K key){
        //if key is null
        if(key == null){
            return null;
        }
        else if(this.searchHelper(key) == null){
            return null;
        }
        return (V)this.searchHelper(key).getValue();
    }

    /**
     * This method remove the node with key from tree
     * @param key key to be removed
     * @return 
     */
    public V remove(K key){
        //check if node exist or key is null
        if(this.searchHelper(key) == null || 
        key == null){
            return null;
        }
        MyBSTNode<K,V> curr = this.searchHelper(key);
        MyBSTNode<K,V> parent = curr.getParent();
        Object value = curr.getValue();
        //check if node is leaf
        if(curr.getLeft() == null && curr.getRight() == null){
            //check relation between curr and parent
            if(parent == null){
                this.root = null;
            }
            else if(parent.getLeft() == curr){
                parent.setLeft(null);
            }
            else{
                parent.setRight(null);
            }
            this.size--;
        }
        //check if curr has one left child
        else if(curr.getRight() == null){
            //check relation between curr and parent
            if(parent == null){
                this.root = curr.getLeft();
            }
            else if(parent.getLeft() == curr){
                parent.setLeft(curr.getLeft());
            }
            else{
                parent.setRight(curr.getLeft());
            }
            this.size--;
        }
        //check if curr has one right child
        else if(curr.getLeft() == null){
            //check relation between curr and parent
            if(parent == null){
                this.root = curr.getRight();
            }
            else if(parent.getLeft() == curr){
                parent.setLeft(curr.getRight());
            }
            else{
                parent.setRight(curr.getRight());
            }
            this.size--;
        }
        //if curr has two child
        else{
            //swap with successor
            MyBSTNode<K,V> successor = curr.successor();
            this.remove(successor.getKey());
            curr.setKey(successor.getKey());
            curr.setValue(successor.getValue());
        }
        return (V)value;
    }
    
    

    /**
     * This method add nodes of tree to arraylist in key order
     * @return arraylist of nodes from BST
     */
    public ArrayList<MyBSTNode<K, V>> inorder(){
        ArrayList<MyBSTNode<K, V>> BSTArray = new ArrayList<MyBSTNode<K, V>>();
        //check if size = 0
        if(size == 0){
            return BSTArray;
        }
        MyBSTNode<K,V> curr = this.root;
        //find smallest node
        while(curr.getLeft() != null){
            curr = curr.getLeft();
        }
        //add nodes using successor
        while(curr != null){
            BSTArray.add(curr);
            curr = curr.successor();
        }
        return BSTArray;
    }

    /**
     * This is MyBSTNode class that contains all function of a node
     * of BST.
     */
    static class MyBSTNode<K,V>{
        private static final String TEMPLATE = "Key: %s, Value: %s";
        private static final String NULL_STR = "null";

        private K key;
        private V value;
        private MyBSTNode<K,V> parent;
        private MyBSTNode<K,V> left = null;
        private MyBSTNode<K,V> right = null;

        /**
         * Creates a MyBSTNode<K,V> storing specified data
         * @param key the key the MyBSTNode<K,V> will
         * @param value the data the MyBSTNode<K,V> will store
         * @param parent the parent of this node
         */
        public MyBSTNode(K key, V value, MyBSTNode<K, V> parent){
            this.key = key;
            this.value = value;
            this.parent = parent; 
        }

        /**
         * Return the key stored in the the MyBSTNode<K,V>
         * @return the key stored in the MyBSTNode<K,V>
         */
        public K getKey(){
            return key;
        }

        /**
         * Return data stored in the MyBSTNode<K,V>
         * @return the data stored in the MyBSTNode<K,V>
         */
        public V getValue(){
            return value;
        }

        /**
         * Return the parent
         * @return the parent
         */
        public MyBSTNode<K,V> getParent(){
            return parent;
        }

        /**
         * Return the left child 
         * @return left child
         */
        public MyBSTNode<K,V> getLeft(){
            return left;
        }

        /**
         * Return the right child 
         * @return right child
         */
        public MyBSTNode<K,V> getRight(){
            return right;
        }

        /**
         * Set the key stored in the MyBSTNode<K,V>
         * @param newKey the key to be stored
         */
        public void setKey(K newKey){
            this.key = newKey;
        }

        /**
         * Set the data stored in the MyBSTNode<K,V>
         * @param newValue the data to be stored
         */
        public void setValue(V newValue){
            this.value = newValue;
        }

        /**
         * Set the parent
         * @param newParent the parent
         */
        public void setParent(MyBSTNode<K,V> newParent){
            this.parent = newParent;
        }

        /**
         * Set the left child
         * @param newLeft the new left child
         */
        public void setLeft(MyBSTNode<K,V> newLeft){
            this.left = newLeft;
        }

        /**
         * Set the right child
         * @param newRight the new right child
         */
        public void setRight(MyBSTNode<K,V> newRight){
            this.right = newRight;
        }

        /**
         * This method returns the in order successor of current node object.
         * It can be served as a helper method when implementing inorder().
         * @return the successor of current node object
         */
        public MyBSTNode<K, V> successor(){
            //check if there is larger child
            if(this.getRight() != null){
                MyBSTNode<K,V> curr = this.getRight();
                //get the smallest node on the right subtree
                while(curr.getLeft() != null){
                    curr = curr.getLeft();
                }
                return curr;
            }
            else{
                //if there is no right child
                MyBSTNode<K,V> parent = this.getParent();
                MyBSTNode<K,V> curr = this;
                //get the smallest parent
                while(parent != null && curr == parent.getRight()){
                    curr = parent;
                    parent = parent.getParent();
                }
                return parent;
            }
        }

        /**
         * This method return the in order predecessor of current node object
         * @return the predecessor of the current node object
         */
        public MyBSTNode<K, V> predecessor(){
            //check if there is smaller child
            if(this.getLeft() != null){
                MyBSTNode<K,V> curr = this.getLeft();
                //get the largest node on the right subtree
                while(curr.getRight() != null){
                    curr = curr.getRight();
                }
                return curr;
            }
            else{
                //if there is no left child
                MyBSTNode<K,V> parent = this.getParent();
                MyBSTNode<K,V> curr = this;
                //get the largest parent
                while(parent != null && curr == parent.getLeft()){
                    curr = parent;
                    parent = parent.getParent();
                }
                return parent;
            }
        }

        /** This method compares if two node objects are equal.
         * @param obj The target object that the currect object compares to.
         * @return Boolean value indicates if two node objects are equal
         */
        public boolean equals(Object obj){
            if (!(obj instanceof MyBSTNode))
                return false;

            MyBSTNode<K,V> comp = (MyBSTNode<K,V>)obj;
            
            return( (this.getKey() == null ? comp.getKey() == null : 
                this.getKey().equals(comp.getKey())) 
                && (this.getValue() == null ? comp.getValue() == null : 
                this.getValue().equals(comp.getValue())));
        }

        /**
         * This method gives a string representation of node object.
         * @return "Key:Value" that represents the node object
         */
        public String toString(){
            return String.format(
                    TEMPLATE,
                    this.getKey() == null ? NULL_STR : this.getKey(),
                    this.getValue() == null ? NULL_STR : this.getValue());
        }
    }


    
}