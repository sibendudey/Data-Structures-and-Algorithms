package hashmaps.careercup.amazon;
import java.util.Scanner;

/**
 * Created by Sibendu Dey on 5/9/2017.
 */
public class FindRepeatingElements {

    public static void main(String args[])  {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for ( int i = 0 ; i < N; i++)   {
            arr[i] = sc.nextInt();
        }

        findDuplicates(arr);
    }

    private static void findDuplicates(int[] arr) {
        for ( int i = 0 ; i < arr.length ; i++) {
            int index = arr[i]% arr.length;
            arr[index] += arr.length;
        }

        for ( int i = 0 ; i < arr.length ; i++) {
            if ( arr[i]/ arr.length > 1)   {
                System.out.print(i + " ");
            }
        }
    }

    private static void swap(int i, int j, int[] arr) {

    }
}
