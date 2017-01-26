package arrays;

public class LongestCommonSpan {
	
	static int arr1[] = {0, 1, 0, 0, 0, 0};
	static int  arr2[] = {1, 0, 1, 0, 0, 1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findLongestCommonSpan(arr1,arr2);
		
	}
	private static void findLongestCommonSpan(int[] arr1, int[] arr2) {
		// TODO Auto-generated method stub
		int start = 0 ; 
		int end = 0 ;
		int length = 0 ;
		int sumArr1 = 0 ;
		int sumArr2 = 0; 
		for ( int i = 0 ;  i < arr1.length ; i++)	{
			sumArr1 = sumArr1 + arr1[i];
			sumArr2 = sumArr2 + arr2[i];
		}
	}

}
