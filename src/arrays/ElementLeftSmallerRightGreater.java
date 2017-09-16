package arrays;


import java.util.Scanner;

/***
 * The purpose of the program is to find an element in an unsorted array
 * whose left elements are smaller to it and right elements are greater than it.
 * Asked in Intuit
 */
public class ElementLeftSmallerRightGreater {
    public static void main(String args[])  {

        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        for ( int i = 0 ; i < testCases ; i++) {
            int N = sc.nextInt();
            int arr[] = new int[N];

            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
            }

            int value = findElement(arr);
            System.out.println(value == -1 ? -1 : arr[value]);
        }
    }

    private static int findElement(int[] arr) {
        boolean leftSmaller[] = new boolean[arr.length];
        boolean rightGreater[] = new boolean[arr.length];

        // First traverse from left to right

        int greatestElementFromLeftToRight = arr[0];

        for ( int i = 1 ; i < arr.length ; i++) {
            if ( arr[i] >= greatestElementFromLeftToRight) {
                leftSmaller[i] = true;
                greatestElementFromLeftToRight = arr[i];
            }
        }

        int smallestElementFromRightToLeft = arr[arr.length - 1];

        for ( int i = arr.length - 2 ; i >= 0 ; i--)    {
            if ( arr[i] <= smallestElementFromRightToLeft)   {
                rightGreater[i] = true;
                smallestElementFromRightToLeft = arr[i];
            }
        }

        for ( int i = 0 ; i < arr.length ; i++)
            if ( (leftSmaller[i] == true) && (rightGreater[i] == true ))
                return i;

        return -1;
    }
}
