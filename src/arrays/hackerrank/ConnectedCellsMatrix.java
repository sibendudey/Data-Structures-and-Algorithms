package arrays.hackerrank;

import java.util.Scanner;

public class ConnectedCellsMatrix {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int mat[][] = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                mat[i][j] = sc.nextInt();

        System.out.println(biggestRegion(mat));
    }

    private static int biggestRegion(int[][] mat) {
        boolean dfs[][] = new boolean[mat.length][mat[0].length];
        int maxRegion = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && !dfs[i][j]) {
                    dfs[i][j] = true;
                    int currentRegion = 1 + biggestRegionUtil(mat, i, j, dfs);
                    maxRegion = Math.max(maxRegion, currentRegion);
                }
            }
        }

        return maxRegion;
    }

    private static int biggestRegionUtil(int[][] mat, int posI, int posJ, boolean[][] dfs) {

        int sumRegion = 0;

        for ( int i = -1 ; i <= 1 ; i++)    {
            for ( int j = -1 ; j <= 1 ; j++)    {
                int nextI = posI + i;
                int nextJ = posJ + j;
                if ( isValid( nextI , nextJ, mat.length , mat[0].length) && mat[nextI][nextJ] == 1
                        && !dfs[nextI][nextJ]) {
                    dfs[nextI][nextJ] = true;
                    sumRegion += 1 + biggestRegionUtil(mat, nextI, nextJ, dfs);
                }
            }
        }

        return sumRegion;
    }

    private static boolean isValid(int nextI, int nextJ, int rowLength, int colLength) {
        return ( nextI >= 0 && nextI < rowLength && nextJ >= 0 && nextJ < colLength);
    }
}
