package arrays;

public class LongestSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "sibendusibenduzdey";
		longestSubstring(str);
	}

	private static void longestSubstring(String str) {
		// TODO Auto-generated method stub
		int arr[] = new int[26];
		for ( int i = 0 ; i < 6 ; i++)
			arr[i] = -1;
		arr[str.charAt(0) - 97] = 0;
		int maxLength = 0;
		int currLength = 0;
		for ( int i = 1 ; i < str.length() ; i++){
			int prev_index = arr[str.charAt(i) - 97];
			if ( prev_index == -1 || i - currLength > prev_index)
				currLength++;
			
			else {
				if ( currLength > maxLength)	{
					maxLength = currLength;
				}
				currLength = i - prev_index;
			}
			arr[str.charAt(i) - 97] = i; 
		}
		System.out.println(maxLength);
	}

}
