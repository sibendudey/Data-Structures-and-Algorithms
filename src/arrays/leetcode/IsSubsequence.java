package arrays.leetcode;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        for ( int i=0, j = 0 ; j < s.length() && i < t.length() ; i++) {
            if ( s.charAt(j) == t.charAt(i))   {
                j++;
            }

            if ( j == s.length())
                return true;
        }

        return false;
    }

    public static void main(String args[])  {
        String s = "abc";
        String t = "ahbgdc";

        System.out.println(new IsSubsequence().isSubsequence(s, t));

        s = "axc";
        t = "ahbgdc";

        System.out.println(new IsSubsequence().isSubsequence(s, t));
    }
}
