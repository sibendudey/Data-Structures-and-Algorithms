package arrays.leetcode;

import java.util.Scanner;

public class MinCostClimbingStairs {
    public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for ( int i = 0 ; i < N ; i++)  {
            arr[i] = sc.nextInt();
        }

        System.out.println(findMinCost(arr));
    }

    private static int findMinCost(int[] cost) {
        if ( cost.length == 2)
            return Math.min(cost[0], cost[1]);

        if ( cost.length == 1)
            return cost[0];

        if ( cost.length == 0)
            return -1;


        int dp[] = new int[cost.length + 1];

        dp[cost.length] = cost[cost.length - 1];

        dp[cost.length - 1] = cost[cost.length - 2];

        for ( int i = cost.length - 2 ; i > 0 ; i--)    {
            dp[i] = cost[i-1] + Math.min(dp[i+1], dp[i+2]);
        }

        return Math.min(dp[1], dp[2]);
    }
}
