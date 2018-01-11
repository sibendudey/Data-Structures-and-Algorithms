package arrays.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyCalendarTwo {

    public static void main(String args[])  {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(10, 20)); // returns true
        System.out.println(myCalendarTwo.book(50, 60)); // returns true
        System.out.println(myCalendarTwo.book(10, 40)); // returns true
        System.out.println(myCalendarTwo.book(5, 15)); // returns false
        System.out.println(myCalendarTwo.book(5, 10)); // returns true
        System.out.println(myCalendarTwo.book(25, 55)); // returns true
    }

    private List<Integer> arrivals = new ArrayList<>();
    private List<Integer> departures = new ArrayList<>();

    public MyCalendarTwo() {

    }

    static class Node   {
        int arrival;
        int departure;
        int count;
        Node left;
        Node right;

        public Node(int arrival, int departure) {
            this.arrival = arrival;
            this.departure = departure;
        }
    }

    public boolean book(int start, int end) {

        Integer START = start;
        Integer END = end;
        arrivals.add(START);
        departures.add(END);

        Collections.sort(arrivals);
        Collections.sort(departures);

        int arrivalIndex = 0;
        int departureIndex = 0;
        int consecutiveBooking = 0;
        while(arrivalIndex < arrivals.size())   {
            if ( arrivals.get(arrivalIndex) < departures.get(departureIndex))  {
                consecutiveBooking++;
                if ( consecutiveBooking == 3) {
                    arrivals.remove(START);
                    departures.remove(END);
                    return false;
                }
                arrivalIndex++;
            }
            else    {
                consecutiveBooking--;
                departureIndex++;
            }
        }

        return true;
    }
}
