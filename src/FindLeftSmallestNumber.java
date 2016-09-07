import java.util.Stack;


public class FindLeftSmallestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1,3,0,2,5};
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(arr[0]);
		
		for (int counter = 0 ; counter < arr.length ; counter++)	{
			if ( !stack.isEmpty() && (stack.size() == 1) && (stack.peek() == arr[counter]))	{
				System.out.print("N/A ");
			}
			else if ( !stack.isEmpty() && ( stack.peek() < arr[counter]))	{
				System.out.print(stack.peek() + " ");
				stack.push(arr[counter]);
			}
			else if ( !stack.isEmpty()  && (stack.peek() > arr[counter]))	{
				stack.pop();
				counter-- ;
			}
			else	{
				stack.push(arr[counter]);
				System.out.print("N/A ");
			}
		}

	}

}
