package careercup.questions.Mulesoft;

/**
 * Created by Sibendu on 6/14/2017.
 */
public class Rectangle {

    static int matrix[] [] = { { 1, 1, 1 , 1, 0 , 0},
            { 1, 1, 1, 1, 0, 0},
            { 0, 0, 0, 0, 0, 0},
            { 1, 1, 0, 0, 1, 1},
            { 1, 1, 0, 0, 1, 1},
            {0 , 0 , 1 , 1, 0, 0}};

    static int rowTraversal[] = new int[]{ -1 , -1 , -1 , 0 , 0 , 1, 1, 1};
    static int colTraversal[] = new int[] { -1 , 0, 1, -1, 1, -1, 0, 1};

    public static void main( String args[]) {

        boolean visited[][] = new boolean[matrix.length][matrix[0].length];

        int noOfRectangles = 0;
        for ( int i = 0 ; i < matrix.length ; i++)  {
            for ( int j = 0 ; j < matrix[0].length ; j++)   {
                if ( !visited[i][j] && matrix[i][j] == 1)   {
                    makeSurroundingOnesVisited(visited, i , j);
                    noOfRectangles++;
                }
            }
        }

        System.out.println(noOfRectangles);
    }

    private static void makeSurroundingOnesVisited(boolean[][] visited, int row, int col) {

        visited[row][col] = true;
        for ( int i = 0 ; i < rowTraversal.length ; i++)
            for ( int j = 0 ; j < colTraversal.length; j++) {
                int modifiedRow = row + rowTraversal[i];
                int modifiedCol = col + colTraversal[j];
                if ( modifiedRow >= 0 && modifiedRow < matrix.length
                        && modifiedCol >=0 && modifiedCol < matrix[0].length && matrix[modifiedRow][modifiedCol] == 1 && !visited[modifiedRow][modifiedCol])   {
                    makeSurroundingOnesVisited(visited, modifiedRow , modifiedCol);
                }
            }
    }

}
