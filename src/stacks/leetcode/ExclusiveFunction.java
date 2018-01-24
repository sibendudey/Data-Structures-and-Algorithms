package stacks.leetcode;

import java.util.List;
import java.util.*;

public class ExclusiveFunction {

    public static void main(String args[])  {
        String[] strs = new String[]{"0:start:0","1:start:2","1:end:5","0:end:6"};

        new ExclusiveFunction().exclusiveTime(4, Arrays.asList(strs));
    }
    class Log   {
        int time;
        int functionID;
        boolean start; // false indicates end

        public int getTime() {
            return time;
        }

        public int getFunctionID() {
            return functionID;
        }

        public boolean isStart() {
            return start;
        }

        public Log(int time, int functionID, boolean start) {
            this.time = time;
            this.functionID = functionID;
            this.start = start;
        }
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        Map<Integer, Integer> functionMap = new HashMap<>();
        Stack<Log> stack = new Stack<>();
        int time = 0;
        for ( int i = 0 ; i < logs.size() ; i++)    {
            Log log = parseLog(logs.get(i));
            if (!log.isStart()) {
                Log pop = stack.pop();
                int currTime = log.time - pop.time + 1 - time;
                time += currTime;
                functionMap.put(log.functionID, currTime);
            }
            else
                stack.push(log);
        }

        int result [] = new int[n];

        for ( Map.Entry<Integer, Integer> e : functionMap.entrySet())
            result[e.getKey()] = e.getValue();

        return result;
    }

    private Log parseLog(String s) {
        int functionId = Integer.parseInt(s.substring(0, s.indexOf(":")));
        String signal = s.substring(s.indexOf(":") + 1, s.lastIndexOf(":"));
        int time = Integer.parseInt(s.substring(s.lastIndexOf(":") + 1));
        return new Log(time, functionId, signal.equals("start"));
    }
}
