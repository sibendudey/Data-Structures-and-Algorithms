package strings;

import java.util.Scanner;

public class Anagram {
	
	public static void main(String args[])	{
		
		Scanner in = new Scanner(System.in);
		int noOfInputs = in.nextInt();
		for ( int i = 0 ; i < noOfInputs ; i++){
			String input = in.next();
			findNoOfChanges(input);
					
		}
	}

	private static void findNoOfChanges(String input) {
		// TODO Auto-generated method stub
		if (input.length() % 2 == 1)	{
			System.out.println("-1");
			return;
		}
		
		int count[] = new int[26];
		for ( int i = 0 ; i < input.length()/2 ; i++)	{
			++count[input.charAt(i) - 'a']; 
		}
		
		for ( int i = input.length()/2 ; i < input.length() ; i++){
			--count[input.charAt(i) - 'a'];
		}
		
		int maxDiff = 0 ;

		for ( int i = 0; i < 26 ; i++)	{
			//if (maxDiff < count[i])
				maxDiff += count[i];
		}
		
		System.out.println(maxDiff/2);
	}

}
