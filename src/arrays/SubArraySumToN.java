package arrays;

import java.util.Scanner;

/**
 * Created by Sibendu Dey on 4/24/2017.
 *
 * This problem serves as a solution for
 * https://www.careercup.com/question?id=5642303617105920
 */
public class SubArraySumToN {

    public static void main(String args[])   {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];

        for ( int i = 0 ; i < arr.length ; i++)
            arr[i] = sc.nextInt();

        subArraySum(arr);
    }

    private static void subArraySum(int[] arr) {

        if ( allNegativeIntegers(arr))  {
            findMinKadaneAlgo(arr);
        }
        else
            executeKadaneAlgo(arr);

    }

    private static void executeKadaneAlgo(int[] arr) {
        int curr_max = 0;
        int max = 0;

        int max_low = 0;
        int max_high = 0;

        int current_min_low = 0;

        for ( int i = 0 ; i < arr.length ; i++) {
            curr_max = curr_max + arr[i];
            if ( curr_max <= 0)  {
                curr_max = 0;
                current_min_low = i+1;
            }
            else    {
                if ( curr_max > max && current_min_low != i)    {
                    max = curr_max;
                    max_low = current_min_low;
                    max_high = i;
                }
            }
        }

        System.out.println("Range of maximum sum subarray is [ " + max_low + " , " + max_high +"]");
    }

    private static void findMinKadaneAlgo(int[] arr) {
        int startingIndex = 0;
        int currSum = arr[0] + arr[1];
        int maxSum = currSum;
        int minLowIndex = 0;
        int minHighIndex = 1;

        for ( int currIndex = 2; currIndex < arr.length ; currIndex++)  {
            currSum = currSum + arr[currIndex];
            if ( currSum > maxSum && startingIndex != currIndex ) {
                minLowIndex = startingIndex;
                minHighIndex = currIndex;
            }
            else    {
               // while( currSum)
            }

        }

        System.out.println("starting index: " + minLowIndex + "Ending Index: " + minHighIndex);
    }

    private static boolean allNegativeIntegers(int[] arr) {
        for ( int i = 0 ; i < arr.length ; i++) {
            if ( arr[i] > 0)
                return false;
        }
        return true;
    }
}
