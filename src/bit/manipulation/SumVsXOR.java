package bit.manipulation;

import java.util.Scanner;

public class SumVsXOR {
    static long solve(long n) {
        int noOfOneBits = Long.bitCount(n);
        int noOfLeadingZeroBits = Long.numberOfLeadingZeros(n);
        int noOfZeroBits = (64 - noOfLeadingZeroBits) - noOfOneBits;
        return (long)Math.pow(2, noOfZeroBits);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long result = solve(n);
        System.out.println(result);
    }

}
