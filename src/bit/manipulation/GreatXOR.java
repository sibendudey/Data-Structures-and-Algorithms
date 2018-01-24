package bit.manipulation;

import java.util.Scanner;

public class GreatXOR {

    static long theGreatXor(long x){
        long result = 0;
        int noOfOneBits = Long.bitCount(x);
        int noOfLeftBits = 0;
        while( x != 0)  {
            if ((x & (1L)) == 0)    {
                result = result + (long) Math.pow(2, noOfLeftBits);
            }
            noOfLeftBits++;
            x = x >> 1;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long x = in.nextLong();
            long result = theGreatXor(x);
            System.out.println(result);
        }
    }

}
