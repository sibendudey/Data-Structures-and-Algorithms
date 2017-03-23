package com.hackerearth.accolite;

import java.util.Scanner;

public class VowelPhella {

	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int length = in.nextInt();
			String str = in.next();
			System.out.println(calculateSubstrings(str, length));
		}

	}

	private static int calculateSubstrings(String str, int stringLength) {

		int table[][] = new int[stringLength][stringLength];
		
		for ( int i = 0 ; i < stringLength ; i++)	{
			char curr = str.charAt(i);
			switch ( curr)	{
			case 'a':
				table[i][i] = 1;
				break;
			case 'e':
				table[i][i] = 1;
				break;
			case 'i':
				table[i][i] = 1;
				break;
			case 'o':
				table[i][i] = 1;
				break;
			case 'u':
				table[i][i] = 1;
				break;
			}
			
		}
		for ( int length = 2 ; length <= stringLength ; length++)	{
			for ( int i = 0 ; i+length <= stringLength ; i++)	{
				char curr = str.charAt(i + length - 1);
				switch ( curr)	{
				case 'a':
					table[i][i + length - 1] = table[i][i + length - 2] + 1;
					break;
				case 'e':
					table[i][i + length - 1] = table[i][i + length - 2] + 1;
					break;
				case 'i':
					table[i][i + length - 1] = table[i][i + length - 2] + 1;
					break;
				case 'o':
					table[i][i + length - 1] = table[i][i + length - 2] + 1;
					break;
				case 'u':
					table[i][i + length - 1] = table[i][i + length - 2] + 1;
					break;
				default:
					table[i][i+ length - 1 ] = table[i][i + length - 2];
				}
				
			}
		}			
		
	
		
	
	
		int noOfSubStrings = 0;
		for (int length = 3; length <= stringLength; length++) {
			for (int i = 0; i + length <= stringLength; i++) {
				if ( table[i][i + length - 1] == 3)
					noOfSubStrings++;
			}
		}
		
		return noOfSubStrings;

	}

	private static boolean ifThreeVowel(String substring) {

		int noOfVowel = 0;
		for (int i = 0; i < substring.length(); i++) {
			switch (substring.charAt(i)) {
			case 'a':
				noOfVowel++;
				break;
			case 'e':
				noOfVowel++;
				break;
			case 'i':
				noOfVowel++;
				break;
			case 'o':
				noOfVowel++;
				break;
			case 'u':
				noOfVowel++;
				break;
			}
		}
		
		if (noOfVowel == 3)
			return true;
		
		return false;

	}
}
