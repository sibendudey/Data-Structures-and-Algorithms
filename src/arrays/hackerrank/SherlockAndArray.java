package arrays.hackerrank;

import java.util.Scanner;

public class SherlockAndArray {
    static String solve(int[] a){
        long leftSum[] = new long[a.length];
        long rightSum[] = new long[a.length];

        leftSum[0] = 0;
        for ( int i = 1 ; i < a.length ; i++)
            leftSum[i] = leftSum[i-1] + a[i-1];

        rightSum[a.length - 1] = 0;
        for ( int i = a.length - 2 ; i >= 0 ; i--)
            rightSum[i] = rightSum[i+1] + a[i+1];

        for ( int i = 0 ; i < a.length  ;i++)
            if ( leftSum[i] == rightSum[i])
                return "YES";

        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            String result = solve(a);
            System.out.println(result);
        }
    }
}
