
/**
 * Name: Kun Wang
 * Email: kuw010@ucsd.edu
 * Sources used: none
 * 
 * This is the calendar file that contains my implementation of 
 * a calender
 */

 /**
  * This is the MyCalendar class that contains all methods and variables
  * of a calendar
  */
public class MyCalendar {
    MyTreeMap<Integer, Integer> calendar;
    
    final int one = 1;
    /**
     * This is the constructor of MyCalendar. It initialize variables 
     * of MyCalendar
     */
    public MyCalendar() {
        calendar = new MyTreeMap<>();
    }
    
    /**
     * This method 
     * @param start
     * @param end
     * @return
     */
    public boolean book(int start, int end) {
        //check if start and end is legal
        if(start < 0 || start >= end){
            throw new IllegalArgumentException();
        }
        //check if there is no bookings
        if(calendar.ceilingKey(start) == null || 
        calendar.floorKey(end) == null){
        }
        //check if there is node between start and end
        else if(calendar.ceilingKey(start) < end && 
            calendar.floorKey(end) > start){
            return false;
        }
        calendar.put(start, one);
        calendar.put(end,one);
        return true;
    }

    /**
     * This method get the calendar
     * @return calendar
     */
    public MyTreeMap<Integer, Integer> getCalendar(){
        return this.calendar;
    }
}