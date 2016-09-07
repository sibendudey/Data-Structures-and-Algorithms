package matrix;

import java.util.Stack;

public class AntiSpiralMatrixDisplay {
	
	public static void main(String args[])	{
		
		int arr[][] = new int[][]{ {1,2,3}, {4,5,6} , {7,8,9}};
		int MAX_ROW = 2;
		int MAX_COL = 2;
		Stack<Integer> stack = new Stack<Integer>();
		
		for ( int i = 0, j = 0 ; i <= MAX_ROW && j <= MAX_COL; i++ , j++ , MAX_ROW-- , MAX_COL-- ){
			
			int l,k;
			l=i;k=j;
			for (  ; k <= MAX_COL ; k++)
				stack.push(arr[l][k]);
			
			for ( l = i+1 , k = MAX_COL  ; l <= MAX_ROW ; l++)	
				stack.push(arr[l][k]);
			
			for ( l = MAX_ROW , k = MAX_COL - 1 ; k >= j ; k--  )
				stack.push(arr[l][k]);
			
			for ( l = MAX_ROW - 1 , k = j ; l > i ; l--)
				stack.push(arr[l][k]);
			
			
		}
		
		printAntiSpiralMatrix(stack);
	}

	private static void printAntiSpiralMatrix(Stack<Integer> stack ) {
		// TODO Auto-generated method stub
		while (!stack.empty())
			System.out.print(stack.pop()+ " ");
	}
}
