package arrays.leetcode;

import java.util.*;
public class DegreeArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> firstPos = new HashMap<>();
        Map<Integer, Integer> frequency = new HashMap<>();
        int maxFrequency = Integer.MIN_VALUE;
        int size = Integer.MAX_VALUE;
        for ( int i = 0 ; i < nums.length ; i++)    {
            firstPos.putIfAbsent(nums[i], i);
            frequency.putIfAbsent(nums[i], 0);
            int count = frequency.get(nums[i]) + 1;
            frequency.put(nums[i], count);
            if ( count == maxFrequency) {
                size = Math.min(size , i - firstPos.get(nums[i]) + 1);
            }
            else if ( count > maxFrequency) {
                size = i - firstPos.get(nums[i]) + 1;
                maxFrequency = count;
            }
        }

        return size;
    }

    public static void main(String args[])  {
        int arr[] = new int[]{1,2,2,3,1,4,2};
        //System.out.println(new DegreeArray().findShortestSubArray(arr));

        int arr2[] = new int[]{10, 5, 1, 6, 1};
        System.out.println(new DegreeArray().numSubarrayProductLessThanK(arr2, 60));
    }

    int numSubarrayProductLessThanK(int [] nums, int k) {
        if (k <= 1) return 0;
        int n = nums.length, prod = 1, ans = 0, left = 0;
        for (int i = 0; i < n; i++) {
            prod *= nums[i];
            while (prod >= k) prod /= nums[left++];
            ans += i - left + 1;
        }
        return ans;
    }

    public int maximumSwap(int num) {
        char[] numString = Integer.toString(num).toCharArray();
        int maxIndex = numString.length - 1;
        int swapIndex1 = -1;
        int swapIndex2 = -1;
        for (int i = numString.length ; i >= 0 ; i--)   {
            char charI = numString[i];
            char maxCharI = numString[maxIndex];
            if ( charI > maxCharI)  {
                maxIndex = i;
            }
            else if ( charI < maxCharI ) {
                swapIndex1 = i;
                swapIndex2 = maxIndex;
            }
        }

        if ( swapIndex1 == -1)
            return num;

        char first = numString[swapIndex1];
        numString[swapIndex1] = numString[swapIndex2];
        numString[swapIndex2] = first;

        return Integer.parseInt(String.valueOf(numString));
    }


}
