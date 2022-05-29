/**
 * Name: Kun Wang
 * ID: A16807435
 * Email: kuw010@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * This is the course class. 
 * It contains all methods and variables of a course
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * The student class contains all functions of a Course
 */

public class Course {
    HashSet<Student> enrolled;
    private final int capacity;
    private final String department;
    private final String number;
    private final String description;

    /**
     * This is the constructor of the Course class
     * It setup all variables of 
     * @param department
     * @param number
     * @param description
     * @param capacity
     */
    public Course(String department, String number, String description, 
        int capacity){
            if(department == null || number == null || 
            description == null || capacity <= 0){
                throw new IllegalArgumentException();
            }
            this.department = department;
            this.number = number;
            this.description = description;
            this.capacity = capacity;
            this.enrolled = new HashSet<Student>();
        }

    /**
     * This method return the department of the course
     * @return department
     */
    public String getDepartment(){
        return this.department;
    }

    /**
     * This method get the course number
     * @return course number
     */
    public String getNumber(){
        return this.number;
    }

    /**
     * This method get the description of the course
     * @return description
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * This method get the capacity of the course
     * @return capacity
     */
    public int getCapacity(){
        return this.capacity;
    }

    /**
     * This method enroll the student into the course
     * @param student student to be enrolled
     * @return enroll success of not
     */
    public boolean enroll(Student student) {
        //Check for illegal argument
        if(student == null){
            throw new IllegalArgumentException();
        }
        //check if student can be enrolled in course
        if(enrolled.size() < this.capacity && 
        enrolled.contains(student) == false){
            enrolled.add(student);
            return true;
        }
        return false;
    }

    /**
     * This method unenroll the student from course
     * @param student student to be removed
     * @return unenroll sucess or not
     */
    public boolean unenroll(Student student) {
        //check if student is null
        if(student == null){
            throw new IllegalArgumentException();
        }
        //check if student is in the course
        if(enrolled.contains(student)){
            enrolled.remove(student);
            return true;
        }
        return false;
    }

    /**
     * This method cancel the course
     */
    public void cancel() {
        //Remove all student from course
        enrolled.clear();
    }

    /**
     * This method check if course if full
     * @return whether course is full
     */
    public boolean isFull() {
        //Check if size is equal to capacity
        if(enrolled.size() == this.capacity){
            return true;
        }
        return false;
    }

    /**
     * This method get the number of enrolled students
     * @return number of enrolled student
     */
    public int getEnrolledCount() {
        return enrolled.size();
    }

    /**
     * This method get the availabe seats in the course
     * @return avaliable seat count
     */
    public int getAvailableSeats() {
        return this.capacity - enrolled.size();
    }

    /**
     * This method return a shallow copy of enrolled students
     * @return a clone of enrolled
     */
    public HashSet<Student> getStudents() {
        HashSet<Student> S = (HashSet<Student>)enrolled.clone();
        return S;
    }

    /**
     * This method get the roster of the course
     * @return an arraylist of students
     */
    public ArrayList<Student> getRoster() {
        ArrayList<Student> Roster = new ArrayList<>();
        Object[] roster = enrolled.toArray();
        //Use loop to add all student to Roster
        for(int i = 0; i<roster.length; i++){
            Roster.add((Student)roster[i]);
        }
        //Sort the arraylist
        Collections.sort(Roster);
        return Roster;
    }

    /**
     * This method overrides the toString method
     * @return string representation of Course object
     */
    @Override
    public String toString() {
        String template = "%s";
        String space = " ";
        String template2 = "[%s]";
        String nextLine = "\n";
        String dep = String.format(template+space, this.department);
        String num = String.format(template+space, this.number);
        String cap = String.format(template2+nextLine, this.capacity);
        String des = String.format(template, this.description);
        return dep + num + cap + des;
    }

    public static void main(String[] args) {
        String A = "ABB";
        String B = "BBA";
        System.out.println(A.hashCode());
        System.out.println(B.hashCode());
    }
}

