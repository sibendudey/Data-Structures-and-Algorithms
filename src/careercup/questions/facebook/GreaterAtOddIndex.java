package careercup.questions.facebook;

import java.util.Scanner;

/**
 * Created by Sibendu Dey on 5/22/2017.
 *
 * Question -> https://www.careercup.com/question?id=5069947735638016
 */
public class GreaterAtOddIndex {

    public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in array");
        int N = sc.nextInt();
        int arr[] = new int[N];
        for ( int i = 0 ; i < N ; i++)  {
            arr[i] = sc.nextInt();
        }

        performOperation(arr);

        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for ( int i = 0 ; i < arr.length ; i++)
            System.out.print(arr[i] + " ");

    }

    private static void performOperation(int[] arr) {
        for ( int i = 0 ; i < arr.length - 1 ; i++ ) {
            if ( arr[i] > arr[i+1])
                swap( arr , i , i+1);
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
