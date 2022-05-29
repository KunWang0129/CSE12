/**
 * Name:Kun Wang
 * ID: A16807435
 * Email: kuw010@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * This is the MyArrayList class. It contains methods and functions of a MyArrayList
 */

 /**
  * This class setup all the methods and functions for MyArrayList object.
  * MyArrayList object has similar functions as the ArrayList object.
  */

public class MyArrayList<E> implements MyList<E> {

    Object[] data;
    int size;
    final int defaultCapacity = 5;
    int doubleSize = 2;

    /**
	 * This is the default constructor of MtArrayList, which sets
     * the array data with capacity of 5
     *  */
    public MyArrayList(){
        this.data = new Object[this.defaultCapacity];
    }

    /**
	 * This is a constructor of MtArrayList, which sets
     * the array data with capacity of initialCapacity
     * @param initialCapacity inital capacity of the array
     *  */
    public MyArrayList(int initialCapacity){
        //Check if index is valid
        if(initialCapacity < 0){
            throw new IllegalArgumentException();
        }
        this.data = new Object[initialCapacity];
    }

    /**
	 * This is a constructor of MtArrayList, which initialize data with
     * a shallow copy of the array arr.
     * @param arr initaling array of data
     *  */
    public MyArrayList(E[] arr){
        //Use default constructor if arr is null
        if (arr == null){
            this.data = new Object[this.defaultCapacity];
        }
        else{
            this.data = arr;
            this.size = arr.length;
        }
    }

    /**
	 * This method changes the capacity of the array base on
     * the required capacity.
     * @param requiredCapacity capacity needed for the array
     *  */
    public void expandCapacity(int requiredCapacity){
        int capacity = this.data.length;
        //Check if index is valid
        if(requiredCapacity < capacity){
            throw new IllegalArgumentException();
        }
        //Checks if capacity is 0
        if(capacity == 0){
            capacity = defaultCapacity;
        }
         //Check if doubling isn't enough
        if(capacity*doubleSize < requiredCapacity){
            capacity = requiredCapacity;
        }
        //Doubling capacity
        else if(capacity < requiredCapacity){
            capacity = doubleSize*capacity;
        }
        //Creates clone
        Object[] dataC = data.clone();
        data = new Object[capacity];
        //Enter elements into new array
        for(int i=0; i<size; i++){
            data[i] = dataC[i];
        }
          
    }

    /**
	 * This method gets the capacity of the array 
     *  */
    public int getCapacity(){
        return this.data.length;
    }

    /**
	 * This method insert an element at the specified index for
     * MyArrayList
     * @param index index of which element is inserted
     * @param element element to be inserted
     *  */
    public void insert(int index, E element){
        int capacity = this.data.length;
        //Check if index is valid
        if(index < 0 || index > this.size){
            throw new IndexOutOfBoundsException();
        }
        //Check to expand capacity
        if(this.size == capacity){
            expandCapacity(this.size+1);
        }
        //Copy data from old array
        int i = this.size-1;
        while(i >=0){
            if(i >= index){
                Object t = this.data[i];
                this.data[i+1] = t;
            }
            i--;
        }
        //insert new element
        data[index] = element;
        size++;
    }   

    /**
	 * This method add an element at the end of the list
     * @param element element to be appended
     *  */
    public void append(E element){
        int capacity = this.data.length;
        //Create clone
        Object[] dataC = data.clone();
        //Check to expand capacity
        if(this.size == capacity){
            expandCapacity(this.size+1);
        }
        //Check if original has size 0
        if(dataC.length == 0){
            expandCapacity(size+1);
            data[0] = element;
        }
        else{ 
            //Add elements from previous array
            for (int i=0; i<size; i++){
              data[i] = dataC[i];
            }
            //Add new element
            data[size] = element;
        }
        size++;
    }

    /**
	 * This method add an element at the begining of the list
     * @param element element to be prepended
     *  */
    public void prepend(E element){
        int capacity = this.data.length;
        //Create clone
        Object[] dataC = data.clone();
        //Check to expand capacity
        if(this.size == capacity){
            expandCapacity(this.size+1);
        }
        //Add elements from previous array
        for (int i=0; i<size; i++){
            data[i+1] = dataC[i];
        }
        //Add new element
        data[0] = element;
        size++;
    }

    /**
	 * This method return the element at specified index of array
     * @param index index of element 
     * @return element at index
     *  */
    @SuppressWarnings("unchecked")
    public E get(int index){
        return (E)this.data[index];
    }

    /**
	 * This method return the element at specified index of array
     * @param index index of element 
     * @return overwritten element
     *  */
    @SuppressWarnings("unchecked")
    public E set(int index, E element){
        //Check if index is valid
        if(index < 0 || index > this.size){
            throw new IndexOutOfBoundsException();
        }
        //Record removed element
        E Removed = (E)this.data[index];
        this.data[index] = element;
        return Removed;
    }

    /**
	 * This method remove the element at specified index of array
     * @param index index of element 
     * @return element removed
     *  */
    @SuppressWarnings("unchecked")
    public E remove(int index){
        int capacity = this.data.length;
        //Check if index is valid
        if(index < 0 || index > this.size){
            throw new IndexOutOfBoundsException();
        }
        E Removed = (E)this.data[index];
        //Create clone
        Object[] dataC = data.clone();
        this.data = new Object[capacity];

        //Copy data from old array without Removed
        int i = 0;
        while(i < size){
            if(i < index){
                this.data[i] = dataC[i];
            }
            else if(i > index){
                this.data[i-1] = dataC[i];
            }
            i++;
        }
        size--;
        return Removed;
    }

    /**
	 * This method return the size of MyArrayList
     * @return size
     *  */
    public int size(){
        return this.size;
    }
}
 // Hint: the 'capacity' (length of data array) is not the same as the 'size'
 // Size is the number of elements in the ArrayList, i.e., the number of valid
 // elements in the array
