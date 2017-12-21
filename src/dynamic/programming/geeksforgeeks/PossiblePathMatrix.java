package dynamic.programming.geeksforgeeks;

import java.util.Scanner;

public class PossiblePathMatrix {
    public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(numberOfPaths(m,n));
    }

    private static int numberOfPaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        dp[0][0] = 1;
        for ( int i = 1 ; i <= m ; i++)
            dp[i][1] = 1;

        for ( int i = 1 ; i <= n ; i++)
            dp[1][i] = 1;

        for ( int i = 2 ; i <= m ; i++) {
            for ( int j = 2 ; j <= n ; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[m][n];
    }
}
