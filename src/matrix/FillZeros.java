package matrix;

public class FillZeros {
	
	static int arr[][] = new int[][]{
		{0, 0 , 0 , 0 , 0,  0} ,
	       {1 ,  0,  0,  0, 1,  0}, 
	       {0 ,  0,  0,  1,  0,  0}, 
	       {0 ,0, 0, 0, 0, 0}, 
	       {0, 0,0, 0, 0, 0}, 
	       {1, 1, 1, 1, 1, 0 }
	};
	
	static int ROW = 6;
	static int COL = 6;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for ( int i = 0 ; i < ROW ; i++)	{
			for ( int j = 0 ; j < COL ; j++)	{
				if (arr[i][j] == 1)	{
					arr[i][0] = 1;
					arr[0][j] = 1;
				}
			}
		}

		for ( int i = 1 ; i < ROW ; i++)	{
			for ( int j = 1 ; j < COL ; j++)	{
				if ( arr[i][0] == 1 || arr[0][j] == 1)	{
					arr[i][j] = 1;
				}
			}
		}
		
		for ( int i = 0 ; i < ROW ; i++)	{
			for ( int j = 0 ; j < COL ; j++)	{
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
	}

}
