import java.util.Scanner;


public class SplitArray {
	static int arr[] = new int[]{2,2,2,2};
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		int noOftestCases = in.nextInt() ;
		
		int startIndex = 0 ; 
		int endIndex = 0 ;
		//int arraySum = 0;
		int[] max = new int[noOftestCases];
		
		for ( int i = 0 ; i < noOftestCases ; i++){
			int arraySize = in.nextInt();
			long arraySum = 0;
			//int max = 0;
			long arr[] = new long[arraySize];
			for (int k = 0 ; k < arraySize ; k++)	{
				long value = in.nextLong();
				arr[k] = value;
			}
			for ( int iterator = 0 ; iterator < arr.length ; iterator++)	{
				arraySum = arraySum + arr[iterator];
			}
			
			//System.out.println(arraySum);
			if (arraySum % 2 == 0)	
				max[i] = splitArray(arr, 0 , arr.length - 1 , arraySum/2);
			
			
		}
		
		
		for ( int i = 0 ; i < noOftestCases; i++){
			System.out.println(max[i]);
		}
		
		

		
		//System.out.println(max)
	}
	private static int splitArray(long[] arr, int startIndex , int endIndex ,  long partitionArraySum) {
		// TODO Auto-generated method stub
		int count = 1;
		long midSum = 0 ;
		int midSumIndex = -1;
		for ( int i = startIndex ; i <= endIndex  ; i++)	{
			
			midSum = midSum + arr[i];
			midSumIndex = i;
			if (midSum == partitionArraySum)	{
				
				//System.out.println(midSum + " " + midSumIndex);
				
				if (partitionArraySum % 2 == 0 && (endIndex - startIndex + 1) >  2 )	{
					//System.out.println("Entered");
					return 1 + Math.max(splitArray(arr, startIndex , midSumIndex , partitionArraySum/2), splitArray(arr,midSumIndex+1,endIndex,partitionArraySum/2));
				}
				
				return 1;
				
				//System.out.println("Mid Sum:" + "startIndex: " + midSum + startIndex + endIndex);
		}
		

		//count = count + splitArray ( arr , partitionArraySum);

		}
		
		return 0;
	}
	/*private static int splitArrayUtil(int midSumIndex, int[] arr2, int partitionArraySum) {
		// TODO Auto-generated method stub
		
		return 0;
	}*/
}
