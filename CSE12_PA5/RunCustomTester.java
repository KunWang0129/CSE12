
/**
 * Name: Rundong Guo
 * ID: A17138501
 * Email: r1guo@ucsd.edu
 * this is my test files for Pa 5, I write couple tests folloew by
 * the PA5 instructions
 * 
 */

import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * This is a class called Custom Tester
 * it contains various test cases that 
 * would test the methods I write in student, 
 * course and sanctuary class
 */
public class RunCustomTester {
    private final Student S1 = new Student(new String("Rundong"),
            new String("Guo"), new String("A17138501"));
    private final Student S2 = new Student(new String("Fu"),
            new String("Jhon"), new String("A9502323"));
    private final Student S3 = new Student(new String("justin"),
            new String("justin"), new String("A979797"));
    private final Student S4 = new Student(new String("justin"),
            new String("justin"), new String("A979797"));
    private final Student S5 = null;
    private final Course C1 = new Course("Math", "109",
            "Mathematical Reasoning", 40);

    private final int negative = -1;
    // ----------------Student class----------------
    /**
     * Test the equals method when [TODO: fill in a possible edge case here]
     */
    @Test
    public void testEquals() {
        assertEquals(false,S1.equals(S2));;
    }

    /**
     * Test the compareTo method when [TODO]
     */
    @Test
    public void testCompareTo() {
        assertEquals(0, S3.compareTo(S4));
        assertTrue(S1.compareTo(S2) < 0);
    }

    // ----------------Course class----------------


    @Test(expected = IllegalArgumentException.class)
    public void testEnroll(){
            C1.enrolled = new HashSet<>();
            C1.enroll(S5);
        }
    @Test(expected = IllegalArgumentException.class)
    public void testUnenroll() {
        Course C1 = new Course("Math", "109",
                "Mathematical Reasoning", 40);
        C1.enrolled = new HashSet<>();
        C1.enrolled.add(S1);
        C1.enrolled.add(S2);
        C1.enrolled.add(S3);
        C1.enrolled.add(S4);
        C1.unenroll(S5);
    }

    /**
     * Test the getRoster method when [TODO]
     */
    @Test
    public void testGetRoster() {
        Course C1 = new Course("Math", "109",
                "Mathematical Reasoning", 40);
        C1.enrolled = new HashSet<>();
        C1.enrolled.add(S1);
        C1.enrolled.add(S2);
        C1.enrolled.add(S3);
        List<Student> s = new ArrayList<>();
        s.add(S1);
        s.add(S2);
        s.add(S3);
        assertEquals(s,C1.getRoster());
        
    }

    // ----------------Sanctuary class----------------
    /**
     * Test the constructor when [TODO]
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSanctuaryConstructor() {
        Sanctuary ZOO = new Sanctuary(negative, negative);
    }

    /**
     * Test the rescue method when [TODO]
     */
    @Test
    public void testRescueTestOne(){
        Sanctuary s = new Sanctuary(5, 5);
        s.rescue("Dog", 4);
        assertEquals(6, s.rescue("Dog", 7));
    }

    /**
     * Test the rescue method when [TODO: fill in another one here]
     */
    @Test(expected = IllegalArgumentException.class)
    public void testRescueTestTwo(){
        Sanctuary s = new Sanctuary(1, 2);
        s.rescue("Cat", -1);
    }

    /**
     * Test the release method when [TODO]
     */
    @Test
    public void testReleaseTestOne(){
        Sanctuary s = new Sanctuary(5, 5);
        s.rescue("dog", 5);
        s.release("dog", 5);
        assertEquals(0, s.getTotalSpecies());
    }

    /**
     * Test the release method when [TODO:fill in another one here]
     */
    @Test(expected = IllegalArgumentException.class)
    public void testReleaseTestTwo(){
        Sanctuary s = new Sanctuary(5, 5);
        s.rescue("dog", 5);
        s.release("dog", -1);
    }
}

