package hackapril2016;

import java.util.Scanner;

public class SuperReducedString {
	
	//static String input;
	public static void main(String args[])	{
		Scanner in = new Scanner(System.in);
		String input = in.next();
		String reducedString = reduceString(input);
		if (reducedString.length() == 0)
		System.out.println("Empty String");
		else
		System.out.println(reduceString(input));
		
	}
	private static String reduceString(String input2) {
		// TODO Auto-generated method stub
		char prevChar = '.';
		int charPos = 0;
		do	{
			if (prevChar == '.')	{
				prevChar = input2.charAt(charPos);
				charPos++;
			}
			else	{
				if ( prevChar == input2.charAt(charPos))	{
					try	{
						input2 = input2.substring(0, charPos-1) + input2.substring(charPos+1);
						//System.out.println(input2);
					}catch (IndexOutOfBoundsException e)	{
						input2 = input2.substring(charPos+1);
						charPos = 0;
						prevChar = '.';
					}
					charPos = 0;
					prevChar = '.';
				}
				else	{
					prevChar = input2.charAt(charPos);
					charPos++;
				}
			}
		}while (input2.length() != 1 && input2.length() != 0 && charPos < input2.length());
		return input2;
	}

}
