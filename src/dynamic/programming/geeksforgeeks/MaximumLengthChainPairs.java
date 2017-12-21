package dynamic.programming.geeksforgeeks;

import java.util.Map;
import java.util.Scanner;

public class MaximumLengthChainPairs {
    static class Pair   {
        int a; int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String args[])  {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Pair[] pairs = new Pair[N];
        for ( int i = 0 ; i < N ; i++)  {
            pairs[i] = new Pair(scanner.nextInt() , scanner.nextInt());
        }


        System.out.println(maxLength(pairs));
    }

    private static int maxLength(Pair[] pairs) {
        int dp[] = new int[pairs.length + 1];
        int max = 1;
        dp[0] = 0;
        for ( int i = 1 ; i <= pairs.length ; i++)
            dp[i] = 1;

        for ( int i = 2 ; i <= pairs.length ; i++)  {
            for ( int j = 1 ; j < i ; j++)  {
                if ( pairs[i-1].a >= pairs[j-1].b)  {
                    dp[i] = Math.max(dp[i] , 1 + dp[j]);
                    max = Math.max(max , dp[i]);
                }
            }
        }

        return max;
    }
}
