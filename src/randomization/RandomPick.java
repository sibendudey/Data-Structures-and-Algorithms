package randomization;

import java.util.*;

/**
 * Leetcode problem 398.
 * Time complexity: O(1) for pick operation.
 *
 */
public class RandomPick {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Random r = new Random();
    public RandomPick(int[] nums) {
        for (int i = 0 ; i < nums.length ; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> l = map.get(target);
        int random = r.nextInt(l.size());
        return l.get(random);
    }
}
