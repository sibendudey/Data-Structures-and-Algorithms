package dynamic.programming.geeksforgeeks;

import java.util.Scanner;

public class LCSubStr {
    public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(findMaxLength(str1 , str2));
    }

    private static int findMaxLength(String str1, String str2) {
        int [][] dp = new int[ str1.length() + 1][str2.length() + 1];
        dp[0][0] = 0;
        int max = 0;
        for ( int i = 1 ; i <= str1.length() ; i++)  {
            dp[i][0] = 0;
        }

        for ( int i = 1 ; i <= str2.length() ; i++)  {
            dp[0][i] = 0;
        }

        for ( int i = 1 ; i <= str1.length() ; i++) {
            for ( int j = 1 ; j <= str2.length() ; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1))   {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(max , dp[i][j]);
                }
                else
                    dp[i][j] = 0;
            }
        }

        return max;
    }
}
