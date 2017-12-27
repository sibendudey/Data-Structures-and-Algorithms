package arrays.hackerrank;

import java.util.*;

public class MinimumLoss {
    public static void main(String args[])  {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long []prices = new long[N];
        for ( int i = 0 ; i < N ; i++)  {
            prices[i] = scanner.nextLong();
        }

        System.out.println(findMinimum(prices));
    }

    private static long findMinimum(long[] prices) {
        Map<Integer, Long> IdCostMap = new HashMap<>();
        for (int i = 0; i < prices.length; i++)
            IdCostMap.put(i + 1, prices[i]);

        Arrays.sort(prices);

        List<Integer> sortedIDMapper
                = IdCostMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(() -> new ArrayList<Integer>(),
                        (al, entry) -> al.add(entry.getKey()),
                        (al1, al2) -> al1.addAll(al2));


        int first = 1;
        long minimum = Integer.MAX_VALUE;
        while (first < prices.length )  {
            if ( first - (first - 1) > 0 && sortedIDMapper.get(first - 1) > sortedIDMapper.get(first))  {
                minimum = Math.min(prices[first] - prices[first - 1], minimum);
            }
            first++;
        }
        return minimum;
    }
}
