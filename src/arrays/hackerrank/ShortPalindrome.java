package arrays.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShortPalindrome {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();

        System.out.println(calculateShortPalin(next));
    }

    private static long calculateShortPalin(String next) {
        final Long mod = (long) Math.pow(10, 9) + 7;
        Map<Integer, Map<Character, Long>> charactersTillThisIndex = new HashMap<>();

        for (int i = 0; i < next.length(); i++) {
            if (i == 0) {
                charactersTillThisIndex.put(i, new HashMap<>());
                charactersTillThisIndex.get(i).put(next.charAt(i), 1L);
                continue;
            }
            charactersTillThisIndex.put(i, new HashMap<>());
            charactersTillThisIndex.get(i).putAll(charactersTillThisIndex.get(i - 1));
            charactersTillThisIndex.get(i).putIfAbsent(next.charAt(i), 0L);
            charactersTillThisIndex.get(i).put(next.charAt(i),
                    charactersTillThisIndex.get(i).get(next.charAt(i)) + 1);

        }

        long total = 0;
        for (int i = 0; i < next.length() - 3; i++) {
            for (int j = i + 3; j < next.length(); j++) {
                if (next.charAt(i) == next.charAt(j)) {
                    final int i_itr = i;
                    final int j_itr = j;
                    Map<Character, Long> difference =
                            charactersTillThisIndex.get(j - 1)
                                    .entrySet()
                                    .stream()
                                    .collect(Collectors.toMap(
                                            entry -> entry.getKey(),
                                            entry -> entry.getValue() -
                                                    charactersTillThisIndex.get(i_itr).
                                                            getOrDefault(entry.getKey(), 0L)));

                    total += difference.entrySet().stream()
                            .filter(entry -> entry.getValue() > 1)
                            .mapToLong(entry -> ((entry.getValue() * (entry.getValue() - 1)) / 2) % mod)
                            .sum() % mod;
                }
            }
        }

        return total;
    }
}
