package strings;

import java.util.Scanner;

public class Pangram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		printResult(sentence);

	}

	private static void printResult(String sentence) {
		// TODO Auto-generated method stub
		//Arr<Integer> count = new ArrayList<Integer>();
		int [] count = new int[26];
		for (int i= 0 ; i < 26 ; i++)	{
			count[i] = 0;
		}
		for (char a : sentence.toCharArray())	{
			//System.out.print((int)a+" ");
			if ( a>=65 && a<=90 )	{
				//System.out.print((int)a + " ");
				int temp = count[a-'A'];
				count[a-'A'] = ++temp;
			}
			if (a >= 97 && a<=122)	{
				//System.out.print((int)a + " ");
				int temp = count[a - 'a'];
				count[a- 'a'] = ++temp;
				//System.out.println(count.get(a-'a'));
			}
		}
		//for (int i = 0 ; i < 26 ; i++){
			//System.out.print(count.get(i) + " ");
		//}
		for (int i = 0 ; i < 26 ; i++)	{
			if (count[i] == 0)	{
				System.out.println("not pangram");
				return;
			}
		}
		System.out.println("pangram");
		
	}

}
