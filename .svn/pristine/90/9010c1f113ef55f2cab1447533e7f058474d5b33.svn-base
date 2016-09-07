package dynamic.programming;

public class JumbledNumbers {
	public static void main(String args[])	{
		String number = "2222134";
		//int i = -1 % 10;
		printJumbledNumbers(number);
	}

	private static void printJumbledNumbers(String number) {
		// TODO Auto-generated method stub
		for ( int i = 1 ; i <= 9 ; i++){
			String str = "";
			str= str + i;
			printJumbedNumbersUtil(str , number);
		}
	}

	private static void printJumbedNumbersUtil(String str, String number) {
		// TODO Auto-generated method stub
		if ( Long.valueOf(str) <= Long.valueOf(number) )	{
			System.out.println(str);
			
			String incrementStr = str;
			int nextDigitIncrement  = Integer.valueOf(str.substring(str.length() - 1 , str.length() )) + 1;
			if ( nextDigitIncrement != 10)	{
				incrementStr = incrementStr + nextDigitIncrement;
				printJumbedNumbersUtil(incrementStr , number);
			}
			
			String decrementStr = str;
			int nextDigitDecrement = Integer.valueOf(str.substring(str.length() - 1)) - 1;
			if (nextDigitDecrement !=  -1)	{
				decrementStr = decrementStr + nextDigitDecrement;
				printJumbedNumbersUtil(decrementStr , number);
			}
	}
		else {
			return;
		}
		
	}
}
