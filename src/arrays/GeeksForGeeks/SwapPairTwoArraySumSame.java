//package arrays.GeeksForGeeks;
//
//import java.util.Arrays;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
//
///**
// * Question link :> http://www.geeksforgeeks.org/find-a-pair-swapping-which-makes-sum-of-two-arrays-same/
// *
// * The idea has been presented in the link web page given above.
// *
// */
//public class SwapPairTwoArraySumSame {
//    public static void main(String args[])  {
//        /*int arr[] = new int[ ]{23, 17, 45, 56,10 };
//        int arr2[] = new int[] { 13, 35 , 56 , 35, 22 };
//
//        findPair( arr , arr2);*/
//        Calendar cl = new GregorianCalendar(1900, 1, 1);
//        System.out.print(Math.abs(cl.getTimeInMillis()) + new GregorianCalendar());
//
//    }
//
//    private static void findPair(int[] arr, int[] arr2) {
//        Arrays.sort(arr);
//        Arrays.sort(arr2);
//        int difference = findTarget( arr , arr2);
//
//        if ( difference == 0) {
//            System.out.print("Pair not possible. Difference is zero");
//            return;
//        }
//
//        int a = 0, b = 0;
//
//        for (  int i = 0, j = 0 ; i < arr.length && j < arr2.length ; ) {
//            a = arr[i];
//            b = arr2[j];
//
//            if ( a - b == difference)   {
//                System.out.println("a: " + a + ", b:" + b );
//                return;
//            }
//            else if ( a - b < difference)   {
//                i++;
//            }
//            else
//                j++;
//        }
//
//
//
//
//    }
//
//    private static int findTarget(int[] arr, int[] arr2) {
//        int sum1 = getSum(arr);
//        int sum2 = getSum(arr2);
//
//        if ( (sum1 - sum2) % 2 != 0)
//            return 0;
//
//        return (sum1 - sum2)/2;
//    }
//
//    private static int getSum(int[] arr) {
//        int sum = 0;
//        for ( int element : arr)    {
//            sum += element;
//        }
//
//        return sum;
//    }
//}
