package dynamic.programming.geeksforgeeks;


import java.util.Scanner;

/***
 * This contains the solution for
 * http://www.geeksforgeeks.org/count-number-ways-reach-given-score-game/
 */
public class CountWays {
    public static void main(String args[])  {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(totalScore(N));
    }

    private static int totalScore(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[3] = 1;
        dp[6] = 2;
        dp[5] = 1;
        dp[10] = 1;
        for ( int i = 11 ; i <=n ; i++) {
            dp[i] = dp[i - 3] + dp [ i - 5] + dp[ i - 10];
        }

        return 0;
    }
}
