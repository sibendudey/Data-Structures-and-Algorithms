package graphs.leetcode;

import java.util.*;

public class NearestTime {

    public static int max_diff = Integer.MAX_VALUE;
    public static String nearestTime = "";

    public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);
        // Enter time in hh:mm format
        String time = sc.next();
        findNearestTime(time);
        System.out.println(nearestTime);
    }

    private static void findNearestTime(String time) {
        Set<Integer> digitSet = new HashSet<>();
        for ( char ch : time.toCharArray()) {
            if (Character.isDigit(ch)) {
                digitSet.add(ch - '0');
            }
        }

        if (digitSet.size() == 1)   {
            nearestTime = time;
            return;
        }

        List<Integer> digitList = new ArrayList<>(digitSet);
        int timeMinutes = convertTimeToMinutes(time);
        String curr = "";
        findNearestTimeUtil(digitList, curr , timeMinutes, 0);
        
    }

    private static int convertTimeToMinutes(String time) {
        return (Integer.parseInt(time.substring(0,2)) * 60 + Integer.parseInt(time.substring(3,5)));
    }

    private static void findNearestTimeUtil(List<Integer> digitList, String curr, int time, int pos) {
        if ( pos == 4)  {
            curr = curr.substring(0 , 2) + ":" + curr.substring(2);
            int currTimeInMinutes = convertTimeToMinutes(curr.toString());
            int diff = currTimeInMinutes - time > 0 ? currTimeInMinutes - time :
                    1440 + currTimeInMinutes - time;
            if ( max_diff > diff)   {
                nearestTime = curr.toString();
                max_diff = diff;
            }
            return;
        }

        for ( int i = 0 ; i < digitList.size() ; i++ )   {
            if ( pos == 0 && digitList.get(i) > 2) continue;
            if ( pos == 1 && (Integer.parseInt(curr.toString()) * 10  + digitList.get(i) > 23)) continue;
            if ( pos == 2 && (digitList.get(i) > 5)) continue;
            if ( pos == 3 && (Integer.parseInt(curr.substring(2)) * 10 + digitList.get(i) > 59)) continue;
            findNearestTimeUtil(digitList , curr + digitList.get(i) , time , pos + 1);

        }
    }
}
