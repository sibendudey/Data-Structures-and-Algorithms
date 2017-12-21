package dynamic.programming.leetcode;

public class MaxProfitTrading {


    public static void main(String args[])  {
        int prices[] = {1,3,2,8,4,9};
        System.out.println(maxProfit(prices, 2));
    }

    public static long maxProfit(int[] prices, int fee) {
//        int dp[] = new int[prices.length + 1];
//        int max = 0;
//        dp[0] = 0;
//        // For selling it that day
//        dp[1] = 0;
//
//        for ( int i = 2; i <= prices.length ; i++)  {
//            dp[i] = dp[i-1];
//            for ( int j = 0 ; j < i - 1 ; j++ ) {
//                dp[i] = Math.max(dp[i] , dp[j] + prices[i-1] - (prices[j] + fee));
//                max = Math.max(dp[i], max);
//            }
//        }

        // O(n) solution
        int max = 0;
        for ( int i = 1 ; i < prices.length ; i++)
            if ( prices[i] > prices[i-1])
                max += prices[i] -( prices[i-1]);

        return max;

    }
}
