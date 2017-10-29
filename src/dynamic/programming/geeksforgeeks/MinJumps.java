package dynamic.programming.geeksforgeeks;

import java.util.Scanner;

public class MinJumps {
    public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for ( int i = 0 ; i < N ; i++)  {
            arr[i] = sc.nextInt();
        }
        System.out.println(minJumps(arr));
    }

    private static int minJumps(int[] arr) {
        int dp[] = new int[arr.length];
        dp[0] = 0;
        for ( int i = 1 ; i < dp.length ; i++)
            dp[i] = Integer.MAX_VALUE;

        for ( int i = 1 ; i < arr.length ; i++) {
            for ( int j = 0 ; j < i ; j++)  {
                if ( (i - j) <= arr[j]) {
                    dp[i] = Math.min(dp[i] , dp[j] + 1);
                }
            }
        }
        return dp[dp.length - 1];
    }
}
