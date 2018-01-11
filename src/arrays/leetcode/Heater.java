package arrays.leetcode;

public class Heater {
    public int findRadius(int[] houses, int[] heaters) {
        int[] closestLeft = new int[houses.length];

        int maxDistance = 0;
        for ( int i = 0, j = 0 ; i < houses.length ; ) {
            if (j < heaters.length && houses[i] >= heaters[j]) {
                j++;
            } else {
                closestLeft[i] =  j - 1 >= 0 ? houses[i] - heaters[j - 1] : Integer.MAX_VALUE;
                i++;
            }
        }

        int [] closestRight = new int[houses.length];

        for ( int i = houses.length - 1, j = heaters.length - 1 ; i >= 0 ; ) {
            if ( j >= 0 && houses[i] <= heaters[j]) j--;
            else {closestRight[i] = j + 1 <= heaters.length - 1 ? heaters[j+1] - houses[i] : Integer.MAX_VALUE;
            i--;}
        }

        for ( int i = 0 ; i < houses.length ; i++)  {
            maxDistance = Math.max(maxDistance, Math.min(closestLeft[i], closestRight[i]));
        }

        return maxDistance;
    }

    public static void main(String args[])  {
        new Heater().findRadius(new int[]{1,5}, new int[]{2});
    }
}
