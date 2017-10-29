package dynamic.programming.geeksforgeeks;

import java.util.Scanner;

public class MaxSubsequence {
    public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for ( int i = 0 ; i < N ; i++)
            arr[i] = sc.nextInt();

        System.out.println(findMaximumSumSubsequence(arr));
    }

    private static int findMaximumSumSubsequence(int[] arr) {
        int dp[] = new int[arr.length+1];
        dp[0] = 0;
        int max = dp[1] = arr[0];
        for ( int i = 2 ; i <= arr.length ; i++)    {
            dp[i] = arr[i-1];
            for ( int j = 1 ; j < i ; j++)  {
                if ( arr[i-1] > arr[j-1] )    {
                    dp[i] = Math.max(dp[i] , arr[i-1] + dp[j]);
                    max = Math.max(max , dp[i]);
                }
            }
        }
        return max;
    }
}
