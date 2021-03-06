
/**
 * Name: Kun Wang
 * ID: A16807435
 * Email: kuw010@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * This is the student class. 
 * It contains all methods and variables of a Student
 */

import java.util.Objects;


/**
 * The student class contains all functions of a student
 */

public class Student implements Comparable<Student> {
    private final String firstName;
    private final String lastName;
    private final String PID;

    /**
     * This is the contructor of the student class, which
     * setup all variables
     * @param firstName The first name of student
     * @param lastName The last name of student
     * @param PID PID of student
     */
    public Student(String firstName, String lastName, String PID) {
        //Check for null variables
        if(firstName == null || lastName == null || PID == null){
            throw new IllegalArgumentException();
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.PID = PID;
    }

    /**
     * This method get the last name of student
     * @return lastName
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * This method get the first name of student
     * @return firstName
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * This method get the PID of student
     * @return PID
     */
    public String getPID() {
        return this.PID;
    }


    /**
     * This method overrides the equal method
     * @param o object to be compared to
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        //Check if o is a student
        if(o instanceof Student && o != null){
            Student s = (Student)o;
            //Compare value of instance variables
            if(s.getFirstName().compareTo(firstName) == 0 &&
            s.getLastName().compareTo(lastName) == 0  &&
            s.getPID().compareTo(PID) == 0 ){
                return true;
            }
        }
        return false;
    }

    /**
     * This method overrides the hashCode method
     * @return Hash valued generated by Object's hash function
     */
    @Override
    public int hashCode() {
        return Objects.hash(firstName,lastName,PID);
    }
    /**
     * This method overrides the compareTo method
     * @return a number depending on the comparison
     */
    @Override
    public int compareTo(Student o) {
        //compare lastName
        if(this.lastName.compareTo(o.getLastName()) != 0){
            return this.lastName.compareTo(o.getLastName());
        }
        //compare firstName
        else if(this.firstName.compareTo(o.getFirstName()) != 0){
            return this.firstName.compareTo(o.getFirstName());
        }
        //compare PID
        else if(this.PID.compareTo(o.getPID()) != 0){
            return this.PID.compareTo(o.getPID());
        }
        //return 0 if everything is equal
        return 0;
    }
}
