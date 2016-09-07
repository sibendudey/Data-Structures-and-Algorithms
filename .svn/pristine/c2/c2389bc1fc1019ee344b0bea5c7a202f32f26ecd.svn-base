package strings;

import java.util.Scanner;

public class GemStones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Scanner in = new Scanner(System.in);
		int noOfWord = in.nextInt();
		in.nextLine();
		String words[] = new String[noOfWord];
		for ( int i = 0 ; i < noOfWord ; i++)	{
			words[i] = in.nextLine();
		}
		printGemStone(words);
		in.close();
	}

	private static void printGemStone(String[] words) {
		// TODO Auto-generated method stub
		int count[] = new int[26];
		for ( int i = 0 ; i < words.length ; i++){
			boolean track[] = new boolean[26];
			for ( char a : words[i].toCharArray())	{
				//int temp = count[a - 'a'];
				if ( track [a - 'a'] == false)	{
					++count[a - 'a'];
					track[a - 'a'] = true;
				}
			}
		}
		
		int result = 0;
		for ( int i = 0 ; i < 26 ; i++)	{
			if (count[i] == words.length)
				result++;
		}
		
		System.out.println(result);
	}

}
