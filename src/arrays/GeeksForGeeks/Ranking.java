package arrays.GeeksForGeeks;

import java.util.Arrays;
import java.util.*;

public class Ranking {
    public static void main(String args[])  {
        int arr1[] = new int[]{10,12,15,12,10,25,12};
        ranking(arr1);
        int arr2[] = new int[]{20,30,10};
        ranking(arr2);
    }

    private static void ranking(int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr, arr.length);

        Arrays.sort(arrCopy);
        Map<Integer, Double> map = new HashMap<>();
        double count = 1D;
        double indexSum = 1;
        for ( int i = 1 ; i < arrCopy.length ; i++) {
            if ( arrCopy[i-1] == arrCopy[i])    {
                count++;
                indexSum += (i+1);
            }
            else{
                double rank = indexSum / count;
                map.put(arrCopy[i-1], rank);
                count = 1;
                indexSum = i + 1;
            }
        }

        map.put(arrCopy[arrCopy.length - 1],indexSum / count);
        Arrays.stream(arr).forEach( e -> System.out.println(map.get(e)));
    }
}
