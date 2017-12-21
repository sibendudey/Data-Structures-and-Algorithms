package dynamic.programming.leetcode;

import java.util.Arrays;

public class PartitionKSubsets {
    public static void main(String args[])  {
        PartitionKSubsets pk = new PartitionKSubsets();
        System.out.println(pk.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1} , 4));
        System.out.println(pk.canPartitionKSubsets(new int[]{0 , 0 , 0 , 0 , 0 } , 4));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = Arrays.stream(nums).sum();
        if ( totalSum % k != 0)
            return false;

        int targetSum = totalSum / k;
        boolean[] visited = new boolean[nums.length];
        return canPartitionHelper(nums, visited, 0, k , 0 , targetSum);

    }

    private boolean canPartitionHelper(int[] nums, boolean[] visited, int start_index, int k, int cur_sum, int target) {
        if(k==1)return true;
        if(cur_sum == target /*&& cur_num>0*/)
            return canPartitionHelper(nums, visited, 0, k-1, 0, /*0,*/ target);
        for(int i = start_index; i<nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                if(canPartitionHelper(nums, visited, i+1, k, cur_sum + nums[i], /*cur_num++,*/
                        target))return true;
                visited[i] = false;
            }
        }
        return false;
    }
}
