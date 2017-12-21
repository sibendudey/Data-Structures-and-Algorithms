package dynamic.programming.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class EqualChocolates {
//    public static void main(String args[])  {
//        Scanner scanner = new Scanner(System.in);
//        int noOfTestCases = scanner.nextInt();
//        for ( int i = 0 ; i < noOfTestCases ; i++)    {
//            int arrLength = scanner.nextInt();
//            int arr[] = new int[arrLength];
//            for ( int j = 0 ; j < arrLength ; j++)  {
//                arr[j] = scanner.nextInt();
//            }
//            System.out.println(minimumOperations(arr));
//        }
//    }
//
//    private static int minimumOperations(int[] arr) {
//        if ( checkEqual(arr))
//            return 0;
//
//        return  minimumOperationsHelper(arr, arr.length - 1);
//
//    }
//
//    private static int minimumOperationsHelper(int arr[] , int indexChooser) {
//        if (indexChooser == -1)
//            return Integer.MAX_VALUE;
//
//        if (checkEqual(arr))
//            return 0;
//
//        int notChoosed = minimumOperationsHelper(arr, indexChooser - 1);
//        int choosed2 = minimumOperationsHelper(subtractFromAllElementsExceptChoosed(arr , 2, indexChooser) , indexChooser);
//        int choosed3 = minimumOperationsHelper(subtractFromAllElementsExceptChoosed(arr, 3, indexChooser) , indexChooser);
//        int choosed5 = minimumOperationsHelper(subtractFromAllElementsExceptChoosed(arr, 5, indexChooser) , indexChooser);
//
//        return Math.min
//    }
//
//    private static int[] subtractFromAllElementsExceptChoosed(int[] arr, int additionValue, int indexChooser) {
//        int[] arrCopy = Arrays.copyOf(arr , arr.length);
//        for ( int i = 0 ; i < arrCopy.length ; i++) {
//            if ( i != indexChooser)
//                arrCopy[i] += additionValue;
//        }
//        return arrCopy;
//    }
//
//    private static boolean checkEqual(int[] arr) {
//        int element = arr[0];
//        for ( int i = 1 ; i < arr.length ; i++) {
//            if ( arr[i] != element )
//                return false;
//        }
//        return true;
//    }
}
