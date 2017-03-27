package arrays;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayReducedForm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] =  {5,10,40,30,20};
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for ( int numbers : arr){
			temp.add(numbers);
		}
		Collections.sort(temp);
		for ( int iterator = 0 ; iterator < arr.length ; iterator++){
			int number = arr[iterator];
			int index = temp.indexOf(number);
			arr[iterator] = index;
		}
		
		int[][] arr1 = new int[2][3];
		
		printReducedForm(arr);
	}

	private static void printReducedForm(int[] arr) {
		// TODO Auto-generated method stub
		for ( int index : arr)	{
			System.out.print(index + " ");
		}
	}

}
