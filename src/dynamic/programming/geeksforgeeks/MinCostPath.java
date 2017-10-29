package dynamic.programming.geeksforgeeks;

/***
 * This problem finds the min cost path for traversing from one
 * cell to another cell in a matrix
 * Link : http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 */
public class MinCostPath {
    public static void main(String args[])  {

        int mat[][] = new int[][]   {
                { 1, 2, 3} ,
                { 4, 8, 2} ,
                { 1, 5, 3}
        };

        System.out.println(findMinCost(mat , 2 , 2));
    }

    private static int findMinCost(int[][] mat, int endI, int endJ) {
        int dp[][] = new int[mat.length][mat[0].length];

        dp[0][0] = mat[0][0];

        for ( int i = 1 ; i < mat.length ; i++) {
            dp[i][0] = dp[i-1][0] + mat[i][0];
        }
        for ( int j = 1 ; j < mat.length ; j++) {
            dp[0][j] = dp[0][j-1] + mat[0][j];
        }
        for ( int i = 1 ; i < mat.length ; i++)    {
            for ( int j = 1 ; j < mat[0].length ; j++) {
                dp[i][j] = mat[i][j] + Math.min( dp[i-1][j],
                        (Math.min(dp[i][j - 1],dp[i-1][j-1])));
            }
        }

        return dp[endI][endJ];
    }
}
