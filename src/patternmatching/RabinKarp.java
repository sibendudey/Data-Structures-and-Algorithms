package patternmatching;

import java.util.Scanner;

/**
 * Created by Sibendu on 6/29/2017.
 */
public class RabinKarp {

    public static void main(String args[])  {

        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        String pattern = sc.next();
        
        executeRabinKarpAlgorithm( text , pattern);

    }

    private static void executeRabinKarpAlgorithm(String text, String pattern) {
        final int D = 256;
        final int PRIMENUMBER = 101;

        final int patternLength = pattern.length();
        final int textLength = text.length();

        int patternHashValue = 0;
        int textHashValue = 0;

        int H = 1;

        for ( int i = 0 ; i < patternLength - 1 ; i++)  {
            H = (H*D)%PRIMENUMBER;
        }

        // calculate initial hash values

        for ( int i = 0 ; i < patternLength ; i++)  {
            patternHashValue = ( D * patternHashValue  + pattern.charAt(i))%PRIMENUMBER;
            textHashValue = ( D * textHashValue + pattern.charAt(i))%PRIMENUMBER;
        }

        for (  int i = 0 ; i <= textLength - patternLength ; i++)   {
            if ( patternHashValue == textHashValue )    {
                for ( int j = 0 ; j < patternLength ; j++)  {
                    if ( text.charAt(i + j) != pattern.charAt(j))
                        break;

                    if ( j == patternLength - 1)    {
                        System.out.println("Pattern found at " + i + " position");
                    }
                }
            }

            if ( i < textLength - patternLength)    {
                textHashValue = ( D * ( textHashValue - text.charAt(i) * H) + text.charAt(i + patternLength)) %  PRIMENUMBER;

                if ( textHashValue < 0 )
                    textHashValue = textHashValue + PRIMENUMBER;
            }
        }
    }
}
