package arrays.hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KnightL {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for ( int i = 1 ; i < n ; i++)  {
            for ( int j = 1 ; j < n ; j++)  {
                System.out.print(findMinimumSteps(n, i , j) + " ");
            }
            System.out.println();
        }
    }

    private static int findMinimumSteps(int n, int i, int j) {

        int[][] distance = new int[n][n] ;
        for ( int i_d = 0 ; i_d < n ; i_d++)
            for ( int j_d = 0 ; j_d < n ; j_d++)
                distance[i_d][j_d] = -1;

        distance[0][0] = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0 ));
        while (distance[n-1][n-1] == -1  && queue.size() > 0)   {
            Point point = queue.remove();
            if ( withinCourt( point.x + i, point.y + j, n) && distance[point.x + i][point.y + j] == -1)    {
                distance[point.x + i][point.y + j] = distance[point.x][point.y] + 1;
                queue.add(new Point(point.x + i , point.y + j));
            }
            if ( withinCourt( point.x - i, point.y + j, n) && distance[point.x - i][point.y + j] == -1)    {
                distance[point.x - i][point.y + j] = distance[point.x][point.y] + 1;
                queue.add(new Point(point.x - i , point.y + j));
            }
            if ( withinCourt( point.x + i, point.y - j, n) && distance[point.x + i][point.y - j] == -1)    {
                distance[point.x + i][point.y - j] = distance[point.x][point.y] + 1;
                queue.add(new Point(point.x + i , point.y - j));
            }
            if ( withinCourt( point.x - i, point.y - j, n) && distance[point.x - i][point.y - j] == -1)    {
                distance[point.x - i][point.y - j] = distance[point.x][point.y] + 1;
                queue.add(new Point(point.x - i , point.y - j));
            }
            int temp = i;
            i = j;
            j = temp;
            if ( withinCourt( point.x + i, point.y + j, n) && distance[point.x + i][point.y + j] == -1)    {
                distance[point.x + i][point.y + j] = distance[point.x][point.y] + 1;
                queue.add(new Point(point.x + i , point.y + j));
            }
            if ( withinCourt( point.x - i, point.y + j, n) && distance[point.x - i][point.y + j] == -1)    {
                distance[point.x - i][point.y + j] = distance[point.x][point.y] + 1;
                queue.add(new Point(point.x - i , point.y + j));
            }
            if ( withinCourt( point.x + i, point.y - j, n) && distance[point.x + i][point.y - j] == -1)    {
                distance[point.x + i][point.y - j] = distance[point.x][point.y] + 1;
                queue.add(new Point(point.x + i , point.y - j));
            }
            if ( withinCourt( point.x - i, point.y - j, n) && distance[point.x - i][point.y - j] == -1)    {
                distance[point.x - i][point.y - j] = distance[point.x][point.y] + 1;
                queue.add(new Point(point.x - i , point.y - j));
            }
            temp = i;
            i = j;
            j = temp;
        }
        return distance[n-1][n-1];
    }

    private static boolean withinCourt(int i, int j, int n) {
        return ( i >= 0 && i < n && j >= 0 && j < n);
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
