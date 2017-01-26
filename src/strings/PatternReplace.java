package strings;

public class PatternReplace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "geeksforgeeks";
		String pattern = "geek";
		patternReplace(str , pattern);

	}

	private static void patternReplace(String str, String pattern) {
		// TODO Auto-generated method stub
		String outputString = "";
		for ( int i = 0 ; i  < str.length() ; i++)	{
			if ( i + pattern.length() <= str.length() && str.substring(i , i + pattern.length()).equals(pattern))	{
				outputString = outputString + "X";
				i = i + pattern.length() - 1;
			}
			else	{
				outputString = outputString + str.charAt(i);
			}
		}
		System.out.println(outputString);
	}

}
