package arrays;

public class FindOddOneOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int []{0,0,1,1,2,2,3,4,4};
		System.out.println(findOddOneOut(arr , 0 , arr.length - 1));
	}

	private static int findOddOneOut(int[] arr , int start , int end) {
		// TODO Auto-generated method stub
		int mid = (start + end)/2;
		int oddOne;
		if (mid < 0)
			return 0;
		
		if (  arr[mid] == arr[mid-1] )		{
			if ((arr.length - (mid + 1))% 2 == 1)	{
			return oddOne = findOddOneOut(arr,mid+1,arr.length-1);}
			else
				return oddOne = findOddOneOut(arr,0 , mid-2);
		}
		else if ( mid+1 < arr.length - 1 && arr[mid] == arr[mid+1] )	{
			return oddOne = findOddOneOut(arr,0,mid-1);
		}
		else	{
			return arr[mid];
		}
	}

	

}
