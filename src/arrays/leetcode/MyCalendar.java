package arrays.leetcode;


import java.util.*;

class MyCalendar {

    Set<Schedule> schedules = new TreeSet<>((schedule1, schedule2) -> {
        if (schedule1.start.compareTo(schedule2.start) == 0)
            return -1;

        else return schedule1.start.compareTo(schedule2.start);
    });

    int minStart = -1;
    int maxEnd = -1;

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        if (schedules
                .stream()
                .filter(schedule -> !(end <= schedule.start)).count() == 2)

            return false;

        else if (schedules
                .stream()
                .filter(schedule -> !(start >= schedule.end)).count() == 2)

            return false;

        else    {
            schedules.add(new Schedule(start, end));
            return true;
        }
    }

    private static class Schedule   {
        Integer start;
        Integer end;

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String args[])  {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20)); // returns true
        System.out.println(myCalendar.book(50, 60)); // returns true
        System.out.println(myCalendar.book(10, 40)); // returns true
        System.out.println(myCalendar.book(5, 15)); // returns false
        System.out.println(myCalendar.book(5, 10)); // returns true
        System.out.println(myCalendar.book(25, 55)); // returns true
    }
}
