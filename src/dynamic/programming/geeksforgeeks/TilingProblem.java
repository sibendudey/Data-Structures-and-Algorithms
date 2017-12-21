package dynamic.programming.geeksforgeeks;

import java.util.Scanner;

public class TilingProblem {
    public static void main(String args[])  {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(tilings(N));
    }

    private static int tilings(int N) {
        int dp[] = new int[N+1];
        // dp[i[j] represents the solution for total number of ways in which floor
        // of size 2*i can be solved.
        dp[1] = 1;
        dp[2] = 2;

        for ( int i = 3 ; i <= N ; i++)
            dp[i] = dp[i-1] + dp[i-2];

        return dp[N];
    }
}