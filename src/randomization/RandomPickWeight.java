package randomization;

import java.util.Random;
import java.util.TreeMap;

public class RandomPickWeight {
    // This solution makes use of a treemap to fetch the index associated with
    // a random picked value.
    // If the random generator generates a value x, look for a value atleast greater than x,
    // and return the mapped index.

    // Time complexity: O(NlogW) where N is the number of calls, and W is the size of the array.
    TreeMap<Integer, Integer> map = new TreeMap<>();
    Random r = new Random();
    public RandomPickWeight(int[] w) {
        int sum = 0;
        for (int i = 0 ; i < w.length ; i++)    {
            sum += w[i];
            map.put(sum, i);
        }
    }

    public int pickIndex() {
        int random = r.nextInt(map.lastEntry().getKey());
        return map.higherEntry(random).getValue();
    }
}


