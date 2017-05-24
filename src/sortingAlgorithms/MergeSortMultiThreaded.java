package sortingAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Sibendu Dey on 5/23/2017.
 */

public class MergeSortMultiThreaded {

    public static void main(String args[])   {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for ( int i = 0 ; i < N ; i++)
            arr[i] = sc.nextInt();

        Thread t = new Thread(() -> {mergeSort(arr, 0 , N - 1);});
        t.start();
        try {
            t.join();
            Arrays.stream(arr).forEach( (i) -> System.out.print(i + " "));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void mergeSort(int[] arr, int i, int j) {

        if ( i < j ) {
            int k = (i + j) / 2;
            Thread t1 = new Thread(() -> {mergeSort(arr , i , k);});
            Thread t2 = new Thread(() -> {mergeSort(arr, k + 1, j);});
            t1.start();
            t2.start();
            try {
                t1.join();
                t2.join();
                merge(arr, i, k, j);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private static void merge(int[] arr, int i, int k, int j) {
        int N1 = k - i + 1;
        int N2 = j - k;
        int arr1[] = new int[N1];
        int arr2[] = new int[N2];

        for ( int i1 = 0 ; i1 < N1; i1++)    {
            arr1[i1] = arr[i + i1];
        }

        for ( int i2 = 0 ; i2 < N2; i2++)   {
            arr2[i2] = arr[i2 + k + 1];
        }

        int i1 = 0, i2 = 0;
        while ( i1 < N1 && i2 < N2)   {
            if ( arr1[i1] < arr2[i2] )  {
                arr[i] = arr1[i1];
                i++;
                i1++;
            }
            else    {
                arr[i] = arr2[i2];
                i2++;
                i++;
            }
        }
        while ( i1 < N1) {
            arr[i] = arr1[i1];
            i1++;
            i++;
        }
        while ( i2 < N2) {
            arr[i] = arr2[i2];
            i2++;
            i++;
        }
    }
}
