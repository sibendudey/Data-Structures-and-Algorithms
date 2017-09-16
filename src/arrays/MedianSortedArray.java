package arrays;

public class MedianSortedArray {

	public static void main(String[] args) {

		int arr1[] = new int[] {12,24,56,78,89};
		int arr2[] = new int[] {13,67,89,100,101};
		int median = getMedian(arr1 , arr2 , 0 , arr1.length - 1 , 0 , arr2.length - 1);
		System.out.println(median);
		
	}

	private static int getMedian(int[] arr1, int[] arr2, int low1, int high1, int low2 , int high2) {

		int arraySize = high1 - low1 + 1;
		if (arraySize == 0)
			return -1;
		if (arraySize == 1)
			return (arr2[low1] + arr1[low1])/2;
		if ( arraySize == 2)	{
			//System.out.println((Math.max(arr1[low1], arr2[low2]) + Math.min(arr1[high1], arr2[high2]) ) /2);
			return (Math.max(arr1[low1], arr2[low2]) + Math.min(arr1[high1], arr2[high2]))/2;
		}
		
		int m1 = median(arr1, low1,high1);
		int m2 = median(arr2, low2,high2);
		System.out.println(m1 + " ");
		System.out.println(m2 + " ");
		
		if ( m1 == m2)	{
			return m1;
		}
		if ( m2 > m1)	{
				return getMedian(arr1, arr2 , (high1+low1)/2 , high2 , low2 ,(low2 + high2)/2 );
		}
		else	{
			return getMedian(arr1 , arr2 , low1 , (low1+high1)/2 , (low2+high2)/2, high2);
		}
	}

	private static int median(int[] arr, int low1, int high1) {
		// TODO Auto-generated method stub
		int size = (high1 - low1) + 1;
		if ( size % 2 == 0)
			return (arr[(high1+low1)/2] + arr[(high1 + low1)/2 + 1])/2; 
		return arr[(high1 + low1)/2];
	}

}
