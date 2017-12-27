package arrays.hackerrank;

import org.omg.CORBA.MARSHAL;

import java.util.Scanner;

public class MaxSubarraySum {
    static long maximumSum(long[] a, long m) {
        long subArraySum[] = new long[a.length];
        long max = Long.MIN_VALUE;

        subArraySum[0] = a[0];
        for ( int i = 1 ; i < a.length ; i++)
            subArraySum[i] = subArraySum[i-1] + a[i];

        for ( int i = 0 ; i < a.length ; i++)   {
            for ( int j = 0 ; j < a.length ; j++)   {
                max = Math.max((subArraySum[j] - subArraySum[i] + a[i]) % m , max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            long m = in.nextLong();
            long[] a = new long[n];
            for (int a_i = 0; a_i < n; a_i++) {
                a[a_i] = in.nextLong();
            }
            long result = maximumSum(a, m);
            System.out.println(result);
        }
        in.close();
    }
}
