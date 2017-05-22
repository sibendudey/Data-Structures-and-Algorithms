package careercup.questions.facebook;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Sibendu Dey on 11/5/17.
 *
 * Why -> To find K closest points from origin(0,0)
 *
 * How -> Find the distance first for all the points. For simplicity, assume the
 *        distance of (a,b) is ( a - 0 ) + ( b - 0 )
 */
public class KClosestPoints {

    static class Point  {
        private int xCoordinate;
        private int yCoordinate;
        private int distance;

        public int getxCoordinate() {
            return xCoordinate;
        }

        public int getyCoordinate() {
            return yCoordinate;
        }

        public int getDistance() {
            return distance;
        }

        public Point(int xCoordinate, int yCoordinate, int distance) {
            this.xCoordinate = xCoordinate;
            this.yCoordinate = yCoordinate;
            this.distance = distance;
        }
    }

    public static void main(String args[])  {

        Scanner sc = new Scanner(System.in);
        int noOfPoints = sc.nextInt();
        int kClosestPoints = sc.nextInt();
        ArrayList<Point> points = new ArrayList<>();
        Point[] kClosestPointsResult = new Point[kClosestPoints];
        for ( int i = 0 ; i < noOfPoints ; i++) {
            int xCoordinate = sc.nextInt();
            int yCoordinate = sc.nextInt();
            Point point = new Point(xCoordinate , yCoordinate , xCoordinate + yCoordinate);
            points.add(point);
        }

        findKClosestPoints(points , kClosestPointsResult);

    }

    private static void findKClosestPoints(ArrayList<Point> points, Point[] kClosestPointsResult) {

        for ( int i = 0 ; i <= kClosestPointsResult.length ; i++)   {
            kClosestPointsResult[i] = points.get(i);
            heapifyUp(kClosestPointsResult , i);
        }

        for ( int i = kClosestPointsResult.length + 1 ; i < points.size() ; i++)    {
            Point point = points.get(i);

            int insertPos = 0;

            if ( kClosestPointsResult[insertPos].getDistance() > point.getDistance())  {
                kClosestPointsResult[insertPos] = point;
                heapifyDown(kClosestPointsResult , insertPos, kClosestPointsResult.length - 1);
            }
        }

    }

    private static void heapifyUp(Point[] kClosestPointsResult, int i) {
        if (i > 0)  {
            if ( kClosestPointsResult[(i-1)/2].getDistance() < kClosestPointsResult[i].getDistance())   {
                swap(kClosestPointsResult, i , ( i - 1)/2);
                i = ( i - 1)/2;
                heapifyUp(kClosestPointsResult , i);
            }
        }
    }


    private static void heapifyDown(Point[] kClosestPointsResult, int insertPos, int maxPos) {

        if ( insertPos > maxPos || kClosestPointsResult[2*insertPos+1] == null || kClosestPointsResult[2*insertPos+2] == null)
            return;

        int currPos = insertPos;

        if ( kClosestPointsResult[insertPos].getDistance() > kClosestPointsResult[2*currPos+1].getDistance())
            insertPos = 2*currPos + 1;

        if ( kClosestPointsResult[insertPos].getDistance() > kClosestPointsResult[2*currPos+2].getDistance())
            insertPos = 2*currPos + 2;

        swap(kClosestPointsResult, currPos , insertPos);
    }

    private static void swap(Point[] kClosestPointsResult, int currPos, int insertPos) {
        Point temp = kClosestPointsResult[currPos];
        kClosestPointsResult[currPos] = kClosestPointsResult[insertPos];
        kClosestPointsResult[insertPos] = temp;
    }
}
