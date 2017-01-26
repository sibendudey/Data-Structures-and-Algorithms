package strings;

import java.util.Scanner;

public class FunnyString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int noOfInputs = in.nextInt();
		for ( int i = 0 ; i < noOfInputs ; i++)	{
			String input = in.next();
			findFunny(input);
		}
	}

	private static void findFunny(String input) {
		// TODO Auto-generated method stub
		for ( int i = 1 ; i <= input.length()/2 ; i++)	{
			if ( Math.abs(input.charAt(i) - input.charAt(i - 1)) == Math.abs(input.charAt(input.length() - i ) - input.charAt(input.length() - i - 1)))
				continue;
			else	{
				System.out.println("Not funny");
				return;
			}		
		}
		
		System.out.println("funny");
		
	}

}
