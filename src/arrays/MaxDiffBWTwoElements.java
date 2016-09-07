package arrays;

public class MaxDiffBWTwoElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] =  {80, 2, 6, 3, 100};
		findMaxDiff(arr);
	}

	private static void findMaxDiff(int[] arr) {
		// TODO Auto-generated method stub
		int maxDiff = 0;
		// Expect non negative integers
		int min = 9999;
		
		for ( int i = 0 ; i < arr.length ; i++){
			if ( arr[i] < min)	{
				min = arr[i];
				continue;
			}
			else	{
				if (maxDiff < arr[i] - min)
					maxDiff = arr[i] - min;
			}
		}
		
		System.out.println(maxDiff);
	}

}
