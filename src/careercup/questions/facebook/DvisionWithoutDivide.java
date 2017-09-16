package careercup.questions.facebook;

import java.util.Scanner;

/**
 * Created by Sibendu on 6/14/2017.
 * Question Link : https://www.careercup.com/question?id=5670692394631168
 *
 * Start iterating from i =  1 until value * divisor becomes greater than divident.
 * Return quotient
 */
public class DvisionWithoutDivide {

    public static void main( String args[]) {

        Scanner sc =  new Scanner(System.in);

        int dividend = sc.nextInt();
        int divisor = sc.nextInt();

        int quotient = findQuotient(dividend , divisor);

        System.out.println(quotient);
    }

    private static int findQuotient(int dividend, int divisor) {

        int quotient = 1;
       for ( int i = 1 ;  ; i++)  {
           if ( i* divisor > dividend)
               return quotient;
           else
               quotient = i;
       }
    }

}
