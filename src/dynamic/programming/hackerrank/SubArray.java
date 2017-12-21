package dynamic.programming.hackerrank;

import java.util.Map;
import java.util.Scanner;

public class SubArray {
    public static void main(String args[]) {
        //System.out.println(findLength(new int[]{1, 2, 3, 2, 1, 1, 2, 3, 4}, new int[]{3, 2, 1, 2, 3, 4, 4, 7}));
        System.out.println(minPathSum(new int[][] { { 1,3,1} , { 1,5,1} , {4,2,1}}));
    }

    public static int minPathSum(int [][] grid)    {
        int dp[][] = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for ( int i = 0 ; i < grid.length ; i++)    {
            for ( int j = 0 ; j < grid[0].length ; j++) {
                if ( i == 0 && j != 0)
                    dp[i][j] = grid[i][j] + dp[i][j-1];

                else if ( j == 0 && i != 0)
                    dp[i][j] = grid[i][j] + dp[i-1][j];

                else if ( i != 0 && j != 0 )
                    dp[i][j] = grid[i][j] + Math.min( dp[i-1][j] , dp[i][j-1]);
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }

    private static int findLength(int[] A, int[] B) {
        int dp[][] = new int[A.length + 1][B.length + 1];

        for (int i = 0; i <= A.length; i++)
            dp[i][0] = 0;

        for (int i = 0; i <= B.length; i++)
            dp[0][i] = 0;


        int max = 0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++)
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (max < dp[i][j])
                        max = dp[i][j];
                }
        }

        return max;

    }
}
