package bit.manipulation;

import java.util.Scanner;

public class SansaANDXor {
    static int sansaXor(int[] arr) {
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int result = sansaXor(arr);
            System.out.println(result);
        }
        in.close();
    }

}
