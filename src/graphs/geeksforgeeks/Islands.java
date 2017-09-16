package graphs.geeksforgeeks;

/**
 * Created by Sibendu Dey on 3/28/2017.
 *
 * Why -> To find the number of Islands ( Island is a set of connected 1's in the matrix)
 *
 * How -> Start DFS from every unvisited vertex and mark source vertex and other vertex as visited in the DFS path.
 *        Return the count of successful DFS operations.
 *
 * Time complexity -> O(ROW * COL)
 *
 */
public class Islands {

    public static void main(String args[])  {

        int [][] graphMatrix = new int[][]  {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        Islands i = new Islands();
        System.out.println(i.printNoOfIslands(graphMatrix));
    }

    private int printNoOfIslands(int[][] graphMatrix) {

        int MAX_ROW = graphMatrix.length;
        int MAX_COL = graphMatrix[0].length;
        int count = 0;
        boolean visited[][] = new boolean[MAX_ROW][MAX_COL];

        for ( int i = 0 ; i < MAX_ROW ; i++)    {
            for ( int j = 0 ; j < MAX_COL ; j++)    {
                if ( graphMatrix[i][j] == 1 && !visited[i][j])  {
                    DFS(graphMatrix , i , j , visited);
                    ++count;
                }
            }
        }
    return count;
    }

    private void DFS(int[][] graphMatrix, int row, int col, boolean[][] visited) {

        int rowNumber[] = new int[] { -1 , -1 , -1 , 0, 0, 1 , 1 , 1};
        int colNumber[] = new int[] { -1 , 0 , 1 , -1 , 1 , -1 , 0 , 1};

        visited[row][col] = true;
        for ( int k = 0 ; k < 8 ; k++)  {
            if ( isSafe( graphMatrix , row + rowNumber[k] , col + colNumber[k] , visited))
                DFS( graphMatrix , row + rowNumber[k] , col + colNumber[k] , visited);
        }
    }

    private boolean isSafe(int[][] graphMatrix, int row, int col, boolean[][] visited) {
        return ( row >= 0 && row < graphMatrix.length && col >=0 && col < graphMatrix[0].length
               && !visited[row][col] && graphMatrix[row][col] == 1);
    }
}
