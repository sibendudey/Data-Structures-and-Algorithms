package strings;

public class LongestPalindromeRecursive {

	static int maxLength = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aaaabbbbb";
		findLongestPalindromeRecursive( str , 0 , str.length() - 1 , 0);
		System.out.println("Longest length is" + maxLength);
	}
	private static void findLongestPalindromeRecursive(String str, int i, int j, int currLength) {
		// TODO Auto-generated method stub
		if ( i > j)	{
			if ( currLength > maxLength)	{
				maxLength = currLength;
			}
			return ;
		}
		
		else if ( i == j)	{
			if ( currLength + 1 > maxLength)	{
				maxLength = currLength + 1;
			}
			return;
		}
		else	{
			if ( str.charAt(i) == str.charAt(j))		{
				findLongestPalindromeRecursive(str, i+1, j-1, currLength+2);
			}
			else	{
				findLongestPalindromeRecursive(str, i+1, j-1, 0);
			}
			findLongestPalindromeRecursive(str, i+1, j, 0);
			findLongestPalindromeRecursive(str, i, j-1, 0);
			
	}
		
	}

}
