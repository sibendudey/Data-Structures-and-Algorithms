package arrays.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.*;

public class KDiffPairs {
    public int findPairs(int[] nums, int k) {

        if ( k == 0)    {
            Map<Integer, Integer> countMap = new HashMap<>();
            for ( int i = 0 ; i < nums.length ; i++)    {
                countMap.putIfAbsent(nums[i], 0);
                countMap.put(nums[i], countMap.get(nums[i]) + 1);
            }

            return countMap.entrySet().stream()
                    .filter( entry -> entry.getValue() > 1)
                    .collect(() -> new AtomicInteger(0)
                    ,(at, entry) -> at.set(at.get() + entry.getValue())
                    , (at1, at2) -> at1.set(at1.get() + at2.get())).intValue();
        }
        else {
            Set<Integer> numbers = new TreeSet<>();
            Arrays.stream(nums).forEach(num -> numbers.add(num));
            AtomicInteger count = new AtomicInteger(0);

            numbers.stream()
                    .forEach(num -> {
                        if (numbers.contains(num + k)) count.incrementAndGet();
                    });

            return count.intValue();
        }
    }

    public static void main(String args[])  {
        System.out.println(new KDiffPairs().findPairs(new int[]{1,2,3,4,5}, 1));
    }
}
