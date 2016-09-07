package dynamic.programming;

import java.util.Scanner;

public class NumberOfSubsequences {

	public static void main(String[] args) {
		// TODO Auto-gene7rated method stub
		Scanner in = new Scanner(System.in);
		int arraySize = in.nextInt();
		int arr[] = new int[arraySize];
		for ( int i = 0 ;  i < arraySize ; i++){
			arr[i] = in.nextInt();
		}
		printLongest(arr);
		in.close();

	}

//1,2,3,10  1 2 3 10   1,2  1,3   2 3 10
	
	private static void printLongest(int[] arr) {
		// TODO Auto-generated method stub
		Integer.va
		int length = arr.length;
		int numberOfSubsequences[][] = new int[length][length+1];
		for ( int i = 0 ; i < length ; i++){
				numberOfSubsequences[i][0]  = 0;
					numberOfSubsequences[i][1] = 1;
		}
		for ( int k = 2 ; k < arr.length + 1 ; k++)	{
		for ( int i = 1 ;  i < arr.length ; i++)	{
			for ( int j = 0 ;  j < i ; j++)	{
				if ( arr[j] <= arr[i] )	{
					if ( k == 2 && gcd(arr[j] , arr[i]) == 1 ){
						numberOfSubsequences[i][k]++;
					}
					else	{
						numberOfSubsequences[i][k] += numberOfSubsequences[j][k-1];
					}
				}
			}
		}
		}
		 
		int totalSum = 0;
		for ( int i = 0 ; i < length ;  i++)	{
			for ( int j = 1 ; j < length+1 ; j++)	{
				if ( j == 1 && arr[i] != 1)
					continue;
			else
				totalSum += numberOfSubsequences[i][j]; 	
		}
		}
		
		System.out.println(totalSum );
	}
	
	static int gcd(int m,int n)
	{
	if(n==0)
	return m;
	else if(n>m)
	return gcd(n,m);
	else
	return gcd(n,m%n);
	}

}
