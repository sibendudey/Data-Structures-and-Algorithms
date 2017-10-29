package dynamic.programming.geeksforgeeks;

import java.util.Scanner;

/**
 * This program solves subset sum problem. For a given sum, find whether the sum of any subset
 * is equivalent to the given sum
 *
 * Question link : http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
 */

public class SubsetSum {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int arr[] = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            arr[i] = scanner.nextInt();
        }

        int sum = scanner.nextInt();
        System.out.println(isSubsetEqualToSum(arr, sum));
    }

    private static boolean isSubsetEqualToSum(int[] arr, int sum) {
        int dp[][] = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i][i] = arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                dp[i][j] = dp[i][j - 1] + arr[j];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (dp[i][j] == sum) ;
                return true;
            }
        }

        return false;
    }
}