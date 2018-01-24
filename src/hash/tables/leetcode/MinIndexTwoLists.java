package hash.tables.leetcode;

import java.util.LinkedHashSet;
import java.util.*;

public class MinIndexTwoLists {
    public static void main(String args[])  {

    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();

        for ( int i = 0 ; i < list1.length ; i++)
            map.put(list1[i], i);

        List<String> strings = new ArrayList<>();
        String res = "";
        int indexSum = Integer.MAX_VALUE;
        for ( int i = 0 ; i < list2.length ; i++)   {
            String curr = list2[i];
            if ( map.get(curr) != null) {
                int currSum = map.get(curr) + i;
                if ( currSum < indexSum)    {
                    strings = new ArrayList<>();
                    strings.add(curr);
                    indexSum = currSum;
                }
                else if ( currSum == indexSum )  {
                    strings.add(curr);
                }
            }
        }

        return strings.toArray(new String[] {});

    }
}
