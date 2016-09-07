package arrays;

import java.util.Scanner;

public class LittleShino {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int K = in.nextInt();
		String input = in.next();
		int arr[] = new int[26];
		findOutput(K , input , arr);
	}

	private static void findOutput(int k, String input, int[] arr) {
		// TODO Auto-generated method stub
		int noOfPairs = 0;
		int stringLength = input.length();
		for ( int i = 0 ; i < stringLength - k ;  i++)	{
			arr = new int[26];
			int KCount = 1;
			Character temp = input.charAt(i);
			arr[temp-97]++;
			for ( int j = i+1 ; j < stringLength ; j++)	{
				temp = input.charAt(j);
				if (arr[temp-97] == 0)	{
					KCount++;
					arr[temp-97]++;
				}
				if (KCount > k)
					break;
				
				if (KCount == k)
					noOfPairs++;
			}
		}
		
		System.out.println(noOfPairs);
	}

}
