package hash.tables.leetcode;

/***
 * Leetcode solution : set-mismatch
 *
 * URL : https://leetcode.com/problems/set-mismatch/description/
 *
 */
public class DuplicateElement {

    public int[] findErrorNums(int[] nums) {
        int[] numbers = new int[nums.length];
        int duplicate = -1;
        int sum = 0;
        int expectedSum = (nums.length) * (nums.length + 1) / 2;
        for (int i = 0; i < nums.length; i++)   {
            if (++numbers[nums[i] - 1] > 1)
                duplicate = nums[i];
            sum += nums[i];
        }
        int difference = sum - expectedSum;
        return new int[]{duplicate,  duplicate - difference};
    }

}
