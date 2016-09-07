package matrix;

public class SpiralSortedMatrixInsertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[][] = new int[][]{ {10,12,15,17} ,
				{ 36, 40, 41, 20}, 
				{ 35, 100 , 45, 23},
				{ 34, 33, 29, 24}};
		
		printSpiralMatrix(arr);

	}

	private static void printSpiralMatrix(int[][] arr) {
		// TODO Auto-generated method stub
		int m = 0;
		int n = 0;
		int maxRow = arr.length - 1;
		int maxCol = arr[0].length - 1;
		while ( m <= maxRow && n<=maxCol)	{
			int i,j;
			for ( i = m  , j = m ; j <= maxCol ; j++ )	{
				System.out.print(arr[i][j] + " ");
			}
			
			for ( i = m+1 , j = maxCol ; i <= maxRow ; i++){
				System.out.print(arr[i][j] + " ") ;
			}
			
			for ( i = maxRow , j = maxCol - 1 ; j >= n ; j--)	{
				System.out.print(arr[i][j] + " ");
			}
			for ( i = maxRow - 1 , j = m ; i > m ; i-- )	{
				System.out.print(arr[i][j] + " ");
			}
			
			m++;n++;maxRow--;maxCol--;
			
		}
	}

}
