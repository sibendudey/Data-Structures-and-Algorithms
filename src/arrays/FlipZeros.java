package arrays;

public class FlipZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[]{1,0,0,0,1,1,0,0,0,0,0};
		findRangeToFlip(arr);
 	}

	private static void findRangeToFlip(int[] arr) {
		// TODO Auto-generated method stub
		int startIndex = -1;
		int endIndex = -1;
		int maxDiff = 0;
		int currDiff = 0;
		int currStartIndex = 0;
		int currEndIndex =0;
		int currIterator = 0;
		while ( currIterator < arr.length)	{
			if (arr[currIterator] == 1)	{
				currDiff--;
			}
			else	{
				currDiff++;
			}
			if ( currDiff > 0)	{
				currEndIndex++;
				if ( currDiff > maxDiff)	{
					maxDiff = currDiff;
					startIndex = currStartIndex;
					endIndex = currEndIndex;
				}
			}
			else	{
				currDiff = 0;
				currStartIndex = currIterator + 1;
				currEndIndex = currIterator + 1;
			}
			currIterator++;
		}
		
		System.out.println("Range is [" + startIndex + "," + endIndex + "]");
		
	}

}
