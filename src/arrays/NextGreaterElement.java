package arrays;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {11, 13, 21, 3};
		printNextGreaterElement(arr);
	}

	private static void printNextGreaterElement(int[] arr) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(arr[0]);
		for ( int i = 1; i < arr.length  ; i++)	{
			while ( !stack.empty())	{
				int temp = stack.pop();
				if ( temp < arr[i])		{
					System.out.println(temp + " NGE=" + arr[i]);
				}
				else	{
					stack.push(temp);
					break;
				}
			}
			stack.push(arr[i]);
		}
		
		while ( !stack.empty())	{
			int temp = stack.pop();
			System.out.println(temp + " NGE=" + -1);
		}
	}

}
