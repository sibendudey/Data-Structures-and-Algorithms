package strings.geeksforgeeks;

import java.util.Map;
import java.util.Scanner;

/**
 * Created by Sibendu Dey on 7/31/2017.
 * This problem is based on the idea of Sliding window conversion
 * Hyperlink: http://www.geeksforgeeks.org/convert-substrings-length-k-base-b-decimal/
 *
 */
public class BaseConversion {

    public static void main( String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int base = sc.nextInt();
        int length = sc.nextInt();
        performBaseConversion( str , base , length);
    }

    private static void performBaseConversion(String str, int base, int length) {

        int initialNumber = 0;
        for ( int i = 0 ; i < length ; i++)   {
            initialNumber += (str.charAt(i) - '0') * Math.pow(base , length - i - 1);
        }

        System.out.println(initialNumber);
        int prev = initialNumber;
        for ( int i = length ; i < str.length() ; i++)  {
            prev = prev - ((str.charAt(i - length) - '0') * (int)Math.pow(base , length - 1));
            prev = prev * base;
            prev += (str.charAt(i) - '0');

            System.out.println(prev);
        }
    }
}
