package arrays.leetcode;

import java.util.Arrays;
import java.util.*;

public class RightInterval {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int[] findRightInterval(Interval[] intervals) {
        //

        List<int[]> starts = new ArrayList<>();
        List<int[]> ends = new ArrayList<>();

        for ( int i = 0 ; i < intervals.length ; i++)   {
            starts.add(new int[]{ i , intervals[i].start});
            ends.add(new int[] { i, intervals[i].end});
        }

        Collections.sort(starts, (i1, i2) -> i1[1] == i2[1] ? -1 : i1[1] - i2[1] );
        Collections.sort(ends, (i1, i2) -> i1[1] == i2[1] ? -1 : i1[1] - i2[1] );

        int[] right = new int[intervals.length];
        int start = starts.size() - 1;
        int end = ends.size() - 1;
        while ( end >= 0) {
            if ( ends.get(end)[1] > starts.get(start)[1])  {
                right[ends.get(end)[0]] = start == starts.size() - 1 ? -1 : starts.get(start + 1)[0];
                end--;
            }
            else    {
                start--;
            }
        }

        return right;
    }
}
