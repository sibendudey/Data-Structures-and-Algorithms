package dynamic.programming.cormen;

import java.util.Arrays;

/**
 * I created this program for tracing the subproblems
 * as part of college assignment.
 * CLRS Exercise 15.2-1
 */

public class OptimalParenthesize {
    public static void main(String args[]) {
        System.out.println(new OptimalParenthesize().optimalParenthesis(new int[]{5, 10, 3, 12, 5, 50, 6}));
    }

    public String optimalParenthesis(int[] dimensions) {
        int cost[][] = new int[dimensions.length][dimensions.length];
        int trace[][] = new int[dimensions.length][dimensions.length];
        for (int i = 0; i < dimensions.length; i++)
            for (int j = 0; j < dimensions.length; j++)
                if (i == j)
                    cost[i][j] = 0;
                else
                    cost[i][j] = Integer.MAX_VALUE;

        for (int length = 1; length < dimensions.length - 1; length++) {
            for (int i = 1; i + length < dimensions.length; i++) {
                for (int k = i; k < i + length; k++) {
                    int temp = cost[i][k] + cost[k + 1][i + length]
                            + dimensions[i - 1] * dimensions[k] * dimensions[i + length];
                    System.out.println(
                            String.format("cost[%d][%d] = cost[%d][%d] " +
                                            "+ cost[%d][%d] + %d * %d * %d = %d",
                                    i, i + length, i, k, k + 1, i + length, dimensions[i - 1], dimensions[k], dimensions[i + length], temp));
                    if (cost[i][i + length] > temp) {
                        cost[i][i + length] = temp;
                        trace[i][i + length] = k;
                    }
                }

                System.out.println(String.format("Optimal value C[%d][%d] = %d", i, i + length, cost[i][i + length]));
            }
        }
        return printOptimalParenthesis(trace, 1, dimensions.length - 1);
    }

    private String printOptimalParenthesis(int[][] trace, int i, int j) {
        if (i == j)
            return Integer.toString(i);
        else {
            StringBuilder sb = new StringBuilder("(");
            sb.append(printOptimalParenthesis(trace, i, trace[i][j]));
            sb.append(printOptimalParenthesis(trace, trace[i][j] + 1, j));
            sb.append(")");
            return sb.toString();
        }
    }
}
