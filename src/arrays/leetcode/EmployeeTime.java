package arrays.leetcode;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTime {
    class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static int OPEN = 0, CLOSE = 1;

    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
        List<int[]> events = new ArrayList<>();
        for (List<Interval> interval : avails) {
            for (Interval iv : interval) {
                events.add(new int[]{iv.start, OPEN});
                events.add(new int[]{iv.end, CLOSE});
            }
        }

        List<Interval> freeTime = new ArrayList<>();
        int bal = 0, prev = -1;

        for ( int [] event : events)    {
            if ( bal == 0 && prev > 0)  {
                freeTime.add(new Interval(prev, event[0]));
            }
            bal += event[1] == OPEN ? 1 : -1;
            prev = event[0];
        }

        return freeTime;
    }
}
