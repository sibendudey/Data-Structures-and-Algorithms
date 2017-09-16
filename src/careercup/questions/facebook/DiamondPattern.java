package careercup.questions.facebook;

import java.util.Scanner;

/**
 * Created by sibendu on 25/5/17.
 */
public class DiamondPattern {
    public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);
        int odd = sc.nextInt();
        StringBuilder sb = new StringBuilder("*");
        int i = 1;
        int space = odd / 2 + 1;
        String formatter = null;
        for (  ; i <= odd ; i+=2, space++ )  {
            formatter = "%" + space + "s\n";
            System.out.printf(formatter , sb.toString());
            sb.append("*").append("*");

        }
        sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1);
        for ( i = i - 4, space = space - 2 ; i >= 0 ; i = i - 2 , space--) {
            formatter = "%" + space + "s\n";
            sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1);
            System.out.printf(formatter , sb.toString());
        }




    }
}
