package dynamic.programming.hackerrank;

import java.util.Scanner;

public class Abbreviation {
    /*static String abbreviation(String a, String b) {

        if ( a.length() < b.length())
            return "NO";
        int i = 0, j = 0;
        for (  ; i < a.length() && j < b.length() ;)  {
            System.out.println("Matching character " + a.charAt(i) + " " + b.charAt(j));
            if ( a.charAt(i) == b.charAt(j)) {
                i++;j++;
            }

            else if ( a.charAt(i) == b.charAt(j) + 32)   {
                i++;j++;
            }

            else if (a.charAt(i) != b.charAt(j) && a.charAt(i) >= 97  && a.charAt(i) <= 122)
            {
                i++;
            }
            else
                return "NO";
        }

        if ( j < b.length())
            return "NO";

        while ( i < a.length()) {
            if ( a.charAt(i) >= 65 && a.charAt(i) <= 90)
                return "NO";

            i++;
        }

        return "YES";
    }*/

    static String abbreviation(String a, String b) {

        boolean dp[][] = new boolean[a.length() + 1][b.length() + 1];

        dp[0][0] = true;

        for ( int i = 0; i < a.length() ; i++) {
            for ( int j = 0 ; j <= b.length() ; j++)    {
                if ( dp[i][j])  {
                    if ( j < b.length() && a.charAt(i) == b.charAt(j) && Character.isUpperCase(b.charAt(j)))
                        dp[i+1][j+1] = true;
                    else if ( j < b.length() && a.charAt(i) == b.charAt(j) + 32 )
                        dp[i+1][j+1] = true;
                    else if ( Character.isLowerCase(a.charAt(i)))    {
                        dp[i+1][j] = true;
                    }
                }
            }
        }

        if ( dp[a.length()][b.length()])
            return "YES";
        else
            return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String a = in.next();
            String b = in.next();
            String result = abbreviation(a, b);
            System.out.println(result);
        }
        in.close();
    }
}
