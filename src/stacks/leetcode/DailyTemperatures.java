package stacks.leetcode;

import java.util.TreeMap;

import java.util.*;
public class DailyTemperatures {
    /*** Non Stack Version
    public int[] dailyTemperatures(int[] ts) {
        Map<Integer, Integer> tm = new TreeMap<>();
        int next[] = new int[ts.length];

        for ( int i = ts.length - 1 ; i >= 0 ; i--) {
            next[i] = getNext(ts, i, tm);
            tm.put(ts[i], i);
        }

        return next;
    }
    private int getNext(int[] ts, int i, Map<Integer, Integer> tm) {

        int nearest = 0;
        for (Map.Entry<Integer, Integer> e : tm.entrySet()) {
            if ( e.getKey() > ts[i] )
                nearest = Math.min(nearest, e.getValue() - i);
        }

        return nearest;
    }

     ***/

    public int[] dailyTemperatures(int[] ts) {
        Stack<Integer> stack = new Stack<>();
        int next[] = new int[ts.length];

        for ( int i = ts.length - 1 ; i >= 0 ; i--) {
            while ( stack.size() != 0 && ts[i] > ts[stack.peek()])  stack.pop();
            next[i] = stack.size() == 0 ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return next;
    }

}
