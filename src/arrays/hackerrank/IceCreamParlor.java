package arrays.hackerrank;

import java.util.*;

public class IceCreamParlor {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int cost[] = new int[n];
            for (int j = 0; j < n; j++)
                cost[j] = sc.nextInt();

            printIceCreamID(m, cost);
        }

    }

    private static void printIceCreamID(int m, int[] cost) {
        Map<Integer, Integer> IdCostMap = new HashMap<>();
        for (int i = 0; i < cost.length; i++)
            IdCostMap.put(i + 1, cost[i]);

        Arrays.sort(cost);

        List<Integer> sortedIDMapper
                = IdCostMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(() -> new ArrayList<Integer>(),
                        (al, entry) -> al.add(entry.getKey()),
                        (al1, al2) -> al1.addAll(al2));

        int low = 0;
        int high = cost.length - 1;

        while (low < high) {
            if (cost[low] + cost[high] == m) {
                String output = sortedIDMapper.get(low) > sortedIDMapper.get(high)
                        ? sortedIDMapper.get(high) + " " + sortedIDMapper.get(low) :
                        sortedIDMapper.get(low) + " " + sortedIDMapper.get(high);

                System.out.println(output);
                return;
            } else if (cost[low] + cost[high] > m) --high;
            else ++low;
        }
    }
}
