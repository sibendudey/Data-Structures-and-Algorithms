package matrix;

public class PrintUniqueRows {

	final static int ROW = 4 , COL = 5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] M = {{0, 1, 0, 0, 1},
			        {1, 0, 1, 1, 0},
			        {0, 1, 0, 0, 1},
			        {1, 0, 1, 0, 0}
			    };
		 
		 findUniqueRows( M);
	}
	private static void findUniqueRows(int[][] m) {
		// TODO Auto-generated method stub
		Node rootTrie = new Node();
		for ( int i = 0 ; i < ROW ; i++)	{
			if ( isUnique( rootTrie , m , i , 0))
				printMatrix ( m , i);
		}
		
	}
	private static void printMatrix(int[][] m, int row) {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < m[row].length ; i++)	{
			System.out.print(m[row][i]);
		}
		
		System.out.println();
	}
	private static boolean isUnique(Node rootTrie, int[][] m, int row, int col) {
		// TODO Auto-generated method stub
		while ( col < COL)	{
			int presentBoolValue = m[row][col];
			if ( rootTrie.child[presentBoolValue] == null)	{
				rootTrie.child[presentBoolValue]= new Node();
				rootTrie = rootTrie.child[presentBoolValue];
				col++;
			}
			else	{
				rootTrie = rootTrie.child[presentBoolValue];
				col++;
			}
		}
		
		if ( rootTrie.isEndOfCol == true)
			return false;
		else	{
			rootTrie.isEndOfCol = true;
			return true;
		}
	}

}


class Node	{
	boolean isEndOfCol;
	Node[] child = new Node[2];
}
