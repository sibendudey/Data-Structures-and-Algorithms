package strings;

public class LargestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aaaabbbbb";
		findLargestPalindrome(str);
	}

	private static void findLargestPalindrome(String str ) {
		// TODO Auto-generated method stub
		int length = str.length();
		int startIndex = 0;
		int maxLength = 1;
		boolean table[][] = new boolean[length][length];
		
		// All i,i will be set to true
		for ( int i = 0 ; i < length ; i++)	{
			table[i][i] = true;
		}
		
		for ( int i = 0 ; i < length - 2; i++)	{
			if ( str.charAt(i) == str.charAt(i+1))	{
				table[i][i+1] = true;
				startIndex = i;
				maxLength = 2;
			}
		}
		
		for ( int k = 3 ; k < length ; k++)	{
			for ( int i = 0 ; i < length - k + 1 ; i++ )	{
				if ( str.charAt(i) == str.charAt(i+k -1 ) && table[i+1][i+k-2] )	{
					table[i][i+k -1] = true;
					if ( k > maxLength)	{
						startIndex = i;
						maxLength = k;
					}
				}
			}
		}
		
		System.out.println("Longest substring starts with 	" + startIndex + " having a length of " + maxLength);
	}

}
