package strings;

public class LargestSubStringUniqueChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcdefabcdefghklmnopabcdefghklmnopstuv";
		findLargestSubString(str);
		
	}

	private static void findLargestSubString(String str) {
		// TODO Auto-generated method stub
		int lastLocation[] = new int[26];
		for ( int i = 0 ; i < lastLocation.length ; i++)
			lastLocation[i] = -1;
		int currLength = 0;
		int maxLength = 0;
		for ( int i = 0 ; i < str.length() ; i++)	{
			char temp = str.charAt(i);
			if ( lastLocation[temp - 'a'] == -1)	{
				currLength++;
				System.out.println(currLength);
				if ( currLength > maxLength)
					maxLength = currLength;
				lastLocation[temp - 'a'] = i;
			}
			else	{
				if ( i - lastLocation[temp - 'a'] < currLength)
					currLength = i - lastLocation[temp - 'a'];
				else
					currLength++;
				System.out.println(currLength);
				lastLocation[temp - 'a'] = i;
			}
		}
		
		System.out.println(maxLength);
	}

}
