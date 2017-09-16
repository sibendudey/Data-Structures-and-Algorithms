
public class FrequencyFinder {

	public static void main(String[] args) {
		int arr[] = {3,4,5,1,1};
		for (int count = 0 ; count < arr.length ; count++)	{
			int currNum = arr[count];
			if ( arr[currNum - 1] <= 0 )	{
				arr[currNum -1]--;
				count++;
			}
			else if (arr[currNum - 1] > 0)	{
				arr[count] = arr[currNum - 1];
				arr[currNum] = -1;
			}
		}

	}

}
