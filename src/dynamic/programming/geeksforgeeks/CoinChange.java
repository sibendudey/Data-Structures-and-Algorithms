package dynamic.programming.geeksforgeeks;

import java.util.Scanner;

/***
 * Coin change problem gives me Headache!!!!
 * This code will try(I mean it!!!! :P) to solve the coin change problem.
 *
 */
public class CoinChange {
    public static void main(String args[])  {
        Scanner scanner = new Scanner(System.in);
        int coinsNumber = scanner.nextInt();
        int coins[] = new int[coinsNumber];
        for ( int i = 0 ; i < coinsNumber ; i++)    {
            coins[i] = scanner.nextInt();
        }
        int N = scanner.nextInt();
        System.out.println(coinChangeWays(N , coins));
    }

    private static int coinChangeWays(int N, int[] coins) {
        int dp[][] = new int[N+1][coins.length + 1];

        // dp[i][j] will represent the number of ways where "i" value can be
        // changed using coins[k] where k belongs to [1, j]
        // dp[i][0] will be 1. To handle the base case scenario
        for ( int i = 1 ; i <= coins.length ; i++) {
            dp[0][i] = 1;
        }

        for ( int i = 1 ; i <= N ; i++) {
            for ( int j = 1 ; j <= coins.length ; j++)  {
                int x = ( i >= coins[j-1]) ? dp[i - coins[j-1]][j] : 0;
                int y = dp[i][j-1];
                dp[i][j] = x + y;
            }
        }

        return dp[N][coins.length];
    }
}
