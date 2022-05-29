/**
 * Name: Kun Wang
 * ID: A16807435
 * Email: kuw010@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * This is the customer tester for the classes of PA5. 
 * It contains all custom tests
 */

import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * This class contains all custom test for all classes of PA5
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {

    // ----------------Student class----------------
    /**
     * Test the equals method when same last name,
     * same first name, different PID
     */
    @Test
    public void testEquals() {
        Student A = new Student("A","a", "123");
        Student B = new Student("A","a", "122");
        assertFalse(A.equals(B));
    }

    /**
     * Test the compareTo method when one student has firstname in front,
     * but lastname in back compare to the other
     */
    @Test
    public void testCompareTo() {
        Student A = new Student("Aaron", "Xia", "123");
        Student B = new Student("Baron", "Chu", "123");
        assertEquals(true, A.compareTo(B) > 0); //A should come after B
    }

    // ----------------Course class----------------
    /**
     * Test the enroll method when course is full
     */
    @Test
    public void testEnroll() {
        Course CSE12 = new Course("CSE", "number","Amaizing class", 1);
        Student A = new Student("Aaron", "Xia", "123");
        Student B = new Student("Baron", "Chu", "123");
        CSE12.enroll(A);
        assertFalse(CSE12.enroll(B));
    }

    /**
     * Test the unenroll method when student is not in class
     */
    @Test
    public void testUnenroll() {
        Course CSE12 = new Course("CSE", "number","Amaizing class", 1);
        Student A = new Student("Aaron", "Xia", "123");
        Student B = new Student("Baron", "Chu", "123");
        CSE12.enroll(A);
        assertFalse(CSE12.unenroll(B));
    }

    /**
     * Test the getRoster method when there are two students with second student
     * added being infront.
     */
    @Test
    public void testGetRoster() {
        Course CSE12 = new Course("CSE", "number","Amaizing class", 2);
        Student A = new Student("Aaron", "Xia", "123");
        Student B = new Student("Baron", "Chu", "123");
        CSE12.enroll(A);
        CSE12.enroll(B);

        ArrayList<Student> Roster = new ArrayList<>();
        Roster.add(B);
        Roster.add(A);

        ArrayList<Student> Roster2 = CSE12.getRoster();

        assertEquals(Roster, Roster2);
    }


    // ----------------Sanctuary class----------------
    /**
     * Test the constructor when maxAnimal/Species is less than 0
     */
    @Test
    public void testSanctuaryConstructor() {
        boolean exceptionThrown = false;
        try{
            Sanctuary S = new Sanctuary(-1, -1);
        } catch(IllegalArgumentException e){
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    /**
     * Test the rescue method when sanctury doesnot have
     * enough space
     */
    @Test
    public void testRescueTestOne(){
        Sanctuary S = new Sanctuary(10, 2);
        assertEquals(5,S.rescue("Dog", 15));
    }

    /**
     * Test the rescue method when num is 0
     */
    @Test
    public void testRescueTestTwo(){
        Sanctuary S = new Sanctuary(10, 2);
        boolean exceptionThrown = false;
        try{
            S.rescue("cat", 0);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);

    }

    /**
     * Test the release method when num is down to 0
     */
    @Test
    public void testReleaseTestOne(){
        Sanctuary S = new Sanctuary(10, 2);
        S.rescue("Dog", 5);
        S.rescue("Cat", 5);
        S.release("Dog", 5);
        assertEquals(1, S.getTotalSpecies());
    }

    /**
     * Test the release method when num is equal 0
     */
    @Test
    public void testReleaseTestTwo(){
        Sanctuary S = new Sanctuary(10, 2);
        boolean exceptionThrown = false;
        try{
            S.release("cat", 0);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }
}

