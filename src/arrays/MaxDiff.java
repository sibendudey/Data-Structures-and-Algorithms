package arrays;

public class MaxDiff {

	public static void main(String[] args) {
		
		int arr[] = {-10, 3, 10, 6, 4, 8, -1};
		int tempDiff , tempMinIndex , actDiff , actMaxIndex , actMinIndex ; 
		actDiff = tempDiff = 0;
		tempMinIndex = 0;
		actMaxIndex = actMinIndex = -1;
		
		for (int counter = 1; counter < arr.length ; counter++)	{
			if (arr[counter] < arr[tempMinIndex])	{
				tempMinIndex = counter;
			}
			if (arr[counter] > arr[tempMinIndex])	{
				tempDiff = arr[counter] - arr[tempMinIndex];
				if (tempDiff > actDiff)	{
					actMaxIndex = counter;
					actMinIndex = tempMinIndex;
					actDiff = tempDiff;
				}
			}
		}
		
		System.out.println("Actual Max Index =" + actMaxIndex);
		System.out.println("Actual Min Index =" + actMinIndex);
		System.out.println("Greatest difference between them =" + actDiff);
	}

}
