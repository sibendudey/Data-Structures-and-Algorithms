package arrays.GeeksForGeeks;

import java.util.Scanner;

public class ProductArray {
    static final double EPS = 0.000000001;

    public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        for ( int i = 0 ; i < testCases ; i++) {
            int N = sc.nextInt();
            int arr[] = new int[N];

            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
            }

            int prod[] = findProd(arr);

            for ( int k = 0 ; k < prod.length ; k++)    {
                System.out.print(prod[k] + " ");
            }


        }

    }

    private static int[] findProd(int[] arr) {
        int leftProd[] = new int[arr.length];
        int rightProd[] = new int[arr.length];
        int prod[] = new int[arr.length];

        leftProd[0] = 1;
        rightProd[arr.length - 1] = 1;

        for ( int i = 1 ; i < arr.length ; i++) {
            leftProd[i] = leftProd[i-1] * arr[i-1];
            rightProd[arr.length - i - 1] = rightProd[arr.length - i] * arr[arr.length - i];
        }

        for ( int i = 0 ; i < arr.length ; i++) {
            prod[i] = leftProd[i] * rightProd[i];
        }

        return prod;
    }
}
