package binary.search;

import java.util.Arrays;
import java.util.Stack;

public class SmallestLetterGreater {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;
        int mid;

        while (true) {
            mid = ( low + high) / 2;
            if ( letters[mid] == target && letters[(mid + 1) % letters.length] != target)    {
                break;
            }
            if ( letters[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return letters[(mid + 1) % letters.length];
    }

    public static void main(String args[])  {
        //System.out.println(new SmallestLetterGreater().nextGreatestLetter(new char[]{'c', 'f', 'j'}));
        System.out.println( 2.1D == 2);
    }

    public int arrangeCoins(int n) {
        return  (int)(-1 + Math.sqrt(1 + (long)8 * n)) / 2;
    }

    public long firstBadVersion(int n) {
        long low = 1;
        long high = n;

        while ( low <= high)    {
            long mid = ( (long)low + high) / 2;

            boolean firstMid = true;
            if ( firstMid )
                high = mid - 1;
            else
                low = mid + 1;

        }

        return low;
    }

    public void test(String input)    {
        for ( int i = 0 ; i < input.length() ; i++) {
            Character curr = input.charAt(i);
            Stack<Character> stack = new Stack<>();
        }
    }

}
