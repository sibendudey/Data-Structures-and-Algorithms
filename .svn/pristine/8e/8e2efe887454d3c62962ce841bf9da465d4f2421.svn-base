package arrays;

public class FindTwoNumber {

	static int arr1[] = new int[]{23,34,45,100,101,200,300};
	static int arr2[] = new int[]{12,20,30,35,56,67,89,91};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findNumber(arr1, 145);
		findNumber(arr2, 51);
	}
	private static void findNumber(int[] arr, int sum) {
		// TODO Auto-generated method stub
		int i = 0;
		int j = arr.length - 1;
		while ( i < j)	{
			if (arr[i] + arr[j] == sum)	{
				System.out.println("The numbers are:" + arr[i] + " " + arr[j]);
				return;
			}
			else if (arr[i] + arr[j] > sum)	{
				j--;
			}
			else
				i++;
		}
		
		System.out.println("No such pair is present");
	}

}
