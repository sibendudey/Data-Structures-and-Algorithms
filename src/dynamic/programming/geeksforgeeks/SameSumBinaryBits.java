package dynamic.programming.geeksforgeeks;

import java.util.Scanner;

/**
 * The solution has been copied from geeksforgeeks.org
 * http://www.geeksforgeeks.org/count-even-length-binary-sequences-with-same-sum-of-first-and-second-half-bits/
 */

public class SameSumBinaryBits {
    public static void main(String args[])  {
        int N = new Scanner(System.in).nextInt();
        System.out.println(geeksforgeeksSolution(N));
    }

    private static int geeksforgeeksSolution(int n) {
        int nCr=1, res = 1;

        // Calculate SUM ((nCr)^2)
        for (int r = 1; r<=n ; r++)
        {
            // Compute nCr using nC(r-1)
            // nCr/nC(r-1) = (n+1-r)/r;
            nCr = (nCr * (n+1-r))/r;

            res += nCr*nCr;
        }

        return res;
    }
}
