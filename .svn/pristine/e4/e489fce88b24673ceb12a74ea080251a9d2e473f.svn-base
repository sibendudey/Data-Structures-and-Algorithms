package strings;

public class MaxAbsDifference {
	public static void main(String args[])	{
		int arr [] = new int [ ]{2, -1, -2, 1, -4, 2, 8};
		findMaxAbsDiff(arr);
	}

	private static void findMaxAbsDiff(int[] arr) {
		// TODO Auto-generated method stub
		int maxSubLeftArray[] = new int[arr.length];
		int minSubLeftArray[] = new int[arr.length];
		int maxSubRightArray[] = new int[arr.length];
		int minSubRightArray[] = new int[arr.length];
		
		int maxSumEndingHere = 0;
		for ( int i = 0 ; i < arr.length - 1 ; i++){
			maxSumEndingHere = maxSumEndingHere + arr[i];
			maxSubLeftArray[i] = maxSumEndingHere;
			if ( maxSumEndingHere < 0){
				maxSumEndingHere = 0;
			}
		}
		
		maxSumEndingHere = 0;
		for ( int i = arr.length - 1 ; i >= 1 ; i--){
			maxSumEndingHere = maxSumEndingHere + arr[i];
			maxSubRightArray[i] = maxSumEndingHere;
			if (maxSumEndingHere < 0 )	{
				maxSumEndingHere = 0;
			}
		}
		
		for ( int i = 0 ; i < arr.length ; i++){
			arr[i] = -arr[i];
		}
		
		maxSumEndingHere = 0;
		for ( int i = 0 ; i < arr.length -1 ; i++  )	{
			maxSumEndingHere = maxSumEndingHere + arr[i];
			minSubLeftArray[i] = maxSumEndingHere;
			if (maxSumEndingHere < 0)	{
				maxSumEndingHere = 0;
			}
		}
		
		maxSumEndingHere = 0;
		for ( int i = arr.length - 1 ; i >= 1 ; i--){
			maxSumEndingHere = maxSumEndingHere + arr[i];
			minSubRightArray[i] = maxSumEndingHere;
			if (maxSumEndingHere < 0 )	{
				maxSumEndingHere = 0;
			}
		}
		
		for ( int i = 0 ; i < arr.length ; i++){
			minSubLeftArray[i] = -minSubLeftArray[i];
			minSubRightArray[i] = -minSubRightArray[i];
		}
		
		int maxAbsDiff = 0 ;
		for ( int i = 0 ; i < arr.length - 1  ; i++)	{
			if (maxSubLeftArray[i] - minSubRightArray[i+1] > maxAbsDiff)	{
				maxAbsDiff = maxSubLeftArray[i] - minSubRightArray[i];
			}
			
			if ( maxSubRightArray[i+1] - minSubLeftArray[i] > maxAbsDiff )	{
				maxAbsDiff = maxSubRightArray[i+1] - minSubLeftArray[i] ;
			}
			
		}
		
		System.out.println(maxAbsDiff);
	}
}
