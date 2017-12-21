package dynamic.programming.hackerrank;

import java.util.Scanner;

public class SubstringCandies {
    public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        System.out.println(maxCandies(line));
    }

    /*private static int maxCandies(String line) {
        int dp[][] = new int[line.length() + 1][line.length() + 1];
        int sum = 0;
        dp[0][0] = 0;
        for ( int i = 1 ; i <= line.length() ; i++) {
            sum +=  (dp[i][1] = Character.getNumericValue(line.charAt(i-1)) % (int)Math.pow(10 , 9)) ;
        }
        for ( int i = 1 ; i<= line.length() ; i++)  {
            for ( int j = 2; i + j <= (line.length() + 1) ; j++)    {
                sum += (dp[i][j] = (10 * dp[i][j-1] + Character.getNumericValue(line.charAt( i + j - 2))) % (int)Math.pow(10, 9));
            }
        }
        return sum;
    }*/
    private static int maxCandies(String line)  {

        final int modulo = (int)Math.pow(10 , 9);
        int sum = 0;
        for ( int i = 0 ; i < line.length() ; i++)  {
            int tempSum = 0;
            for ( int j = i ;  j < line.length() ; j++) {
                tempSum = ( (10 * tempSum)  +  Character.getNumericValue(line.charAt( j))) % modulo;
                sum = ( sum + tempSum) % modulo;
            }

        }
        return  sum;
    }
}
