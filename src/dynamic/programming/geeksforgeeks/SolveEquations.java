package dynamic.programming.geeksforgeeks;

import java.util.Scanner;

public class SolveEquations {
    public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);
        int rhs = sc.nextInt();
        int noOfCoefficients = sc.nextInt();
        int arr[] = new int[noOfCoefficients];
        for ( int i = 0 ; i < noOfCoefficients ; i++)
            arr[i] = sc.nextInt();
        System.out.println(findSolutions(rhs, arr));
    }

    private static int findSolutions(int rhs , int arr[]) {
        if (rhs == 0)
            return 1;

        if (rhs < 0)
            return 0;

        int noOfSolutions = 0;

        for ( int i = 0 ; i < arr.length ; i++) {
            noOfSolutions += findSolutions(rhs - arr[i] , arr);
        }

        return noOfSolutions;
    }
}
