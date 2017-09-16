package careercup.questions.amazon;

/**
 * Disclaimer: This solution has been copied from  https://www.careercup.com/question?id=5731456048431104
 *
 */
public class PaintHouses {
    static final String[] COLOR_COMBINATION_STR = new String[]{"RGB", "RBG", "GBR", "GRB", "BGR", "BRG" };

    static public void printMinPaint(int n) {
        int[][] cost = new int[n][COLOR_COMBINATION_STR.length]; // can optimize 1st dimension to 2
        int[][] backTrack = new int[n][COLOR_COMBINATION_STR.length]; // previous combination

        // initialize
        for (int j = 0; j < COLOR_COMBINATION_STR.length; j++) {
            cost[0][j] = getCost(0, j);
        }
        for(int i = 1; i < n; i++) {
            for (int j = 0; j < COLOR_COMBINATION_STR.length; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }

        // calculate cheapest cost
        int min = 0; // keeps the cheapest last color combination
        for(int i = 1; i < n; i++) {
            int minCost = Integer.MAX_VALUE;
            for(int l = 0; l < COLOR_COMBINATION_STR.length; l++) { // O(n*9)
                for(int r = 0; r < COLOR_COMBINATION_STR.length; r++) { // O(n*9*9)
                    if(cost[i-1][l] < Integer.MAX_VALUE && isValidAdjacent(l, r)) {
                        int rc = cost[i-1][l] + getCost(i, r);
                        if(cost[i][r] > rc) {
                            cost[i][r] = rc;
                            backTrack[i][r] = l;
                            if(rc < minCost) {
                                min = r;
                                minCost = rc;
                            }
                        }
                    }
                }
            }
        }

        // backtrack to print (... print in reverse order, that's the same cost result)
        for(int i = n-1; i >= 0; i--) {
            System.out.println("Column: " + (n - i) + " Colors: " + COLOR_COMBINATION_STR[min]);
            min = backTrack[i][min];
        }
        System.out.println("---");
    }

    // some arbitrary cost function to produce a "random" cost per column for
    // a certain combination of house colors for the three rows
    private static int getCost(int column, int rowColorCombination) {
        return ((rowColorCombination * 17) * (column * 31)) % 11;
    }

    // can next column have this colors per row
    // e.g. if left=0 and right=1:
    // left   right
    // R      R
    // G      B
    // B      G
    // result false, because R   and R in the first row
    static private boolean isValidAdjacent(int left, int right) {
        for(int i = 0; i < 3; i++)
            if(COLOR_COMBINATION_STR[left].charAt(i) == COLOR_COMBINATION_STR[right].charAt(i))
                return false;
        return true;
    }


    static public void main(String[] args) {
        printMinPaint(2);
        printMinPaint(6);
        printMinPaint(12);
    }

}