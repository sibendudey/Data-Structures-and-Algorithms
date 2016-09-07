package arrays;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {22, 23 ,24 , 25 , 26 , 27 , 28 , 29 ,  31 , 32 , 33 , 34};
		System.out.println(binarySearch ( arr , 0 , arr.length - 1 , arr.length - 1));
	}

	private static int binarySearch(int[] arr , int start , int end , int lastIndex) {
		// TODO Auto-generated method stub
		if ( start > end)
			return -1;
		
		int mid = ( start + end ) / 2;
		if  ( mid-1 >=0 && arr[mid]-1 != arr[mid-1] )	{
			return arr[mid] - 1;
		}
		else if ( mid+1 <= lastIndex && arr[mid+1] != arr[mid] + 1)	{
			return arr[mid]+1;
		}
		else	{
			if ( arr[mid] - arr[0] == mid - 0)	{
				return binarySearch(arr ,  mid+1, end, lastIndex);
			}
			else	{
				return binarySearch ( arr , start , mid - 1 , lastIndex);
			}
		}
	}

	private static boolean checkEquality(int[] arr, int mid) {
		// TODO Auto-generated method stub
		if ( mid-1 >= 0 && mid+1<=arr.length - 1)	{
			if ( arr[mid] != arr[mid-1]-1 && arr[mid] != arr[mid+1] )	{
				return true;
		}
		}
		else if ( mid-1 >=0 && arr[mid]!=arr[mid-1])
			return true;
		else	if ( arr[mid] != arr[mid+1])
			return true;
		
		return false;
	}

}
