public class Sorted1 {

	public static void main(String[] args) {
		int arr[] = { 23, 68, 57, 65, 47, 70 };
		sortArray(arr);

	}

	private static void sortArray(int[] arr) {
		// TODO Auto-generated method stub
		int leftIndex = -1;
		int rightIndex = -1;
		String value = "false";
		System.out.println( value == null);
		for (int counter = 0; counter < arr.length - 1; counter++) {

			if (leftIndex == -1) {
				if (arr[counter] > arr[counter + 1]) {
					leftIndex = counter;
				}
			}
			
			if (rightIndex == -1)	{
				if (arr[ arr.length-counter-1] < arr[arr.length-counter-2] )	{
					rightIndex = arr.length - counter -1;
				}
			}
			
		}
		
		if (leftIndex >= rightIndex)	{
			System.out.println("Array is sorted or either invalid for computation");
		}
		else	{
			int temp = arr[leftIndex];
			arr[leftIndex] = arr[rightIndex];
			arr[rightIndex] = temp;
			for (int counter = 0 ; counter < arr.length ; counter ++)	{
				System.out.print(arr[counter]+" ");
			}
		}

	}

}
